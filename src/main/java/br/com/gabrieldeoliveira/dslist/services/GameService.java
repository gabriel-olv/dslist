package br.com.gabrieldeoliveira.dslist.services;

import br.com.gabrieldeoliveira.dslist.dto.GameDTO;
import br.com.gabrieldeoliveira.dslist.dto.GameMinDTO;
import br.com.gabrieldeoliveira.dslist.exceptions.ResourceNotFoundException;
import br.com.gabrieldeoliveira.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        var game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with id=" + id));
        return new GameDTO(game);
    }
}
