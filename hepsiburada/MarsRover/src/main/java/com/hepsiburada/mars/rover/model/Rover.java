package com.hepsiburada.mars.rover.model;

import com.hepsiburada.mars.rover.enums.Direction;
import com.hepsiburada.mars.rover.service.state.IDirectionState;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public class Rover {

	private Integer x;
	private Integer y;
	private Direction direction;
	private IDirectionState state;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public IDirectionState getState() {
		return state;
	}

	public void setState(IDirectionState state) {
		this.state = state;
	}

	public void turnRight() {
		state.turnRight(this);
	}

	public void turnLeft() {
		state.turnLeft(this);
	}

	public void move() {
		state.move(this);
	}

	public String getCurrentPosition() {
		return state.getCurrentPosition(this);
	}
}
