package com.sinch.board.dto;
import java.util.*;

public class PlayerScore {

    private String id;
    private String name;
    private List<CatScore> scoreList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CatScore> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<CatScore> scoreList) {
        this.scoreList = scoreList;
    }
}
