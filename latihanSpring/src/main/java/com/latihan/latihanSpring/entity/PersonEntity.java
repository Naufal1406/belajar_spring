package com.latihan.latihanSpring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //ANOTASI UNTUK MENANDAKAN PENGHUBUNG CLASS DGN DATABASE
@Table(name= "person_entity") //ANOTASI MENANDAKAN CLASS TERSEBUT UNTUK MEMBUAT TABEL


//JADI ATRIBUTE YG DIBUAT MENDAKAN KOLOM
public class PersonEntity {
	@Id //MEMBUAT PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) // MEMBUAT AUTO_INCREMENT
	
	//MENANDAKAN KOLOM PADA TABEL
	@Column(name="id")
	private Integer id;
	@Column(name="first_name", length = 50 , nullable = false)
	private String firstName;
	@Column(name="last_name", length = 50 , nullable = false)
	private String lastName;
	@Column(name="nik", length = 50, nullable = false)
	private String nik;
	
	//MEMBUAT CONSTRUCTOR DAN SETTER GETTER
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public PersonEntity(Integer id, String firstName, String lastName, String nik) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nik = nik;
	
	}
	public PersonEntity() {
		super();
	}

	
	
	
	
	
}
