package br.com.gabrieldeoliveira.dslist.services;

import br.com.gabrieldeoliveira.dslist.dto.GameListDTO;
import br.com.gabrieldeoliveira.dslist.repositories.GameListRepository;
import br.com.gabrieldeoliveira.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void replaceGamePosition(Long listId, int sourceIndex, int destinationIndex) {
        var games = gameRepository.searchByList(listId);
        var gameToReposition = games.remove(sourceIndex);
        games.add(destinationIndex, gameToReposition);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, games.get(i).getId(), i);
        }
    }
}
