package com.sinch.board.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.sinch.board.dto.Score;
@Document(collection = "players")
public class Player {
    @Id
    private String id;

    private String name;
    private Score attack;
    private Score defense;
    private Score magic;
    private Score cooking;
    private Score crafting;
    private long overall;
    private int level;

    public Player() {

    }

    public Player(String name, Score attack, Score defense, Score magic, Score cooking, Score crafting, long overall, int level) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.cooking = cooking;
        this.crafting = crafting;
        this.overall = overall;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getAttack() {
        return attack;
    }

    public void setAttack(Score attack) {
        this.attack = attack;
    }

    public Score getDefense() {
        return defense;
    }

    public void setDefense(Score defense) {
        this.defense = defense;
    }

    public Score getMagic() {
        return magic;
    }

    public void setMagic(Score magic) {
        this.magic = magic;
    }

    public Score getCooking() {
        return cooking;
    }

    public void setCooking(Score cooking) {
        this.cooking = cooking;
    }

    public Score getCrafting() {
        return crafting;
    }

    public void setCrafting(Score crafting) {
        this.crafting = crafting;
    }

    public long getOverall() {
        return this.attack.getScore() + this.defense.getScore() + this.magic.getScore() + this.cooking.getScore() + this.crafting.getScore();
    }

    public void setOverall(long overall) {
        this.overall = overall;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", attack=" + attack + ", defense=" + defense +
                ", magic=" + magic + ", cooking=" + cooking + ", crafting=" + crafting + ", level=" + level +"]";
    }
}

