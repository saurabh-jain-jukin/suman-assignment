package com.covid19.tracker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report")
public class Report {
    @Id
    @Column(name = "country")
    private String country;
    private String code;
    private Integer confirmed;
    private Integer recovered;
    private Integer critical;
    private Integer deaths;
    private Double latitude;
    private Double longitude;
    private String lastChange;
    private String lastUpdate;
    private Boolean favourite = false;
    @ElementCollection
    private List<String> comments = new ArrayList<>();
}
