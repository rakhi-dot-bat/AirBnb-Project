package com.rakhi.airBnbApp.service;

import com.rakhi.airBnbApp.dto.HotelDto;
import com.rakhi.airBnbApp.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id, HotelDto hotelDto);
    Boolean deleteHotelById(long id);

}
