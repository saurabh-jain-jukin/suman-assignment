package com.covid19.tracker

import com.covid19.tracker.entity.Country
import com.covid19.tracker.entity.Report
import com.covid19.tracker.serviceImpl.ExternalDataQueryServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TrackerSpec extends Specification {

    @Autowired
    ExternalDataQueryServiceImpl service;

    def "fetch data from rapid API"() {
        when:
        List<Report> response = service.fetchData("IT")
        then:
        noExceptionThrown()
        response
    }

    def "fetch country list"() {
        when:
        List<Country> response = service.fetchCountryList()

        then:
        noExceptionThrown()
        !response.isEmpty()
    }
}
