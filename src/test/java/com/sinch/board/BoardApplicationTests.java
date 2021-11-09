package com.sinch.board;

import static org.junit.Assert.*;
import com.sinch.board.model.Player;
import com.sinch.board.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private PlayerRepository repository;

	@Test
	void contextLoads() {
		String name = "senze";
		Player player = repository.findByName(name);
		assertEquals(name,player.getName());
	}

}
