package com.latihan.latihanSpring.service;

import com.latihan.latihanSpring.dto.BiodataDto;
import com.latihan.latihanSpring.dto.PersonDto;
import com.latihan.latihanSpring.entity.PersonEntity;

public interface PersonService {
	PersonEntity getPerson();
	PersonEntity getById();
//	PersonEntity getDateById();
	PersonEntity inserPerson(PersonDto dto);
	PersonEntity insertPerson(BiodataDto dto);
	PersonEntity insertUmurMessage(BiodataDto dto);
	PersonEntity insertListPerson(BiodataDto dto);
	PersonEntity insertPersonService(BiodataDto dto);
	PersonEntity insertService(BiodataDto dto);
	PersonEntity update(PersonDto dto);
	PersonEntity delete();
	
	//DETAIL
	
	
	
}
