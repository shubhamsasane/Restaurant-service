package com.tmc.reservation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tmc.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "booking_end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp bookingEndTime;

    @Column(name = "booking_start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp bookingStartTime;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private RestaurantTable restaurantTable;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Restaurant restaurant;
}
