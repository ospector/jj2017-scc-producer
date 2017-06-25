package com.develeap.producer.controllers;

import lombok.Data;

@Data
public class ReservationResponse {
  private final ReservationStatus status;
  private final long reservationId;
}
