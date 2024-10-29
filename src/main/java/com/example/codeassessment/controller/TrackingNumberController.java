package com.example.codeassessment.controller;

import com.example.codeassessment.model.TrackingNumberResponse;
import com.example.codeassessment.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RestController
public class TrackingNumberController {

    @Autowired
    private TrackingNumberService trackingNumberService;

    @GetMapping("/next-tracking-number")
    public TrackingNumberResponse getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("vyyyy-MM-dd'T'HH:mm:ssX");
//        OffsetDateTime createdAt = OffsetDateTime.parse(created_at, formatter);

        LocalDateTime createdAt = LocalDateTime.parse(created_at);
        OffsetDateTime offsetCreatedAt = createdAt.atOffset(ZoneOffset.UTC);

        return trackingNumberService.generateTrackingNumber(origin_country_id, destination_country_id, weight, offsetCreatedAt, customer_id, customer_name, customer_slug);
    }
}
