package com.rakhi.airBnbApp.service;


import com.rakhi.airBnbApp.dto.HotelDto;
import com.rakhi.airBnbApp.dto.HotelSearchRequest;
import com.rakhi.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);
    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
