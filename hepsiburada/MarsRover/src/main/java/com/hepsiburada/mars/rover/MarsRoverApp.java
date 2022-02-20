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

	public static void main(String[] args) throws IOException {

		var fileName = "src/main/resources/roverFile";

		try(BufferedReader br = new BufferedReader(
				new FileReader(fileName, StandardCharsets.UTF_8))){

			String line;
			int currentLine = 1;
			int roverCount = 1;
			Request request = new Request();
			while((line = br.readLine()) != null){
				if(currentLine == 1){
					String[] marsPosArr = line.split(" ");
					if(marsPosArr.length == 2){
						Mars mars = new Mars();
						Integer marsEndXPos = Integer.valueOf(marsPosArr[0]);
						Integer marsEndYPos = Integer.valueOf(marsPosArr[1]);
						mars.setEndX(marsEndXPos);
						mars.setEndY(marsEndYPos);
						request.setMars(mars);
					} else{
						throw new InputException("request is inconvenient");
					}
				} else{
					String[] roverPosArr = line.split(" ");
					if(roverPosArr.length == 3){
						Rover rover = new Rover();
						rover.setX(Integer.valueOf(roverPosArr[0]));
						rover.setY(Integer.valueOf(roverPosArr[1]));
						rover.setDirection(Direction.valueOf(roverPosArr[2]));
						rover.setState(rover.getDirection().getState());
						request.getRoverMap().put(roverCount, rover);

						line = br.readLine();
						List<String> instructionList = new ArrayList<>();
						for(char ch : line.toCharArray()){
							String instruction = String.valueOf(ch);
							instructionList.add(instruction);
						}
						request.getInstructionMap().put(roverCount, instructionList);
						roverCount++;
					} else{
						throw new InputException("request is inconvenient");
					}
				}
				currentLine++;
			}
			br.close();

			IMarsRoverService marsRoverService = new MarsRoverService();
			Response response = marsRoverService.discoverPlateau(request);
			for(Rover rover : response.getRoverList()){
				System.out.println(rover.getCurrentPosition());
			}

		}
	}
}
