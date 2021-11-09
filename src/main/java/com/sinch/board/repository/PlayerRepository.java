package com.sinch.board.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sinch.board.model.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {
    List<Player> findByNameContaining(String name);
    Player findByName(String name);
    //List<Player> findById(boolean id);
}
