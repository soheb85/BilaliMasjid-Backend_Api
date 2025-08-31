package com.example.bilalimasjid.services;

import com.example.bilalimasjid.dto.AllTimePrayerRequest;
import com.example.bilalimasjid.dto.ApiResponse;
import com.example.bilalimasjid.dto.PrayerTimeDto;
import com.example.bilalimasjid.entity.PrayerTime;
import com.example.bilalimasjid.repository.PrayerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAllTimePrayer {

    @Autowired
    private PrayerTimeRepository prayerTimeRepository;

    public ApiResponse processPrayerTime(String action, PrayerTimeDto prayerTimeDto){
        try {
            if ("I".equalsIgnoreCase(action)) {
                // Insert
                PrayerTime prayer = new PrayerTime();
                prayer.setPrayerName(prayerTimeDto.getPrayerName());
                prayer.setAzan(prayerTimeDto.getAzan());
                prayer.setJamat(prayerTimeDto.getJamat());
                prayer.setStart(prayerTimeDto.getStart());
                prayer.setEnd(prayerTimeDto.getEnd());
                prayerTimeRepository.save(prayer);

            } else if ("U".equalsIgnoreCase(action)) {
                // Update
                Optional<PrayerTime> existing = prayerTimeRepository.findById(prayerTimeDto.getId());
                if (existing.isPresent()) {
                    PrayerTime prayer = existing.get();
                    prayer.setPrayerName(prayerTimeDto.getPrayerName());
                    prayer.setAzan(prayerTimeDto.getAzan());
                    prayer.setJamat(prayerTimeDto.getJamat());
                    prayer.setStart(prayerTimeDto.getStart());
                    prayer.setEnd(prayerTimeDto.getEnd());
                    prayerTimeRepository.save(prayer);
                } else {
                    return new ApiResponse("404", "false", "Prayer Time not found");
                }

            } else if ("D".equalsIgnoreCase(action)) {
                // Delete
                prayerTimeRepository.deleteById(prayerTimeDto.getId());
            }

            return new ApiResponse("200", "true", "Operation Successful");

        } catch (Exception e){
            return new ApiResponse("400", "false", "Failed: " + e.getMessage());
        }
    }

    public AllTimePrayerRequest getPrayerRequest(){
        List<PrayerTime> prayers = prayerTimeRepository.findAll();
        AllTimePrayerRequest allTimePrayerRequest = new AllTimePrayerRequest();

        for (PrayerTime p : prayers){
            AllTimePrayerRequest.PrayerTimeDetails time = new AllTimePrayerRequest.PrayerTimeDetails();
            time.setAzan(p.getAzan());
            time.setJamat(p.getJamat());
            time.setStart(p.getStart());
            time.setEnd(p.getEnd());

            allTimePrayerRequest.getPrayers().put(p.getPrayerName(), time);
        }

        return allTimePrayerRequest;
    }
}
