package com.hepsiburada.mars.rover.service.state;

import com.hepsiburada.mars.rover.model.Rover;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public interface IDirectionState {

	void turnRight(Rover rover);
	void turnLeft(Rover rover);
	void move(Rover rover);

	String getCurrentPosition(Rover rover);
}
