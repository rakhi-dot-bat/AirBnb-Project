package com.rakhi.airBnbApp.dto;

import com.rakhi.airBnbApp.entity.HotelContactInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelDto {

    private Long id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    private String[] photos;

    private String[] amenities;

    private String city;

    private  Boolean active;

    @Valid
    private HotelContactInfo contactInfo;
}
