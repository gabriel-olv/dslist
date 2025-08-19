package br.com.gabrieldeoliveira.dslist.controllers;

import br.com.gabrieldeoliveira.dslist.dto.GameMinDTO;
import br.com.gabrieldeoliveira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAll() {
        var allGames = gameService.findAll();
        return ResponseEntity.ok(allGames);
    }
}
