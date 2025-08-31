package com.example.bilalimasjid.controller;


import com.example.bilalimasjid.dto.AllTimePrayerRequest;
import com.example.bilalimasjid.dto.ApiResponse;
import com.example.bilalimasjid.dto.PrayerTimeDto;
import com.example.bilalimasjid.services.GetAllTimePrayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin()
@RestController
@RequestMapping("/api/prayers")
public class PrayerTimeController {

    @Autowired
    private GetAllTimePrayer getAllTimePrayer;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> savePrayerTime(@RequestBody PrayerTimeDto prayerTimeDto){
        ApiResponse apiResponse = getAllTimePrayer.processPrayerTime("I",prayerTimeDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePrayerTime(@RequestBody PrayerTimeDto dto) {
        ApiResponse apiResponse = getAllTimePrayer.processPrayerTime("U", dto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrayerTime(@PathVariable Integer id) {
        PrayerTimeDto dto = new PrayerTimeDto();
        dto.setId(id);
        getAllTimePrayer.processPrayerTime("D", dto);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<AllTimePrayerRequest> getAllPrayerTimes() {
        AllTimePrayerRequest dto = getAllTimePrayer.getPrayerRequest();
        return ResponseEntity.ok(dto);
    }

}
