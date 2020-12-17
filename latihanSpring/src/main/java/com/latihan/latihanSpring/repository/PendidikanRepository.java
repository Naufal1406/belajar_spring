package com.latihan.latihanSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.latihan.latihanSpring.entity.PendidikanEntity;

@Repository
//REPOSITORY LEBIH KE ARAH UNTUK MENGAMBIL ATAU GET DATA DI DATABASE
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {
	//UNTUK MENGAMBIL DATA PENDIDIKAN BERDASARKAN ID PENDIDIKAN
	@Query(value = "SELECT * FROM pendidikan_entity WHERE id = ?", nativeQuery = true)
	List<PendidikanEntity> findByIdPendidikan(Integer id);
	
	//UNTUK MENGAMBIL DATA PENDIDIKAN BERDASARKAN ID PERSON
	@Query(value = "SELECT * FROM pendidikan_entity WHERE person_id = ?", nativeQuery = true)
	List<PendidikanEntity> findByIdPerson(Integer personId);
}
