package com.example.demo.controller;

import com.example.demo.dto.ParkingSpotDto;
import com.example.demo.model.ParkingSpotModel;
import com.example.demo.service.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController  // PARA CRIAR UMA REST API
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")     // DEFINIR A URI A NIVEL DE CLASS
public class ParkingSpotController {
	final ParkingSpotService parkingSpotService;  // PONTO DE INGEÇÃO DO SERVISE DENTRO DO CONTROLLER GERANDO UM CONSTRUTOR
	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}

	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
		if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Carro de matrícula já está em uso!"); 	// condição para placa
		}
		if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga de estacionamento já está em uso!"); //condição para o estacionamento
		}
		if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já cadastrada para este apartamento/bloco!"); // condição para o apartamento e bloco
		}

		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); // FAZER A HORA ALTO INCREMENTAL
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
		// @Valid PARA DIZER QUE O NOTNULL É VALIDO
		//VAR -> ParkingSpotMoldel parkingSpotModel = new ParkingSpotModel();
		//// @PostMapping ESSE METODO É PARA SALVA NOVO REGISTRO NA APLICAÇÃO
		//	BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); // para receber e fazer validaçõe do dto mas salva um model, para fazer a conveção para dtos
	// return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel)); // construir a resposta em service
	}


	// iniciando o metodo  GET
	@GetMapping // toda a listagem de estacionamento de vagas que esta na api
	public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
	}


	//get one para passar o id e retorna o id spesifico
	@GetMapping("/{id}") // tem um complemeto uri para solicita o id na uri
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id); // para fazer a busca

		if (!parkingSpotModelOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
		}



		// METODO PARA DELETAR VAGA
@DeleteMapping("/{id}")

	public ResponseEntity<Object> deleteParkingSpot ( @PathVariable(value = "id") UUID id){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);

		// condições
	if (!parkingSpotModelOptional.isPresent()){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.");
	}
	parkingSpotService.delete(parkingSpotModelOptional.get());
	return ResponseEntity.status(HttpStatus.OK).body("A vaga de estacionamento foi excluída com sucesso.");
}

// metodo put para atualizar cadastro

public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
		                                           @RequestBody @Valid ParkingSpotDto parkingSpotDto){

	Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
	if (!parkingSpotModelOptional.isPresent()){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\"Vaga de estacionamento não encontrada.\"");

	}
	var parkingSpotModel = parkingSpotModelOptional.get(); // para reaproveita oque não foi atualizado
	parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
	parkingSpotModel.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
	parkingSpotModel.setModelCar(parkingSpotDto.getModelCar());
	parkingSpotModel.setBrandCar(parkingSpotDto.getBrandCar());
	parkingSpotModel.setColorCar(parkingSpotDto.getColorCar());
	parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
	parkingSpotModel.setApartment(parkingSpotDto.getApartment());
	parkingSpotModel.setBlock(parkingSpotDto.getBlock());
	return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
}

}
