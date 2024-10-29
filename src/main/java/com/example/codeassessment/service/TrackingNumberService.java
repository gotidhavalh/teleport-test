package com.example.codeassessment.service;


import com.example.codeassessment.model.TrackingNumberResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TrackingNumberService {

    private final AtomicLong counter = new AtomicLong();

    public TrackingNumberResponse generateTrackingNumber(
            String originCountryId,
            String destinationCountryId,
            double weight,
            OffsetDateTime createdAt,
            String customerId,
            String customerName,
            String customerSlug) {

        String trackingNumber;

        do {
            String uniqueId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            trackingNumber = String.format("%s%s%s", originCountryId, destinationCountryId, uniqueId);
            if (trackingNumber.matches("^[A-Z0-9]{1,16}$")){
                return new TrackingNumberResponse(trackingNumber, createdAt);
            }
        } while (true);
    }
}
