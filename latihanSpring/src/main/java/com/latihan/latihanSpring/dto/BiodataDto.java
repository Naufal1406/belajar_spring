package com.latihan.latihanSpring.dto;

import java.sql.Date;

import lombok.Data;

@Data

//DTO GABUNGAN ANTARA TABEL PERSON DAN DETAIL
public class BiodataDto {
	//attribute table person
	private String firstName;
	private String lastName;
	
	//attribute table detail
	private String domisili;
	private Integer umur;
	private Date tanggalLahir;
	private String jenisKelamin;
	private Integer personId;
	
	//atribute table pendidikan
	private String level;
	private String institusi;
	private Integer tahunMasuk;
	private Integer tahunKeluar;
	
	private String nik;
}
