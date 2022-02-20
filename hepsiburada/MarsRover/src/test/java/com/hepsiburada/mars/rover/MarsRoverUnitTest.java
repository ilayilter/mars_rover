package com.hepsiburada.mars.rover;

import com.hepsiburada.mars.rover.enums.Direction;
import com.hepsiburada.mars.rover.model.Mars;
import com.hepsiburada.mars.rover.model.Request;
import com.hepsiburada.mars.rover.model.Response;
import com.hepsiburada.mars.rover.model.Rover;
import com.hepsiburada.mars.rover.service.IMarsRoverService;
import com.hepsiburada.mars.rover.service.implementation.MarsRoverService;
import com.hepsiburada.mars.rover.service.state.implementation.EastState;
import com.hepsiburada.mars.rover.service.state.implementation.NorthState;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ilay.Ilter on 20/02/2022
 */
public class MarsRoverUnitTest {

	@Test
	public void givenConvenientRequest_thenCorrectState() {
		Mars mars = new Mars(5, 5);
		Rover rover = new Rover();
		rover.setX(1);
		rover.setY(2);
		rover.setDirection(Direction.N);
		rover.setState(new NorthState());

		Rover rover2 = new Rover();
		rover2.setX(3);
		rover2.setY(3);
		rover2.setDirection(Direction.E);
		rover2.setState(new EastState());

		List<String> instructionList1 = new ArrayList<>(Arrays.asList("L", "M", "L", "M", "L", "M", "L", "M", "M"));
		List<String> instructionList2 = new ArrayList<>(Arrays.asList("M", "M", "R", "M", "M", "R", "M", "R", "R", "M"));

		Request request = new Request();
		request.setMars(mars);
		request.getRoverMap().put(1, rover);
		request.getRoverMap().put(2, rover2);
		request.getInstructionMap().put(1, instructionList1);
		request.getInstructionMap().put(2, instructionList2);

		IMarsRoverService marsRoverService = new MarsRoverService();
		Response response = marsRoverService.discoverPlateau(request);

		Assert.assertTrue(response.getRoverList().size() == 2);

		Rover responseRover1 = response.getRoverList().get(0);
		Assert.assertTrue(responseRover1.getCurrentPosition().equals("1 3 N"));
		Rover responseRover2 = response.getRoverList().get(1);
		Assert.assertTrue(responseRover2.getCurrentPosition().equals("5 1 E"));
	}

	@Test
	public void givenConvenientRequest_whenRoverOutOfMars_thenCoordinateException() {
		Mars mars = new Mars(5, 5);
		Rover rover = new Rover();
		rover.setX(4);
		rover.setY(2);
		rover.setDirection(Direction.N);
		rover.setState(new NorthState());

		List<String> instructionList1 = new ArrayList<>(Arrays.asList("M", "M", "M", "M"));

		Request request = new Request();
		request.setMars(mars);
		request.getRoverMap().put(1, rover);
		request.getInstructionMap().put(1, instructionList1);

		IMarsRoverService marsRoverService = new MarsRoverService();
		Response response = marsRoverService.discoverPlateau(request);
		Assert.assertTrue(!response.isSucceed());
		Assert.assertTrue(response.getMsg().equals("coordinate is inconvenient"));
	}

	@Test
	public void givenInconvenientInstruction_thenInputException() {
		Mars mars = new Mars(5, 5);
		Rover rover = new Rover();
		rover.setX(4);
		rover.setY(2);
		rover.setDirection(Direction.N);
		rover.setState(new NorthState());

		List<String> instructionList1 = new ArrayList<>(Arrays.asList("M", "H", "M", "M"));

		Request request = new Request();
		request.setMars(mars);
		request.getRoverMap().put(1, rover);
		request.getInstructionMap().put(1, instructionList1);

		IMarsRoverService marsRoverService = new MarsRoverService();
		Response response = marsRoverService.discoverPlateau(request);
		Assert.assertTrue(!response.isSucceed());
		Assert.assertTrue(response.getMsg().equals("instruction is inconvenient"));
	}

	@Test
	public void givenFile_whenRead_thenDiscover() {
		var fileName = "src/main/resources/roverFile2";
		IMarsRoverService marsRoverService = new MarsRoverService();
		try{
			Request request = marsRoverService.readRequestFromFile(fileName);
			Response response = marsRoverService.discoverPlateau(request);
			for(Rover rover : response.getRoverList()){
				Assert.assertTrue(rover.getCurrentPosition().equals("1 2 S"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void givenInconvenientFile_whenRead_thenException() {
		var fileName = "src/main/resources/roverFileEx";
		IMarsRoverService marsRoverService = new MarsRoverService();
		try{
			Request request = marsRoverService.readRequestFromFile(fileName);
		} catch(Exception e){
			Assert.assertTrue(e.getMessage().equals("request is inconvenient"));
		}
	}
}
