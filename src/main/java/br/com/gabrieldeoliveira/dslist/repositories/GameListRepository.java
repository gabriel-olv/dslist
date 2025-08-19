package br.com.gabrieldeoliveira.dslist.repositories;

import br.com.gabrieldeoliveira.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
