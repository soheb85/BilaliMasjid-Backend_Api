package com.example.bilalimasjid.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prayer_time")
@Data
public class PrayerTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prayerName;
    private String azan;
    private String jamat;
    private String start;
    private String end;
}