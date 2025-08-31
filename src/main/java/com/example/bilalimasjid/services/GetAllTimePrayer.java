package com.example.bilalimasjid.services;

import com.example.bilalimasjid.dto.AllTimePrayerRequest;
import com.example.bilalimasjid.dto.ApiResponse;
import com.example.bilalimasjid.dto.PrayerTimeDto;
import com.example.bilalimasjid.entity.PrayerTime;
import com.example.bilalimasjid.repository.PrayerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTimePrayer {

    @Autowired
    private PrayerTimeRepository prayerTimeRepository;

    public ApiResponse processPrayerTime(String action, PrayerTimeDto prayerTimeDto){
        try{
            prayerTimeRepository.managePrayerTime(
                    action,
                    prayerTimeDto.getId(),
                    prayerTimeDto.getPrayerName(),
                    prayerTimeDto.getAzan(),
                    prayerTimeDto.getJamat(),
                    prayerTimeDto.getStart(),
                    prayerTimeDto.getEnd()
            );
            return new ApiResponse(
                    "200",
                    "true",
                    "Saved Successfully"
            );

        } catch (Exception e){
            return  new ApiResponse(
                    "400",
                    "false",
                    "Failed to Saved"
            );
        }
    }

    public AllTimePrayerRequest getPrayerRequest(){
        List<PrayerTime> prayers = prayerTimeRepository.findAll();

        AllTimePrayerRequest allTimePrayerRequest = new AllTimePrayerRequest();

        for(PrayerTime p : prayers){
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
