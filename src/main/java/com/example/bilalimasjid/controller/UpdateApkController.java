package com.example.bilalimasjid.controller;

import com.example.bilalimasjid.dto.UpdateApkDTO;
import com.example.bilalimasjid.entity.UpdateApk;
import com.example.bilalimasjid.services.UpdateApkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
@CrossOrigin()
public class UpdateApkController {

    @Autowired
    private UpdateApkService updateApkService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UpdateApkDTO updateApkDTO){
        return ResponseEntity.ok(updateApkService.save(updateApkDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UpdateApkDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(updateApkService.get(id));
    }

    @PutMapping("/new-update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UpdateApkDTO updateApkDTO){
        return ResponseEntity.ok(updateApkService.update(id, updateApkDTO));
    }
}

