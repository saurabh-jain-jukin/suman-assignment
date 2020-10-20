package com.covid19.tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    private String name;
    private String alpha2code;
    private String alpha3code;
    private Double latitude;
    private Double longitude;
}
