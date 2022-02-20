package com.hepsiburada.mars.rover.service.state.implementation;

import com.hepsiburada.mars.rover.enums.Direction;
import com.hepsiburada.mars.rover.model.Rover;
import com.hepsiburada.mars.rover.service.state.IDirectionState;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public class SouthState implements IDirectionState {

	@Override
	public void turnRight(Rover rover) {
		rover.setState(new WestState());
		rover.setDirection(Direction.W);
	}

	@Override
	public void turnLeft(Rover rover) {
		rover.setState(new EastState());
		rover.setDirection(Direction.E);
	}

	@Override
	public void move(Rover rover) {
		rover.setY(rover.getY()-1);
	}

	@Override
	public String getCurrentPosition(Rover rover) {
		return rover.getX().toString()
				.concat(" ")
				.concat(rover.getY().toString())
				.concat(" ")
				.concat(rover.getDirection().name());
	}
}
