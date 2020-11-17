package br.edu.ifsc.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List getAllReservations() {
		
		List reservations = new ArrayList<>();
		reservationRepository.findAll().forEach(reservations::add);
		
		return reservations;
	}
	
	//Retrieving one row based on id
	public Optional<Reservation> getReservation(Long id) {
		return reservationRepository.findById(id);
	}
	
	//saves new reservation and returns it
	public Reservation addReservation(Reservation reservation) {
		Reservation conferesReservation = reservation;
		reservationRepository.save(reservation);
		return conferesReservation;
	}
	//updates data in a row and return it
	public Reservation updateReservation(Long id, Reservation reservation) {
		
		Reservation updatedReservation = reservation;
		reservationRepository.save(reservation);
		return updatedReservation;
	}
	
	//deletes row from table
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	

}
