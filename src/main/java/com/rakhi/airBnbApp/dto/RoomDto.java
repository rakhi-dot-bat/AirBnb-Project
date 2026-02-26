package com.rakhi.airBnbApp.dto;

import com.rakhi.airBnbApp.entity.Hotel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class RoomDto {

    private  Long id;

    @NotEmpty(message = "type of room cannot be empty")
    private String type;

    @NotEmpty(message = "baseprice of room cannot be EMPTY")
    private BigDecimal basePrice;

    private String[] photos;

    private String[] amenities;

    private Integer totalCount;

    private Integer capacity;

}
