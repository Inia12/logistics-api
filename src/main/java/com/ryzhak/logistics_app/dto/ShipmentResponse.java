package com.ryzhak.logistics_app.dto;

import com.ryzhak.logistics_app.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShipmentResponse {

    private Long id;

    private String clientName;

    private String address;

    private Status status;

    private LocalDateTime createdAt;
}