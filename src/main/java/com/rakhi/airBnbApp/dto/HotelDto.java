package com.rakhi.airBnbApp.dto;

import com.rakhi.airBnbApp.entity.HotelContactInfo;
import lombok.Data;

@Data
public class HotelDto {

    private Long id;

    private String name;

    private String[] photos;

    private String[] amenities;

    private String city;

    private  Boolean active;

    private HotelContactInfo contactInfo;
}
