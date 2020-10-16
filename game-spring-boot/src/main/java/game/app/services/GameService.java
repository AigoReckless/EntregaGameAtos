package game.app.services;

import game.app.dtos.request.GameRequest;
import game.app.dtos.response.GameResponse;

public interface GameService {

	public GameResponse addGame(GameRequest gameDto);
	
	public GameResponse getGame(String title);
	
	
}
