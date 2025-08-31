package com.example.bilalimasjid.repository;

import com.example.bilalimasjid.entity.PrayerTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface PrayerTimeRepository extends JpaRepository<PrayerTime,Integer> {


}
