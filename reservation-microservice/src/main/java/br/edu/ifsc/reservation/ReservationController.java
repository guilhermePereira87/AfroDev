package br.edu.ifsc.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	//Display all reservations
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public List getAllReservations() {
		return reservationService.getAllReservations();
	}

	//Display ONE reservation
	//@RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET)
	//public Reservation getReservation(@PathVariable Long id) {
		//return reservationService.getReservation(id);
	//}
	
	//Create reservation
	@RequestMapping(value="/newreservation", method = RequestMethod.POST)
	public void addReservation(@RequestBody Reservation reservation) {
		reservationService.addReservation(reservation);
	}
	
	//Update reservation
	@RequestMapping(value="/updatereservation/{id}", method = RequestMethod.PUT)
	public void updateReservation(@RequestBody Reservation reservation,
			@PathVariable String id) {
		long parseId = Long.parseLong(id);
		reservationService.updateReservation(parseId, reservation);
	}
	
	//Delete reservation
	@RequestMapping(value = "/removereservation/{id}", method = RequestMethod.DELETE)
	public void deleteReservation(@PathVariable String id) {
		long parseId = Long.parseLong(id);
		reservationService.deleteReservation(parseId);
	}


}
