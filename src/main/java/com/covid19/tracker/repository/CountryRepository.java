package com.covid19.tracker.repository;

import com.covid19.tracker.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
