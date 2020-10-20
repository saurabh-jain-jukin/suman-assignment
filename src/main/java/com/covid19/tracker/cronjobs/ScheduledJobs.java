package com.covid19.tracker.cronjobs;

import com.covid19.tracker.config.ApplicationProperties;
import com.covid19.tracker.repository.CountryRepository;
import com.covid19.tracker.repository.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobs {
    private static final Logger log = LoggerFactory.getLogger(ScheduledJobs.class);

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Scheduled(cron = ApplicationProperties.CRON_EXPRESSION)
    public void clearDb() {
        log.info("Running scheduled jobs to clean stale data");
        reportRepository.deleteAll();
        countryRepository.deleteAll();
    }
}
