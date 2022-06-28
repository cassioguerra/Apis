package com.example.demo.dto;

import javax.validation.constraints.NotBlank; // PARA VER SE NÃO É VAZIL
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// TEM TODOS OS CAMPOS MENOS OS ALTO INCREMENTAL
public class ParkingSpotDto {

	@NotNull // PARA FALAR QUE O VALOR NÃO PODE SER NULO OU VAZIO
	private String parkingSpotNumber;
	@NotNull
	@Size(max = 7)  // FALA O NUMERO MAXIMO DE CARACTER QUE PODE TER AQUI
	private String licensePlateCar;
	@NotNull
	private String brandCar;
	@NotNull
	private String modelCar;
	@NotNull
	private String colorCar;
	@NotNull
	private String responsibleName;
	@NotNull
	private String apartment;
	@NotNull
	private String block;

	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}

	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}

	public String getLicensePlateCar() {
		return licensePlateCar;
	}

	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}
}
