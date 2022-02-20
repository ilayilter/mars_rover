package com.hepsiburada.mars.rover.service;

import com.hepsiburada.mars.rover.model.Request;
import com.hepsiburada.mars.rover.model.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public interface IMarsRoverService {

	Request readRequestFromFile(String filename) throws Exception;
	Response discoverPlateau(Request request);
}
