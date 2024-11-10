package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDto {
    private String address;
    private LocalDate toreply;
    private String title;
    private String message;
    private MultipartFile attachment1;
    private MultipartFile attachment2;
}