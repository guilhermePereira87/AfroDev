package br.edu.ifsc.reservation;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="restaurant_id")
	private Long restaurantId;
	
	@Column(name="party_size")
	private int partySize;

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public Reservation() {}
	
	public Reservation(Long id, Long userId, int partySize) {
		this.id = id;
		this.userId = userId;
		this.partySize = partySize;
	}

}
