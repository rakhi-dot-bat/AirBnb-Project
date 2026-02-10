package com.rakhi.airBnbApp.service;

import com.rakhi.airBnbApp.dto.RoomDto;
import com.rakhi.airBnbApp.entity.Hotel;
import com.rakhi.airBnbApp.entity.Room;
import com.rakhi.airBnbApp.exception.ResourceNotFoundException;
import com.rakhi.airBnbApp.repository.HotelRepository;
import com.rakhi.airBnbApp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RoomServiceImpl implements  RoomService{

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("creating a new room with hotel id {}",+hotelId);

        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("no such hotel present with id :"+hotelId));

        Room room = modelMapper.map(roomDto,Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        //todo: create inventory as soon as room is created and if hotel is active

        return modelMapper.map(room , RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("getting all rooms in hotel with id :"+hotelId);

        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("hotel not found with id :"+hotelId));


        return hotel
                .getRooms()
                .stream()
                .map(room -> modelMapper.map(room,RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("fetching room details for id {}",+roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(()->new ResourceNotFoundException("room not found with ID :"+roomId)) ;


        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        log.info("deleting room with id :"+roomId);

        boolean exists = roomRepository.existsById(roomId);
        if(!exists) throw  new ResourceNotFoundException("room does not exists with id :"+roomId);

        roomRepository.deleteById(roomId);

        //todo: delete all future inventories for this room
    }
}
