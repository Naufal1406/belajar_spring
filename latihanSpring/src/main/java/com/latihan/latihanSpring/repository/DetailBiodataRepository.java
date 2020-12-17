package com.latihan.latihanSpring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.latihan.latihanSpring.entity.DetailBiodataEntity;

@Repository
public interface DetailBiodataRepository extends JpaRepository<DetailBiodataEntity, Integer> {
	//KALO LIST DIBAWAH INI NGIKUT DARI FORMAT PENULISAN JpaRepository
	List<DetailBiodataEntity> findByJenisKelamin(String jenisKelamin);
	List<DetailBiodataEntity> findByPersonEntityId(Integer personId);
	
	
	//BIAR PENAMAAN METHODNYA BEBAS ITU BISA PAKE @QUERY 
	@Query(value = "SELECT * FROM detail_biodata_entity WHERE person_id = ?", nativeQuery = true)
	List<DetailBiodataEntity> findByPersonId(Integer idPerson);
}
