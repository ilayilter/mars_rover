package com.hepsiburada.mars.rover.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public class Response {

	private List<Rover> roverList;
	private boolean isSucceed = true;
	private String msg;

	public Response() {
		roverList = new ArrayList<>();
	}

	public List<Rover> getRoverList() {
		return roverList;
	}

	public void setRoverList(List<Rover> roverList) {
		this.roverList = roverList;
	}

	public boolean isSucceed() {
		return isSucceed;
	}

	public void setSucceed(boolean succeed) {
		isSucceed = succeed;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
