package com.covid19.tracker.service;

import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;

import java.util.List;

public interface TrackerService {

    public List<Country> getCountries();
    public Report getReportByCountryName(String name);
    public Report getReportByCountryCode(String code);
}
