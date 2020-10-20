package com.covid19.tracker.controller;

import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;
import com.covid19.tracker.model.OverallReport;
import com.covid19.tracker.serviceImpl.TrackerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private TrackerServiceImpl service;

    @GetMapping("/getCountryList")
    public List<Country> getCountryList() {
        return service.getCountries();
    }

    @GetMapping("/getDataByCountryName")
    public Report getDataByCountryName(@RequestParam String country) {
        return service.getReportByCountryName(country.toLowerCase());
    }

    @GetMapping("/getDataByCountryCode")
    public Report getDataByCountryCode(@RequestParam String code) {
        return service.getReportByCountryCode(code);
    }

    @GetMapping("/getOverAllReport")
    public OverallReport getOverallReport() {
        return service.fetchGlobalStats();
    }
}
