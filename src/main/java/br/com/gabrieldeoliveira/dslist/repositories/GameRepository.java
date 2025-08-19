package br.com.gabrieldeoliveira.dslist.repositories;

import br.com.gabrieldeoliveira.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
