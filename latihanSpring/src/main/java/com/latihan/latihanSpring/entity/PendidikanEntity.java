package com.latihan.latihanSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "pendidikan_entity")
public class PendidikanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "level", nullable = false)
	private String level;
	
	@Column(name = "institusi", nullable = false)
	private String institusi;
	
	@Column(name = "tahun_masuk", nullable = false)
	private Integer tahunMasuk;
	
	@Column(name ="tahun_keluar", nullable = false)
	private Integer tahunKeluar;
	
	//RELASI ONE TO MANY ==> person -> entity Pendidikan
	@ManyToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;
	
	

}
