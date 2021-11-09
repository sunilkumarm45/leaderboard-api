package com.sinch.board.controller;

import ch.qos.logback.core.CoreConstants;
import com.sinch.board.model.Player;
import com.sinch.board.repository.PlayerRepository;
import com.sinch.board.dto.PlayerCategory;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PlayerController extends BaseController {

    @Autowired
    PlayerRepository playerRepository;

    /**
     * The Constant log.
     */
    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @GetMapping("/players")
    @ApiOperation("Fetch all players with sorted overall score or based on sorted category score")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List<PlayerCategory>> getAllPlayers(@RequestParam(required = false) String category) {
        try {
            if(category == null)
                log.info("Entering players api with overall category{}");
            else
                log.info("Entering players api for {}  ", category);
            List<Player> players = new ArrayList<Player>();
            List<PlayerCategory> playerCatList = new ArrayList<PlayerCategory>();

            playerRepository.findAll().forEach(players::add);

            for (Player player : players) {
                PlayerCategory playerCat = new PlayerCategory();
                playerCat.setId(player.getId());
                playerCat.setName(player.getName());
                playerCat.setCategory(category);

                if (category == null || category.equals("overall")){
                    playerCat.setLevel(player.getLevel());
                    playerCat.setScore(player.getOverall());
                }
                else if(category.equals("attack")){
                    playerCat.setLevel(player.getAttack().getLevel());
                    playerCat.setScore(player.getAttack().getScore());
                }
                else if(category.equals("defense")){
                    playerCat.setLevel(player.getDefense().getLevel());
                    playerCat.setScore(player.getDefense().getScore());
                }
                else if(category.equals("magic")){
                    playerCat.setLevel(player.getMagic().getLevel());
                    playerCat.setScore(player.getMagic().getScore());
                }
                else if(category.equals("cooking")){
                    playerCat.setLevel(player.getCooking().getLevel());
                    playerCat.setScore(player.getCooking().getScore());
                }
                else if(category.equals("crafting")){
                    playerCat.setLevel(player.getCrafting().getLevel());
                    playerCat.setScore(player.getCrafting().getScore());
                }

                playerCatList.add(playerCat);
            }
                /*playerRepository.findByNameContaining(name).forEach(players::add);*/

            playerCatList = playerCatList.stream()
                    .sorted(Comparator.comparingLong(PlayerCategory::getScore)
                            .reversed())
                    .collect(Collectors.toList());

            if (playerCatList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            log.info("Exiting players api with size {}, ", playerCatList.size());
            return new ResponseEntity<>(playerCatList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/players/{id}")
    @ApiOperation("Optional service to fetch player based on player id")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") String id) {
        log.info("Entering players id based search api {}, ", id);
        Optional<Player> playerData = playerRepository.findById(id);

        if (playerData.isPresent()) {
            log.info("Player data is available");
            return new ResponseEntity<>(playerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/player")
    @ApiOperation("Fetch player data with category level scores by name")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<Player> getPlayerByName(@RequestParam(required = false) String name) {
        log.info("Entering player name based search api {}", name);
        try {
            Player playerData = new Player();
            playerData = playerRepository.findByName(name);

            if (playerData != null) {
                log.info("Exiting player name search api");
                return new ResponseEntity<>(playerData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/playersbyCategory")
    public ResponseEntity<List<PlayerCategory>> getAllPlayersByCategory(@RequestParam String category) {
        try {
            List<PlayerCategory> players = new ArrayList<PlayerCategory>();
            List<Player> playerList = new ArrayList<Player>();

            playerRepository.findAll().forEach(playerList::add);

            if (category.equals("overall")) {

            }
            else
                playerRepository.findByNameContaining(name).forEach(players::add);

            if (players.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(players, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


    /*@PostMapping("/players")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {

    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {

    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {

    }

    @DeleteMapping("/players")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {

    }

    @GetMapping("/players/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {

    }*/
}
