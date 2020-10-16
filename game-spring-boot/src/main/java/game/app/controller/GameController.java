package game.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import game.app.dtos.request.GameRequest;
import game.app.dtos.response.GameResponse;
import game.app.services.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	//Get ID
	@GetMapping("/game")
	public ResponseEntity<Object> getID(@RequestParam("title") String title, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getGame(title));
	}

	//Add Game
	@PostMapping("/game")
	public ResponseEntity<Object> addGame(@RequestBody @Valid GameRequest gameRequest, HttpServletRequest request){
		GameResponse gameResponse = gameService.addGame(gameRequest);
		return ResponseEntity.status(HttpStatus.OK).body(gameResponse);
	}
	
}
