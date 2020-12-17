package com.latihan.latihanSpring.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class DetailBiodataDto {
	//Attribute
	private String domisili;
	private Integer umur;
	private Date tanggalLahir;
	private String jenisKelamin;
	private Integer personId;

//SETTER GETTER DAN CONSTRUCTOR TIDAK DIGUNAKAN KARENA SUDAH MENGGUNAKAN PROJECT LOMBOK
//	//Constructor
//	public DetailBiodataDto() {
//		super();
//	}
//
//	public DetailBiodataDto(String domisili, Integer umur, Date tanggalLahir, String jenisKelamin) {
//		super();
//		this.domisili = domisili;
//		this.umur = umur;
//		this.tanggalLahir = tanggalLahir;
//		this.jenisKelamin = jenisKelamin;
//	}
//	
//	//SETTER GETTER
//	public Integer getPersonId() {
//		return personId;
//	}
//
//	public void setPersonId(Integer personId) {
//		this.personId = personId;
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
	
	
}
