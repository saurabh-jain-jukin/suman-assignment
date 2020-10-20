package com.covid19.tracker.repository;

import com.covid19.tracker.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, String> {
    public Optional<Report> findByCode(String code);
}
