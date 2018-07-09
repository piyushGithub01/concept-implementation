package com.restapi.versioning.contentnegotiation.mapper;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.restapi.versioning.contentnegotiation.model.PersonCurrent;
import com.restapi.versioning.contentnegotiation.model.PersonOld;

@Component
public class PersonMapper {

	public PersonCurrent map(PersonOld person) {
		int age = Period.between(person.getBirthDate(), LocalDate.now()).getYears();
		return new PersonCurrent(person.getId(), person.getName(), person.getGender(), age);
	}
	
}
