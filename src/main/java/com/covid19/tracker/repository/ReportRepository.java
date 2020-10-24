package com.covid19.tracker.repository;

import com.covid19.tracker.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, String> {
    public Optional<Report> findByCodeIgnoreCase(String code);
    public Optional<Report> findByCountryIgnoreCase(String name);
}
