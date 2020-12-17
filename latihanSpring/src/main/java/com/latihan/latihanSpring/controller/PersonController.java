package com.latihan.latihanSpring.controller;

import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.latihan.latihanSpring.dto.DetailBiodataDto;
import com.latihan.latihanSpring.dto.PersonDto;
import com.latihan.latihanSpring.dto.StatusMessageDto;
import com.latihan.latihanSpring.entity.DetailBiodataEntity;
import com.latihan.latihanSpring.entity.PersonEntity;
import com.latihan.latihanSpring.repository.DetailBiodataRepository;
import com.latihan.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person") // ALAMAT UNTUK REST CONTROLLER // localhost:8500/person
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@GetMapping("/get-all")
	public List<PersonEntity> getPerson() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return personEntities;
	}
	
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll(){
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	//GET MAPPING BY ID
	@GetMapping("/get-name-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
//		PersonEntity personEntity = new PersonEntity();
//		personEntity.setFirstName(personRepository.findFirstNameById(id));
//		return ResponseEntity.ok(personEntity.getFirstName());
		PersonDto dto = new PersonDto();
		dto.setFirstName(personRepository.findFirstNameById(id));
		dto.setMessage("data berhasil");
		dto.setStatus("200");
		return ResponseEntity.ok(dto);
		}
	
	//GET MAPPING BY ID
	@GetMapping("/get-tanggalLahir-by-id/{id}")
	public ResponseEntity<?> getDateById(@PathVariable Date tanggalLahir){
//		PersonEntity personEntity = new PersonEntity();
//		personEntity.setFirstName(personRepository.findFirstNameById(id));
//		return ResponseEntity.ok(personEntity.getFirstName());
		PersonDto dto = new PersonDto();
		dto.setFirstName(personRepository.findTanggalLahirById(tanggalLahir));
		dto.setMessage("data berhasil");
		dto.setStatus("200");
		return ResponseEntity.ok(dto);
		}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody PersonDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);

	}
	
	//POSTMAPPING USING STATUSMESSAGE
	@PostMapping("/post-person-status")
	public ResponseEntity<?> insertPerson(@RequestBody BiodataDto dto) {
		//IF SAAT NIK NYA TIDAK SAMA DENGAN 16
		if(dto.getNik().length() != 16) {
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("NIK tidak 16 digit !");
			result.setData(null);
			//kalo statusnya pake httpstatus di return harus ditulis jga sesuai statusnya
			return ResponseEntity.badRequest().body(result);
		} else {
			//JIKA NIK NYA == 16 DIGIT
			PersonEntity personEntity = convertToPersonEntity(dto);
			personRepository.save(personEntity);
			
			//menambahkan kelas StatusMessageDto
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Success!");
			result.setData(personEntity);
			return ResponseEntity.ok(result);
		}

	}
	
	//POSTMAPPING BERDASARKAN INPUTAN UMUR
	@PostMapping("/post-person-umur")
	public ResponseEntity<?> insertUmurMessage(@RequestBody BiodataDto dto){
		if(dto.getUmur() < 17) {
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value()); //KODENYA : 400
			result.setMessage("Umur masih di bawah 17 tahun !");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else if (dto.getUmur() > 50) {
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value()); //KODENYA : 400
			result.setMessage("Umur lebih dari 50 tahun !");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
			detailBiodataRepository.save(detailBiodataEntity);
			return ResponseEntity.ok(detailBiodataEntity); // KODENYA : 200
		}
	}
	
	//POSTMAPPING BERDASARKAN UMUR DENGAN PERHITUNGAN TANGGAL SEKARANG-TANGGAL LAHIR
//	@PostMapping("/post-person-umurBytanggalLahir")
//	public ResponseEntity<?> insertUmurByTanggalLahir(@RequestBody BiodataDto dto){
//		Integer usia = Year.now().getValue() - dto.getTanggalLahir().getYear();
//		
//		
//	
//	}
	
	
	//MENGINPUTKAN DATA YANG BANYAK MENGGUNAKAN LIST
	@PostMapping("/post-person")
	public ResponseEntity<?> insertListPerson(@RequestBody BiodataDto dto){
		List<PersonEntity> listPersonEntity = new ArrayList<>();
		
		PersonEntity personEntity = convertToPersonEntity(dto);
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	//UPDATE DATA
	@PutMapping("/update-person/{idPerson}") //idPerson itu juga sebagai penamaan aja gak mesti namanya sama kayak variablenya
	public ResponseEntity<?> update (@PathVariable Integer idPerson, 
			@RequestBody PersonDto dto){
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	//DELETE DATA
	@DeleteMapping("/delete/{idPerson}")
	public ResponseEntity<?> delete (@PathVariable Integer idPerson){
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personRepository.delete(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	@GetMapping("/get-detail")
	public List<DetailBiodataEntity> getDetail(){
		List<DetailBiodataEntity> detailBiodataEntities = detailBiodataRepository.findAll();
		return detailBiodataEntities;
	}
	
		
	@PostMapping("/post-detail")
	public ResponseEntity<?> detailBiodata(@RequestBody DetailBiodataDto dto){
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setUmur(dto.getUmur());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	@PostMapping("/post-detail-person")
	public ResponseEntity<?> insertDetail(@RequestBody DetailBiodataDto dto){
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setUmur(dto.getUmur());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setPersonEntity(personEntity);
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);	
		
	}
	
	//BIASANYA BUAT REGISTRASI INPUTAN LANGSUNG KE BEBERAPA TABEL SEKALIGUS
	@PostMapping("/insert-all")
	public ResponseEntity<?> insertAll(@RequestBody BiodataDto dto){
		//deklarasi objek untuk table person dan tabel detail
//		PersonEntity personEntity = new PersonEntity();
//		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		
		//MENGGUNAKAN METHOD CONVERT
		//KALO PAKE METHOD JANGAN LUPA KATA "NEW" NYA GAK USAH DITERAPIN KECUALI MANGGIL CONSTRUCTOR KOSONG !!!
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		
		//untuk menghubungkan ke tabel person
//		personEntity.setFirstName(dto.getFirstName());
//		personEntity.setLastName(dto.getLastName());
		
		//untuk penghubung ke table detail
//		detailBiodataEntity.setDomisili(dto.getDomisili());
//		detailBiodataEntity.setUmur(dto.getUmur());
//		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
//		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
//		detailBiodataEntity.setPersonEntity(personEntity); //PENHUBUNG ANTARA DARI TABEL PERSON DAN DETAIL
		
		personRepository.save(personEntity);
		detailBiodataEntity.setPersonEntity(personEntity);
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
			
	}
	
	//METHOD CONVERT == MEMPERSINGKAT BIAR GAK NULIS2 SET SET LAGI (KAYAKNYA?)
	//UNTUK TABEL PERSON
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		return personEntity;
	}
	
	//UNTUK TABEL DETAIL
	public DetailBiodataEntity convertToDetailBiodataEntity(BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setUmur(dto.getUmur());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		return detailBiodataEntity;
	}
}
