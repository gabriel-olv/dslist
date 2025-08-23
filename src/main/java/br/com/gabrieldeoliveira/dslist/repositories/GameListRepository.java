package br.com.gabrieldeoliveira.dslist.repositories;

import br.com.gabrieldeoliveira.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @NativeQuery("UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, int newPosition);
}
