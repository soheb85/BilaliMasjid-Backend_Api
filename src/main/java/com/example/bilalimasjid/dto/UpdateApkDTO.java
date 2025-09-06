package com.example.bilalimasjid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApkDTO {

    private String version;
    private String apk_url;
    private String changeLog;
}
