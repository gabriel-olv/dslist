package br.com.gabrieldeoliveira.dslist.controllers;

import br.com.gabrieldeoliveira.dslist.dto.GameListDTO;
import br.com.gabrieldeoliveira.dslist.dto.GameMinDTO;
import br.com.gabrieldeoliveira.dslist.dto.ReplacementDTO;
import br.com.gabrieldeoliveira.dslist.services.GameListService;
import br.com.gabrieldeoliveira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> getAll() {
        var allLists = gameListService.findAll();
        return ResponseEntity.ok(allLists);
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<GameMinDTO>> getGamesByList(@PathVariable Long id) {
        var allGames = gameService.findByList(id);
        return ResponseEntity.ok(allGames);
    }

    @PostMapping("/{id}/replacement")
    public ResponseEntity<List<GameMinDTO>> postReplacement(@PathVariable Long id, @RequestBody ReplacementDTO replacement) {
        gameListService.replaceGamePosition(id, replacement.sourceIndex(), replacement.destinationIndex());
        return ResponseEntity.ok().build();
    }
}
