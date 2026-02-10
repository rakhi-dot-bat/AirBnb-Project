package com.rakhi.airBnbApp.service;

import com.rakhi.airBnbApp.dto.HotelDto;
import com.rakhi.airBnbApp.entity.Hotel;
import com.rakhi.airBnbApp.exception.ResourceNotFoundException;
import com.rakhi.airBnbApp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("create a new hotel with name: {}",hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created new hotel with id : {}",hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class) ;
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with id : {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("hotel not found with id :"+id));
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating hotel with id "+id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel does not exists with id "+id));
        modelMapper.map(hotelDto , hotel);
        hotel= hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);

    }

    @Override
    public Boolean deleteHotelById(long id) {
        log.info("Deleting hotel with id : "+id);
        boolean exists = hotelRepository.existsById(id);
        if(!exists) throw  new ResourceNotFoundException("Hotel doesn't exists with id :"+id) ;
        hotelRepository.deleteById(id);
        return true;
        //TODO : delete the future inventories for this hotel
    }

    @Override
    public void activateHotel(Long id) {
        log.info("activating the  hotel with id "+id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel does not exists with id "+id));
        hotel.setActive(true);

        //todo: create inventory for all the rooms for this hotel

    }
}
