package com.covid19.tracker.serviceImpl;

import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;
import com.covid19.tracker.exception.ItemNotFoundException;
import com.covid19.tracker.model.OverallReport;
import com.covid19.tracker.model.UpdateRequest;
import com.covid19.tracker.repository.CountryRepository;
import com.covid19.tracker.repository.ReportRepository;
import com.covid19.tracker.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TrackerServiceImpl implements TrackerService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ExternalDataQueryServiceImpl dataQueryService;
    @Autowired
    private ReportRepository reportRepository;

    public List<Country> getCountries() {
        List<Country> result = countryRepository.findAll();
        if (result.isEmpty()) {
            result = dataQueryService.fetchCountryList();
        }
        if (CollectionUtils.isEmpty(result)) {
            throw new ItemNotFoundException("No data found");
        }
        countryRepository.saveAll(result);
        return result;
    }

    public Report getReportByCountryName(String name) {
        return reportRepository.findByCountryIgnoreCase(name).orElseGet(() -> {
            AtomicReference<Report> report = new AtomicReference<>(null);
            dataQueryService.fetchDataByCountryName(name).stream().findFirst().ifPresent(
                    it -> {
                        reportRepository.save(it);
                        report.set(it);
                    });
            return Optional.ofNullable(report.get()).orElseThrow(() -> new ItemNotFoundException("No data found"));
        });
    }

    public Report getReportByCountryCode(String code) {
        return reportRepository.findByCodeIgnoreCase(code).orElseGet(() -> {
            AtomicReference<Report> report = new AtomicReference<>(null);
            dataQueryService.fetchDataByCountryCode(code).stream().findFirst().ifPresent(
                    it -> {
                        reportRepository.save(it);
                        report.set(it);
                    });
            return Optional.ofNullable(report.get()).orElseThrow(() -> new ItemNotFoundException("No data found"));
        });
    }

    public OverallReport fetchGlobalStats() {
        return dataQueryService.fetchOverAllStats().stream().findFirst().orElseThrow(() -> new ItemNotFoundException("No data found"));
    }

    public void updateFavourite(String countryName, Boolean updateTo) {
        reportRepository.findByCountryIgnoreCase(countryName).ifPresent(it -> {
            it.setFavourite(updateTo);
            reportRepository.save(it);
        });
    }

    public Report addComment(UpdateRequest request) {
        Report data = reportRepository.findByCountryIgnoreCase(request.getCountryName()).orElseThrow(() -> new ItemNotFoundException("request failed to process, no such country found"));
        List<String> comments = Optional.ofNullable(data.getComments()).orElseGet(ArrayList::new);
        comments.add(request.getComment());
        data.setComments(comments);
        return reportRepository.save(data);
    }
}
