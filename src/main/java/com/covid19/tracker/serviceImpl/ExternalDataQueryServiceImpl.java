package com.covid19.tracker.serviceImpl;

import com.covid19.tracker.config.ApplicationProperties;
import com.covid19.tracker.entity.Country;
import com.covid19.tracker.entity.Report;
import com.covid19.tracker.exception.ItemNotFoundException;
import com.covid19.tracker.model.OverallReport;
import com.covid19.tracker.service.ExternalDataQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ExternalDataQueryServiceImpl implements ExternalDataQueryService {
    private static final Logger log = LoggerFactory.getLogger(ExternalDataQueryServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationProperties properties;

    public List<Report> fetchDataByCountryCode(String countryCode) {
        UriComponentsBuilder uri = UriComponentsBuilder
                .fromUriString(properties.getRapidApiUrl())
                .pathSegment("country", "code")
                .queryParam("code", countryCode);
        try {
            return restTemplate
                    .exchange(uri.toUriString(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Report>>() {
                            }).getBody();
        } catch (Exception ex) {
            log.error("exception happened while making external API call", ex);
            throw new ItemNotFoundException("exception happened while making external API call");
        }
    }

    public List<Country> fetchCountryList() {
        UriComponentsBuilder uri = UriComponentsBuilder
                .fromUriString(properties.getRapidApiUrl())
                .pathSegment("help", "countries");
        try {
            return restTemplate
                    .exchange(uri.toUriString(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Country>>() {
                            }).getBody();
        } catch (Exception ex) {
            log.error("exception happened while making external API call", ex);
            throw new ItemNotFoundException("exception happened while making external API call");
        }
    }

    public List<Report> fetchDataByCountryName(String name) {
        UriComponentsBuilder uri = UriComponentsBuilder
                .fromUriString(properties.getRapidApiUrl())
                .pathSegment("country")
                .queryParam("name", name);
        try {
            return restTemplate
                    .exchange(uri.toUriString(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Report>>() {
                            }).getBody();
        } catch (Exception ex) {
            log.error("exception happened while making external API call", ex);
            throw new ItemNotFoundException("exception happened while making external API call");
        }
    }

    public List<OverallReport> fetchOverAllStats() {
        UriComponentsBuilder uri = UriComponentsBuilder
                .fromUriString(properties.getRapidApiUrl())
                .pathSegment("totals");
        try {
            return restTemplate
                    .exchange(uri.toUriString(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<OverallReport>>() {
                            }).getBody();
        } catch (Exception ex) {
            log.error("exception happened while making external API call", ex);
            throw new ItemNotFoundException("exception happened while making external API call");
        }
    }
}
