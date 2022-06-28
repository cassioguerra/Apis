package com.example.demo.service;

import com.example.demo.model.ParkingSpotModel;
import com.example.demo.repositrie.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {
	final ParkingSpotRepository parkingSpotRepository; // PONTO DE INGEÇÃO DO REPOSYTORY  PARA SALVA, DELETA O PEDIR PEDIR  LISTA ( CONSTRUTOR )

	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}
@Transactional // garante que volte ao normal e namo tenha dados quebrados
	public  ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel); // save um metodo do jpa para salva
	}


	public boolean existsByLicensePlateCar(String licensePlateCar) {
	return 	parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	// condição para placa
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return  parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
		//condição para o estacionamento
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
		// condição para o apartamento e bloco
	}

	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		return parkingSpotRepository.findAll(pageable);
	}

	public Optional<ParkingSpotModel> findById(UUID id) {
		return parkingSpotRepository.findById(id);
	}
@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		parkingSpotRepository.delete(parkingSpotModel);
	}
}
