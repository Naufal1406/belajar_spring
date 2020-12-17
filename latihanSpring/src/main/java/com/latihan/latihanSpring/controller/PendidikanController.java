package com.latihan.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.latihanSpring.dto.BiodataDto;
import com.latihan.latihanSpring.dto.PendidikanDto;
import com.latihan.latihanSpring.entity.DetailBiodataEntity;
import com.latihan.latihanSpring.entity.PendidikanEntity;
import com.latihan.latihanSpring.entity.PersonEntity;
import com.latihan.latihanSpring.repository.DetailBiodataRepository;
import com.latihan.latihanSpring.repository.PendidikanRepository;
import com.latihan.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PendidikanController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PendidikanRepository pendidikanRepository;
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	//GET
	@GetMapping("/get-pendidikan") //LIST kayaknya dipake buat ngambil datanya aja tanpa ada interaksi sama user
	public List<PendidikanEntity> getPendidikan(){
		List<PendidikanEntity> pendidikanEntities = pendidikanRepository.findAll();
		return pendidikanEntities;
	}
	
	//GET MAPPING BERDASARKAN ID PENDIDIKAN
	@GetMapping("get-pendidikan-byIdPendidikan/{idPendidikan}")
	public List<PendidikanEntity> getPendidikanByIdPendidikan(@PathVariable Integer idPendidikan){
		List<PendidikanEntity> pendidikanEntities = pendidikanRepository.findByIdPendidikan(idPendidikan);
		return pendidikanEntities;
	}
	
	//GET MAPPING BERDASARKAN ID PERSON
	@GetMapping("/get-pendidikan-byIdPerson/{idPerson}")
	public List<PendidikanEntity> getPendidikanByIdPerson(@PathVariable Integer idPerson){
		List<PendidikanEntity> pendidikanEntities = pendidikanRepository.findByIdPerson(idPerson);
		return pendidikanEntities;
	}
	
	//POST
	@PostMapping("/post-pendidikan")
	public ResponseEntity<?> insertPendidikan(@RequestBody PendidikanDto dto){
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunKeluar(dto.getTahunKeluar());
		pendidikanEntity.setPersonEntity(personEntity);
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
	//UPDATE
	@PutMapping("/update-pendidikan/{idPendidikan}")
	public ResponseEntity<?> update(@PathVariable Integer idPendidikan,
			@RequestBody PendidikanDto dto){
		PendidikanEntity pendidikanEntity = pendidikanRepository.findById(idPendidikan).get();
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunKeluar(dto.getTahunKeluar());
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
		
	}
	
	//DELETE
	@DeleteMapping("/delete-pendidikan/{idPendidikan}")
	public ResponseEntity<?> delete(@PathVariable Integer idPendidikan){
		PendidikanEntity pendidikanEntity = pendidikanRepository.findById(idPendidikan).get();
		pendidikanRepository.delete(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);	
	}
	
	//INSERT ALL
	@PostMapping("/insert-allBiodata")
	public ResponseEntity<?> insertAll(@RequestBody BiodataDto dto){
		PendidikanEntity pendidikanEntity = convertToPendidikanEntity(dto);
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		
		personRepository.save(personEntity);
		//PENGHUBUNG DETAIL DENGAN PERSON ENTITY
		detailBiodataEntity.setPersonEntity(personEntity);
		//PENGHUBUNG PENDIDIKAN DENGAN PERSON ENTITY
		pendidikanEntity.setPersonEntity(personEntity);
		detailBiodataRepository.save(detailBiodataEntity);
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
	
	//Method Convert
	//APAKAH FILE DTO DI METHOD CONVERT HARUS SAMA?
	public PendidikanEntity convertToPendidikanEntity(BiodataDto dto) {
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunKeluar(dto.getTahunKeluar());
		return pendidikanEntity;
	}
	
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		return personEntity;
	}
	
	public DetailBiodataEntity convertToDetailBiodataEntity(BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setUmur(dto.getUmur());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		return detailBiodataEntity;
	}
	
}
