package com.rakhi.airBnbApp.controller;

import com.rakhi.airBnbApp.dto.HotelDto;
import com.rakhi.airBnbApp.entity.Hotel;
import com.rakhi.airBnbApp.exception.ResourceNotFoundException;
import com.rakhi.airBnbApp.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;
    private final ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody @Valid HotelDto hotelDto)
    {
        log.info("attempting to create a new hotel with name" +hotelDto.getName());
        HotelDto hotel = hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId)
    {
        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelDto);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotelById (@PathVariable Long hotelId, @RequestBody HotelDto hotelDto)
    {
        HotelDto response = hotelService.updateHotelById(hotelId,hotelDto);
        return  ResponseEntity.ok(response);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotelById (@PathVariable Long hotelId)
    {
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }



}
