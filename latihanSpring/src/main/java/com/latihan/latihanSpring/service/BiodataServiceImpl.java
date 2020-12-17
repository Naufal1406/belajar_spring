package com.latihan.latihanSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latihan.latihanSpring.dto.BiodataDto;
import com.latihan.latihanSpring.entity.DetailBiodataEntity;
import com.latihan.latihanSpring.entity.PersonEntity;
import com.latihan.latihanSpring.repository.DetailBiodataRepository;
import com.latihan.latihanSpring.repository.PersonRepository;


@Service
@Transactional
public class BiodataServiceImpl implements BiodataService{
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@Autowired 
	private PersonRepository personRepository;


	@Override
	public DetailBiodataEntity insertService(BiodataDto dto) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		personRepository.save(personEntity);
		detailBiodataEntity.setPersonEntity(personEntity);
		detailBiodataRepository.save(detailBiodataEntity);
			
		return detailBiodataEntity;
	}
	
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		return personEntity;
	}
	
	public DetailBiodataEntity convertToDetailBiodataEntity(BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setUmur(dto.getUmur());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		return detailBiodataEntity;
	}

	
}
