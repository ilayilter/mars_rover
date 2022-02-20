package com.hepsiburada.mars.rover.service.implementation;

import com.hepsiburada.mars.rover.enums.Instruction;
import com.hepsiburada.mars.rover.exception.CoordinateException;
import com.hepsiburada.mars.rover.exception.InputException;
import com.hepsiburada.mars.rover.model.Mars;
import com.hepsiburada.mars.rover.model.Request;
import com.hepsiburada.mars.rover.model.Response;
import com.hepsiburada.mars.rover.model.Rover;
import com.hepsiburada.mars.rover.service.IMarsRoverService;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ilay.Ilter on 19/02/2022
 */
public class MarsRoverService implements IMarsRoverService {

	@Override
	public Response discoverPlateau(Request request) {
		Response response = new Response();
		try{
			if(isRoverAndInstructionConvenient(request)){
				for(Integer key : request.getRoverMap().keySet()){
					Rover rover = request.getRoverMap().get(key);
					List<String> InstructionList = request.getInstructionMap().get(key);
					List<String> instructionNameList = Stream.of(Instruction.values())
							.map(Enum::name)
							.collect(Collectors.toList());
					for(String instructionKey : InstructionList){
						if(instructionNameList.contains(instructionKey)){
							Instruction instruction = Instruction.valueOf(instructionKey);
							switch(instruction){
								case L:
									rover.turnLeft();
									break;
								case R:
									rover.turnRight();
									break;
								case M:
									rover.move();
									break;
								default:
									throw new InputException("instruction is inconvenient ");
							}
						} else{
							throw new InputException("instruction is inconvenient ");
						}
					}
					if(checkPositionConvenient(request.getMars(), rover)){
						response.getRoverList().add(rover);
					} else{
						throw new CoordinateException("coordinate is inconvenient");
					}
				}
				return response;
			} else{
				throw new InputException("request is inconvenient");
			}
		} catch(InputException | CoordinateException e){
			response.setSucceed(false);
			response.setMsg(e.getMessage());
		} catch(Exception e){
			response.setSucceed(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}

	private boolean checkPositionConvenient(Mars mars, Rover rover) {
		if(mars.getEndX() < rover.getX()){
			return false;
		}
		if(mars.getEndY() < rover.getY()){
			return false;
		}
		if(mars.getStartX() > rover.getX()){
			return false;
		}
		if(mars.getStartY() > rover.getY()){
			return false;
		}
		return true;
	}

	private boolean isRoverAndInstructionConvenient(Request request) {
		return request.getRoverMap() != null && !CollectionUtils.isEmpty(request.getRoverMap()
				.keySet()) && request.getInstructionMap() != null && !CollectionUtils.isEmpty(request.getInstructionMap()) && request.getRoverMap()
				.keySet().size() == request.getInstructionMap().keySet().size();
	}
}
