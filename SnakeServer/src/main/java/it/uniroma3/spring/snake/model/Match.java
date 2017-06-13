package it.uniroma3.spring.snake.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	int score;
	long playingTime;
	int kills;
	@ManyToOne
	Player playedBy;
	
	public Match() {
		date = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getPlayingTime() {
		return playingTime;
	}
	public void setPlayingTime(long playingTime) {
		this.playingTime = playingTime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public Player getPlayedBy() {
		return playedBy;
	}
	public void setPlayedBy(Player playedBy) {
		this.playedBy = playedBy;
	}
}
