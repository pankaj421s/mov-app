package com.example.kafkaapp.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
@Entity
@RedisHash
public class Movie implements Serializable{
	@Id
	private long id;
	private String name;
	private double rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	

}
