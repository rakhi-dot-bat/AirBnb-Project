package com.rakhi.airBnbApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Booking {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "hotel_Id", nullable = false)
private Hotel hotel;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "room_Id", nullable = false)
private Room room;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name= "user_Id", nullable = false)
private User user;

@CreationTimestamp
private LocalDateTime createdAt;

@UpdateTimestamp
private LocalDateTime updatedAt;

@Enumerated(value = EnumType.STRING)
@Column(nullable = false)
private BookingStatus BookingStatus;

@Column(nullable = false)
private LocalDate checkInDate;

@Column(nullable = false)
private LocalDate checkOutDate;

@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "payment_Id")
private Payment payment;

@Column(nullable = false)
private Integer roomsCount;

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "booking_guest")
    private Set<Guest> guests;
}
