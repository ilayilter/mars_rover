package com.hepsiburada.mars.rover;

import com.hepsiburada.mars.rover.enums.Direction;
import com.hepsiburada.mars.rover.model.Rover;
import com.hepsiburada.mars.rover.state.implementation.EastState;
import com.hepsiburada.mars.rover.state.implementation.NorthState;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public class RoverStateUnitTest {

	@Test
	public void givenRoverNorthState_thenEastState() {
		Rover rover = new Rover();
		rover.setX(1);
		rover.setY(2);
		rover.setDirection(Direction.N);
		rover.setState(new NorthState());

		rover.turnRight();

		String currentPosition = rover.getCurrentPosition();
		Assert.assertTrue(currentPosition.equals("1 2 E"));
	}

	@Test
	public void givenInitialState_whenGiveInstruction_thenFinalState() {
		Rover rover = new Rover();
		rover.setX(1);
		rover.setY(2);
		rover.setDirection(Direction.N);
		rover.setState(new NorthState());

		rover.turnLeft();
		rover.move();
		rover.turnLeft();
		rover.move();
		rover.turnLeft();
		rover.move();
		rover.turnLeft();
		rover.move();
		rover.move();

		String currentPosition = rover.getCurrentPosition();
		Assert.assertTrue(currentPosition.equals("1 3 N"));

		Rover rover2 = new Rover();
		rover2.setX(3);
		rover2.setY(3);
		rover2.setDirection(Direction.E);
		rover2.setState(new EastState());

		rover2.move();
		rover2.move();
		rover2.turnRight();
		rover2.move();
		rover2.move();
		rover2.turnRight();
		rover2.move();
		rover2.turnRight();
		rover2.turnRight();
		rover2.move();

		String currentPosition2 = rover2.getCurrentPosition();
		Assert.assertTrue(currentPosition2.equals("5 1 E"));
	}
}
