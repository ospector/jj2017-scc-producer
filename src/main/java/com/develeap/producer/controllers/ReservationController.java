package com.develeap.producer.controllers;

import com.develeap.producer.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.develeap.producer.controllers.ReservationStatus.NOT_AVAILABLE;
import static com.develeap.producer.controllers.ReservationStatus.OK;

@Controller
@RequestMapping("/reserve")
public class ReservationController {
  @Autowired
  private ReservationService reservationService;
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ReservationResponse reserveArtwork(@RequestBody ReservationRequest req) {
    long reservationId = reservationService.reserveArtwork(req.getArtworkId());
    return new ReservationResponse(reservationId==0? NOT_AVAILABLE : OK, reservationId);
  }
}

