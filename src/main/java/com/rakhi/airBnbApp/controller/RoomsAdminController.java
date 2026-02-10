package com.rakhi.airBnbApp.controller;

import com.rakhi.airBnbApp.dto.RoomDto;
import com.rakhi.airBnbApp.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/admin/hotels/{hotelId}/rooms")
public class RoomsAdminController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId, @RequestBody RoomDto roomDto)
    {
        log.info("Attempting to create a room with hotel id {}",+hotelId);
        RoomDto room = roomService.createNewRoom(hotelId, roomDto);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRoomsInHotel(@PathVariable Long hotelId)
    {
        return ResponseEntity.ok(roomService.getAllRoomsInHotel(hotelId));
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long hotelId, @PathVariable Long roomId)
    {
        RoomDto roomDto = roomService.getRoomById(roomId);
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long hotelId , @PathVariable Long roomId)
    {
        roomService.deleteRoomById(roomId);
        return  ResponseEntity.noContent().build();
    }


}
