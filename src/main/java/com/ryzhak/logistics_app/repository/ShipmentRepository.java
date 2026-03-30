package com.ryzhak.logistics_app.repository;

import com.ryzhak.logistics_app.model.Shipment;
import com.ryzhak.logistics_app.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    List<Shipment> findByClientNameIgnoreCase(String clientName);

    List<Shipment> findByStatus(Status status);

}