package com.hepsiburada.mars.rover.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public class Request {

	private Mars mars;
	private Map<Integer, Rover> roverMap;
	private Map<Integer, List<String>> instructionMap;

	public Request() {
		roverMap = new HashMap<>();
		instructionMap = new HashMap<>();
	}

	public Mars getMars() {
		return mars;
	}

	public void setMars(Mars mars) {
		this.mars = mars;
	}

	public Map<Integer, Rover> getRoverMap() {
		return roverMap;
	}

	public void setRoverMap(Map<Integer, Rover> roverMap) {
		this.roverMap = roverMap;
	}

	public Map<Integer, List<String>> getInstructionMap() {
		return instructionMap;
	}

	public void setInstructionMap(Map<Integer, List<String>> instructionMap) {
		this.instructionMap = instructionMap;
	}
}
