package com.example.bilalimasjid.repository;

import com.example.bilalimasjid.entity.PrayerTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface PrayerTimeRepository extends JpaRepository<PrayerTime,Integer> {

    @Procedure(procedureName = "sp_manage_prayer_time")
    void managePrayerTime(
            String p_action,
            Integer p_id,
            String p_prayer_name,
            String p_azan,
            String p_jamat,
            String p_start,
            String p_end
    );

    List<PrayerTime> findAll();
}
