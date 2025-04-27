package com.HotelService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.util.function.ThrowingSupplier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    @GetMapping()
    public ResponseEntity<Object[]> getAllHotels() {
        return "List of all hotels";
    }

    @GetMapping("/rooms")
    public ResponseEntity<Object[]> getAllRooms() {
        return "List of all hotels";
    }

    @GetMapping("/rooms/{hotelId}")
    public ResponseEntity<Object[]> getRoomDetails() {
        return "List of all hotels";
    }

    @PostMapping()
    public ResponseEntity<HotelResponse> createHotel() {
        return  handleRequestProcess(() -> {
            return HotelResponse.builder().message("Hotel created successfully").build();
        });
    }

    @PostMapping("/rooms/{hotelId}")
    public ResponseEntity<HotelResponse> createRooms() {
        return  handleRequestProcess(() -> {
            return HotelResponse.builder().message("Hotel created successfully").build();
        });
    }

    @PatchMapping("/rooms/{hotelId}")
    public ResponseEntity<HotelResponse> modifyRooms() {
        return handleRequestProcess(() -> {
            return HotelResponse.builder().message("Room created successfully").build();
        });
    }

    private ResponseEntity<HotelResponse> handleRequestProcess(ThrowingSupplier<HotelResponse> supplier) {
        try {
            return ResponseEntity.ok(supplier.get());
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body(HotelResponse.builder().message("Error to send email").build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(HotelResponse.builder().message("Internal Server Error").build());
        }
    }
}
