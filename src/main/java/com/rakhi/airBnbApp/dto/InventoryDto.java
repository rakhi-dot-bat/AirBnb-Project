package com.rakhi.airBnbApp.dto;

import com.rakhi.airBnbApp.entity.Hotel;
import com.rakhi.airBnbApp.entity.Room;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class InventoryDto {

    private Long id;

    private Integer bookedCount;

    private Integer totalCount;

    private BigDecimal surgeFactor;

    private BigDecimal price; //basePrice * surgeFactor

    private String city;

    private Boolean closed;

}
