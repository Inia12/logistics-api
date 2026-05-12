package com.ryzhak.logistics_app.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;



@Entity
@Getter
@Setter
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Client name cannot be empty")
    private String clientName;

    @NotBlank(message = "Address cannot be empty")
    private String address;
    private Status status;
    private LocalDateTime createdAt;
}