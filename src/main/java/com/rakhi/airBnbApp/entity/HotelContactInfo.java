package com.rakhi.airBnbApp.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class HotelContactInfo {

    private String address;

    @NotBlank(message = "phone number cannot blank")
    @Pattern(regexp = "^[0-9]{10}$",message = "must be valid 10 digit number")
    private String phoneNumber;

    @Email
    @NotBlank(message = "email cannot blank")
    private String email;

    private String location;
}
