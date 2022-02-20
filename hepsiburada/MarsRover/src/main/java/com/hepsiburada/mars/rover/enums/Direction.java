package com.hepsiburada.mars.rover.enums;

import com.hepsiburada.mars.rover.state.IDirectionState;
import com.hepsiburada.mars.rover.state.implementation.EastState;
import com.hepsiburada.mars.rover.state.implementation.NorthState;
import com.hepsiburada.mars.rover.state.implementation.SouthState;
import com.hepsiburada.mars.rover.state.implementation.WestState;

/**
 * Created by Ilay.Ilter on 18/02/2022
 */
public enum Direction {
	S(new SouthState()),
	N(new NorthState()),
	E(new EastState()),
	W(new WestState());

	private IDirectionState state;

	Direction(IDirectionState state) {
		this.state = state;
	}

	public IDirectionState getState() {
		return state;
	}
}
