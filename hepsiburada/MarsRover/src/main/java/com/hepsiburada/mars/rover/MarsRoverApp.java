package com.hepsiburada.mars.rover;

import com.hepsiburada.mars.rover.enums.Direction;
import com.hepsiburada.mars.rover.exception.InputException;
import com.hepsiburada.mars.rover.model.Mars;
import com.hepsiburada.mars.rover.model.Request;
import com.hepsiburada.mars.rover.model.Response;
import com.hepsiburada.mars.rover.model.Rover;
import com.hepsiburada.mars.rover.service.IMarsRoverService;
import com.hepsiburada.mars.rover.service.implementation.MarsRoverService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public class MarsRoverApp {

	public static void main(String[] args) throws Exception {

		var fileName = "src/main/resources/roverFile";

		IMarsRoverService marsRoverService = new MarsRoverService();
		Request request = marsRoverService.readRequestFromFile(fileName);
		Response response = marsRoverService.discoverPlateau(request);
		for(Rover rover : response.getRoverList()){
			System.out.println(rover.getCurrentPosition());
		}
	}
}

