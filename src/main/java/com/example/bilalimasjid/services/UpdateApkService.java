package com.example.bilalimasjid.services;

import com.example.bilalimasjid.dto.UpdateApkDTO;
import com.example.bilalimasjid.entity.UpdateApk;
import com.example.bilalimasjid.repository.UpdateApkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateApkService {

    @Autowired
    private UpdateApkRepository updateApkRepository;

    public String save(UpdateApkDTO updateApkDTO) {
        try {
            UpdateApk updateApk = new UpdateApk();
            updateApk.setVersion(updateApkDTO.getVersion());
            updateApk.setApk_url(updateApkDTO.getApk_url());
            updateApk.setChangeLog(updateApkDTO.getChangeLog());

            updateApkRepository.save(updateApk);
        } catch (Exception e) {
            return "Failed to Add Update Details: " + e.getMessage();
        }
        return "Added Update Apk Details";
    }


    public UpdateApkDTO get(Long id) {
        UpdateApk updateApk = updateApkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("APK not found with ID: " + id));

        return new UpdateApkDTO(
                updateApk.getVersion(),
                updateApk.getApk_url(),
                updateApk.getChangeLog()
        );
    }

    public String update(Long id, UpdateApkDTO updateApkDTO) {
        try {
            UpdateApk existingApk = updateApkRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("APK not found with ID: " + id));

            // Update the fields
            existingApk.setVersion(updateApkDTO.getVersion());
            existingApk.setApk_url(updateApkDTO.getApk_url());
            existingApk.setChangeLog(updateApkDTO.getChangeLog());

            // Save the updated entity
            updateApkRepository.save(existingApk);
            return "APK updated successfully";
        } catch (Exception e) {
            return "Failed to update APK: " + e.getMessage();
        }
    }
}
