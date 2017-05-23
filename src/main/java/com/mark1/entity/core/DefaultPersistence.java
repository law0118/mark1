package com.mark1.entity.core;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DefaultPersistence {
	
	protected long id;
	protected LogInformation logInformation = new LogInformation();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Embedded
	public LogInformation getLogInformation() {
		return logInformation;
	}

	public void setLogInformation(LogInformation logInformation) {
		this.logInformation = logInformation;
	}
	
	
	
}
