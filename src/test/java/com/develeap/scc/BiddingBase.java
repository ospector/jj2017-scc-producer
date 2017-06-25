package com.develeap.scc;

import com.develeap.producer.controllers.ReservationController;
import com.develeap.producer.services.ReservationService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public abstract class BiddingBase {
  @Mock
  ReservationService reservationService;

	@InjectMocks
	ReservationController reservationController;

	@Before
	public void setup() {

    when(reservationService.reserveArtwork(Matchers.startsWith("no-"))).thenReturn(0L);
    when(reservationService.reserveArtwork(Matchers.matches("[0-9]+"))).thenReturn(123L);

		RestAssuredMockMvc.standaloneSetup(reservationController);
	}

}
