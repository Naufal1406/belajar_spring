package com.latihan.latihanSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latihan.latihanSpring.dto.BiodataDto;
import com.latihan.latihanSpring.dto.PersonDto;
import com.latihan.latihanSpring.entity.DetailBiodataEntity;
import com.latihan.latihanSpring.entity.PersonEntity;
import com.latihan.latihanSpring.repository.DetailBiodataRepository;
import com.latihan.latihanSpring.repository.PersonRepository;


//JANGAN LUPA ANOTASI SERVICE SAMA TRANSACTIONALNYA !!!!
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	
	@Override
	public PersonEntity insertPersonService(BiodataDto dto) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = convertToPersonEntity(dto);
		personRepository.save(personEntity);
		return personEntity;
	}
	
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		return personEntity;
	}

	@Override
	public PersonEntity getPerson() {
		// TODO Auto-generated method stubList
		<PersonEntity> personEntities = personRepository.findAll();
		return personEntities;
	}

	@Override
	public PersonEntity getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity inserPerson(PersonDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity insertPerson(BiodataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity insertUmurMessage(BiodataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity insertListPerson(BiodataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity insertService(BiodataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity update(PersonDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity delete() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
