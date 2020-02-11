package it.matteoponzini.game;

import it.matteoponzini.game.Player;

import java.util.Optional;
//TODO: javadoc
public class PositionPlayer {
    private Player player;
    private Integer firstDice;
    private Integer secondDice;
    private Integer lastPosition;

    public PositionPlayer(Player player, Integer firstDice, Integer secondDice) {
        this.player = player;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
        this.lastPosition = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        if(player == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        this.player = player;
    }

    public Integer getFirstDice() {
        return firstDice;
    }

    public Integer getSecondDice() { return secondDice; }

    public Integer getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Integer lastPosition) {
        this.lastPosition = lastPosition;
    }

    public void setPosition(Integer firstDice, Integer secondDice) {
        if(firstDice == null && secondDice == null){
            throw new NullPointerException("argument cannot be null");
        }
        if(this.firstDice != 0 && this.secondDice != 0){
            this.lastPosition = this.getPosition();
        }
        this.firstDice = firstDice;
        this.secondDice = secondDice;
    }

    public Integer getPosition(){
        return this.lastPosition+this.firstDice+this.secondDice;
    }

    @Override
    public String toString() {
        return "PositionPlayer{" +
                "player=" + player +
                ", firstDice=" + firstDice +
                ", secondDice=" + secondDice +
                ", lastPosition=" + lastPosition +
                '}';
    }
}
