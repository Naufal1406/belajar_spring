package com.latihan.latihanSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.latihanSpring.dto.DetailBiodataDto;
import com.latihan.latihanSpring.entity.DetailBiodataEntity;
import com.latihan.latihanSpring.repository.DetailBiodataRepository;

import java.util.List;

@RestController
@RequestMapping("/detail-biodata")
public class DetailBiodataController {
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	
	@GetMapping("/get-all")
	public List<DetailBiodataEntity> getBiodata(){
		List<DetailBiodataEntity> detailBiodataEntities = detailBiodataRepository.findAll();
		return detailBiodataEntities;
	}
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll() {
		List<DetailBiodataEntity> detailBiodataEntities = detailBiodataRepository.findAll();
		return ResponseEntity.ok(detailBiodataEntities);	
	}
	
	@PostMapping("/post-biodata")
	public ResponseEntity<?> insertBiodata(@RequestBody DetailBiodataDto dto){
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setUmur(dto.getUmur());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
		
}

