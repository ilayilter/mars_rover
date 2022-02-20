package com.hepsiburada.mars.rover.state.implementation;

import com.hepsiburada.mars.rover.enums.Direction;
import com.hepsiburada.mars.rover.model.Rover;
import com.hepsiburada.mars.rover.state.IDirectionState;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public class EastState implements IDirectionState {

	@Override
	public void turnRight(Rover rover) {
		rover.setState(new SouthState());
		rover.setDirection(Direction.S);
	}

	@Override
	public void turnLeft(Rover rover) {
		rover.setState(new NorthState());
		rover.setDirection(Direction.N);
	}

	@Override
	public void move(Rover rover) {
		rover.setX(rover.getX() + 1);
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
