package com.latihan.latihanSpring.service;

import com.latihan.latihanSpring.dto.BiodataDto;
import com.latihan.latihanSpring.entity.PersonEntity;

public interface PersonService {
	PersonEntity insertPersonService(BiodataDto dto);
}
