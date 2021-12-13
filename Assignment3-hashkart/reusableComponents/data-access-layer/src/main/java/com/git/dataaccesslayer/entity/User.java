package com.git.dataaccesslayer.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id 
	@Column(name="id")
	private String id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="contact")
	private long contact;
	
	@Column(name="security_question")
	private String securityQuestion;
	
	@Column(name="answer")
	private String answer;

	public User() {
		super();
	}

	public User(String id, String username, String password, long contact, String securityQuestion, String answer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", contact=" + contact
				+ ", securityQuestion=" + securityQuestion + ", answer=" + answer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(answer, contact, id, password, securityQuestion, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(answer, other.answer) && contact == other.contact && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(securityQuestion, other.securityQuestion)
				&& Objects.equals(username, other.username);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
	
}
