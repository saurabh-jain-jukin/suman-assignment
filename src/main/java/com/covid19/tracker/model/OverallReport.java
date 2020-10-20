package com.covid19.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OverallReport {
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private String lastChange;
    private String lastUpdate;
    private Integer critical;
}
