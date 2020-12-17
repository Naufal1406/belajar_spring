package com.latihan.latihanSpring.entity;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detail_biodata_entity")
public class DetailBiodataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="domisili", length = 255, nullable = false)
	private String domisili;
	
	@Column(name = "umur", nullable = false)
	private Integer umur;
	
	@Column(name = "tanggal_lahir", length = 50, nullable = false)
	private Date tanggalLahir;
	
	@Column(name = " jenis_kelamin", nullable = false)
	private String jenisKelamin;

	
	//RELATION 
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;
	
//	//SETTER GETTER TIDAK DIGUNAKAN KARENA SUDAH MENGGUNAKAN PROJECT LOMBOK
//	
//	public Integer getId() {
//		return id;
//	}
//
//	public PersonEntity getPersonEntity() {
//		return personEntity;
//	}
//
//	public void setPersonEntity(PersonEntity personEntity) {
//		this.personEntity = personEntity;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getDomisili() {
//		return domisili;
//	}
//
//	public void setDomisili(String domisili) {
//		this.domisili = domisili;
//	}
//
//	public Integer getUmur() {
//		return umur;
//	}
//
//	public void setUmur(Integer umur) {
//		this.umur = umur;
//	}
//
//	public Date getTanggalLahir() {
//		return tanggalLahir;
//	}
//
//	public void setTanggalLahir(Date tanggalLahir) {
//		this.tanggalLahir = tanggalLahir;
//	}
//
//	public String getJenisKelamin() {
//		return jenisKelamin;
//	}
//
//	public void setJenisKelamin(String jenisKelamin) {
//		this.jenisKelamin = jenisKelamin;
//	}
//
//	//CONSTRUCTOR
//	public DetailBiodataEntity() {
//		super();
//	}
//
//	public DetailBiodataEntity(Integer id, String domisili, Integer umur, Date tanggalLahir, String jenisKelamin) {
//		super();
//		this.id = id;
//		this.domisili = domisili;
//		this.umur = umur;
//		this.tanggalLahir = tanggalLahir;
//		this.jenisKelamin = jenisKelamin;
//	}
		
	
}
