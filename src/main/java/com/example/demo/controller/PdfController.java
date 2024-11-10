package com.example.demo.controller;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class PdfController {

    @GetMapping("/download/kor")
    public ResponseEntity<Resource> downloadKorPdf() throws Exception {
        Path path = Paths.get("src/main/resources/templates/kor.pdf");
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=kor.pdf")
                .body(resource);
    }

    @GetMapping("/download/eng")
    public ResponseEntity<Resource> downloadEngPdf() throws Exception {
        Path path = Paths.get("src/main/resources/templates/eng.pdf");
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=eng.pdf")
                .body(resource);
    }
}

