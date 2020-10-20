package com.covid19.tracker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    //    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'+'ZZ:ZZ", shape = JsonFormat.Shape.STRING)
    private String lastChange;
    private String lastUpdate;

    private Boolean favourite = false;

    @OneToMany(mappedBy = "report", cascade = {CascadeType.ALL})
    private List<Comment> comments;
}
