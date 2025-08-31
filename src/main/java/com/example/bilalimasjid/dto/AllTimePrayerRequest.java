package com.example.bilalimasjid.dto;

import com.example.bilalimasjid.entity.PrayerTime;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class AllTimePrayerRequest {

    private Map<String,PrayerTimeDetails> prayers = new HashMap<>();

    @Data
   public static class PrayerTimeDetails{
       private String azan;
       private String jamat;
       private String start;
       private String end;
   }
}
