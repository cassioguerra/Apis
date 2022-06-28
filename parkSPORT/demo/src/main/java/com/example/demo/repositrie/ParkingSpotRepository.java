package com.example.demo.repositrie;

import com.example.demo.model.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// NO REPOSITORY VAI ESTENDE O REPOSYTORI JPA, COLOCANDO O MODEL DO REPOSITORI E O TIPO DE INDENTIFICADO PK
// MODEL É O PARKSPORTMODEL O INDENTIFICADO É O UUID
@Repository // PARA TRANSIÇÕES COM OS DADOS
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

	public boolean existsByLicensePlateCar(String licensePlateCar); // condição para placa
	public boolean existsByParkingSpotNumber(String parkingSpotNumber);//condição para o estacionamento
	public boolean existsByApartmentAndBlock(String apartment, String block);// condição para o apartamento e bloco
}
