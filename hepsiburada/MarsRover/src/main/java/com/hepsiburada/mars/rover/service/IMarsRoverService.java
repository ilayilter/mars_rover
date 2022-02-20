package com.hepsiburada.mars.rover.service;

import com.hepsiburada.mars.rover.model.Request;
import com.hepsiburada.mars.rover.model.Response;

import java.util.List;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public interface IMarsRoverService {

	Response discoverPlateau(Request request);
}
