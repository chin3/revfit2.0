package com.revature.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WeightArchive {

	@Id
	@GeneratedValue
	@Column(name = "archive_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(columnDefinition = "NUMBER(10, 3)")
	private double weight;
	
	@Column(name = "date_updated")
	private Date date;
	
	public WeightArchive(int id, User user, double weight, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.weight = weight;
		this.date = date;
	}
	
	public WeightArchive(User user, double weight, Date date) {
		super();
		this.user = user;
		this.weight = weight;
		this.date = date;
	}

	public WeightArchive() {
		super();
	}

	public User getUser() {
		return user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "WeightArchive [id=" + id + ", user=" + user + ", weight=" + weight + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightArchive other = (WeightArchive) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
}
