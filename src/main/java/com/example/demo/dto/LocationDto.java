package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private double latitude;
    private double longitude;
    private String now;
    private LocalDateTime expect;
    private boolean isLoaded; // 선적여부
    private LocalDateTime arrival; // 이때 반드시 도착해야하는 시간
    private int loadingPort;
    private int unloadingPort;

}
