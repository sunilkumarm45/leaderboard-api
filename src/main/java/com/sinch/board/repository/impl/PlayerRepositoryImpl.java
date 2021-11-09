package com.sinch.board.repository.impl;

import com.sinch.board.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinch.board.dto.PlayerCategory;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;

public class PlayerRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

   /* public List<PlayerCategory> getOverAllByPlayer() {
        AggregationOperation match = Aggregation.match(Criteria.where("attack").exists(true));
        AggregationOperation unwind = Aggregation.unwind("attack");
        //AggregationOperation fullName = Aggregation.project("_id", "score").and("firstName").concat(" ", Aggregation.fields("lastName")).as("name");
        AggregationOperation group = Aggregation.group("name").sum("score.value").as("totalscore");
        AggregationOperation project = Aggregation.project("totalscore").and("name").previousOperation();

        Aggregation aggregation = Aggregation.newAggregation(match, unwind, group, project);

        List<PlayerCategory> playerInfo = mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(Player.class), PlayerCategory.class).getMappedResults();

        return playerInfo;
    }*/
}
