package com.covid19.tracker.service;

import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;
import com.covid19.tracker.model.OverallReport;
import com.covid19.tracker.model.UpdateRequest;

import java.util.List;

public interface TrackerService {

    public List<Country> getCountries();

    public Report getReportByCountryName(String name);

    public Report getReportByCountryCode(String code);

    public void updateFavourite(String countryName, Boolean updateTo);

    public Report addComment(UpdateRequest request);

    public OverallReport fetchGlobalStats();
}
