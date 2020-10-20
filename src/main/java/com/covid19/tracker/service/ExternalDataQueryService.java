package com.covid19.tracker.service;

import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;
import com.covid19.tracker.model.OverallReport;

import java.util.List;

public interface ExternalDataQueryService {
    public List<Report> fetchDataByCountryCode(String countryCode);

    public List<Country> fetchCountryList();

    public List<Report> fetchDataByCountryName(String name);

    public List<OverallReport> fetchOverAllStats();

}
