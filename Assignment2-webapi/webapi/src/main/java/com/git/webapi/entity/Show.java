package com.git.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`show`")
public class Show {
	
	@Id
	@Column(name="show_id")
	private String showId;
	
	
	@Column(name="type")
	private String type;
	
	@Column(name="title")
	private String title;
	
	@Column(name="director")
	private String director;
	
	@Column(name="cast")
	private String cast;
	
	@Column(name="country")
	private String country;
	
	@Column(name="date_added")
	private String dateAdded;
	
	@Column(name="release_year")
	private int releaseYear;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="listedIn")
	private String listedIn;
	
	@Column(name="description")
	private String description;
	
	public Show() {
		super();
	}
	
	public Show(String showId, String type, String title, String director, String cast, String country,
			String dateAdded, int releaseYear, String rating, String duration, String listedIn, String description) {
		super();
		this.showId = showId;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.dateAdded = dateAdded;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.duration = duration;
		this.listedIn = listedIn;
		this.description = description;
	}
	
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getListedIn() {
		return listedIn;
	}
	public void setListedIn(String listedIn) {
		this.listedIn = listedIn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((listedIn == null) ? 0 : listedIn.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + ((showId == null) ? 0 : showId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Show other = (Show) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (listedIn == null) {
			if (other.listedIn != null)
				return false;
		} else if (!listedIn.equals(other.listedIn))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (showId == null) {
			if (other.showId != null)
				return false;
		} else if (!showId.equals(other.showId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", type=" + type + ", title=" + title + ", director=" + director + ", cast="
				+ cast + ", country=" + country + ", dateAdded=" + dateAdded + ", releaseYear=" + releaseYear
				+ ", rating=" + rating + ", duration=" + duration + ", listedIn=" + listedIn + ", description="
				+ description + "]";
	}
	
}
