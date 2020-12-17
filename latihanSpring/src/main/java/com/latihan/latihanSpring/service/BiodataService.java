package com.latihan.latihanSpring.service;

import com.latihan.latihanSpring.dto.BiodataDto;
import com.latihan.latihanSpring.dto.DetailBiodataDto;
import com.latihan.latihanSpring.entity.DetailBiodataEntity;

public interface BiodataService {
	DetailBiodataEntity insertService(BiodataDto dto);
	DetailBiodataEntity getDetail();
	DetailBiodataEntity detailBiodata(DetailBiodataDto dto);
	DetailBiodataEntity insertDetail(DetailBiodataDto dto);
	DetailBiodataEntity insertAll(BiodataDto dto);

}
