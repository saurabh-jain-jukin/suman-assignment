package com.covid19.tracker.controller;

import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;
import com.covid19.tracker.model.OverallReport;
import com.covid19.tracker.model.UpdateRequest;
import com.covid19.tracker.service.TrackerService;
import com.covid19.tracker.serviceImpl.TrackerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private TrackerService service;

    @Autowired
    public Controller(TrackerServiceImpl trackerService){
        service = trackerService;
    }

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

    @PutMapping("/updateFavourite")
    public void updateFavourite(@RequestParam String countryName, @RequestParam Boolean updateTo) {
        service.updateFavourite(countryName, updateTo);
    }

    @PutMapping("/addComment")
    public Report addComment(@RequestBody UpdateRequest request) {
        return service.addComment(request);
    }

}
