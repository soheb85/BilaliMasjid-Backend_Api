package com.example.bilalimasjid.dto;

import lombok.Data;

@Data
public class PrayerTimeDto {
    private Integer id;
    private String prayerName;
    private String azan;
    private String jamat;
    private String start;
    private String end;
}
