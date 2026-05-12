package com.ryzhak.logistics_app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentRequest {

    @NotBlank(message = "Client name cannot be empty")
    private String clientName;

    @NotBlank(message = "Address cannot be empty")
    private String address;
}