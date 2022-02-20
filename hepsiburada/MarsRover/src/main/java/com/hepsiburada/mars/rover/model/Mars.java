package com.hepsiburada.mars.rover.model;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public class Mars {

	private Integer startX = 0;
	private Integer startY = 0;
	private Integer endX;
	private Integer endY;

	public Mars() {
	}

	public Mars(Integer endX, Integer endY) {
		this.endX = endX;
		this.endY = endY;
	}

	public Integer getStartX() {
		return startX;
	}

	public void setStartX(Integer startX) {
		this.startX = startX;
	}

	public Integer getStartY() {
		return startY;
	}

	public void setStartY(Integer startY) {
		this.startY = startY;
	}

	public Integer getEndX() {
		return endX;
	}

	public void setEndX(Integer endX) {
		this.endX = endX;
	}

	public Integer getEndY() {
		return endY;
	}

	public void setEndY(Integer endY) {
		this.endY = endY;
	}
}
