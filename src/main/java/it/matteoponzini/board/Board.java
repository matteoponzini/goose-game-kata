package it.matteoponzini.board;

import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.output.AddPlayerListener;
import it.matteoponzini.output.DiceRollsListener;
import it.matteoponzini.output.DrawListener;
import it.matteoponzini.output.WinListener;
import it.matteoponzini.utils.*;

import java.util.ArrayList;
import java.util.List;
//TODO: javadoc
public class Board {
    private List<PositionPlayer> positionPlayers;
    private PlayerStrategy<PositionPlayer> addPlayerStrategy;
    private PlayerStrategy<PositionPlayer> removePlayerStrategy;
    private PlayerStrategy<PositionPlayer> movePlayerStrategy;
    private WinStrategy winStrategy;
    public EventManager eventManager;


    public Board(List<PositionPlayer> positionPlayers) {
        this.positionPlayers = positionPlayers;
        this.addPlayerStrategy = new AddPlayer();
        this.movePlayerStrategy = new MovePlayer();
        this.winStrategy = new WinPositionMax();
        this.eventManager = new EventManager();
        this.eventManager.subscribe("roll", new DiceRollsListener());
        this.eventManager.subscribe("add", new AddPlayerListener());
        this.eventManager.subscribe("win", new WinListener());
        this.eventManager.subscribe("draw", new DrawListener());
    }
    public Board(){
        this.positionPlayers = new ArrayList<>();
        this.addPlayerStrategy = new AddPlayer();
        this.movePlayerStrategy = new MovePlayer();
        this.winStrategy = new WinPositionMax();
        this.eventManager = new EventManager();
        this.eventManager.subscribe("roll", new DiceRollsListener());
        this.eventManager.subscribe("add", new AddPlayerListener());
        this.eventManager.subscribe("win", new WinListener());
        this.eventManager.subscribe("draw", new DrawListener());
    }

    public Board addPlayer(Player player){
        addPlayerStrategy.execute(player, positionPlayers);
        this.eventManager.notify("add", player);
        return this;
    }

    public Board removePlayer(Player player){
        return this;
    }

    public Board movePlayer(Player player){
        PositionPlayer positionPlayer = movePlayerStrategy.execute(player, positionPlayers);
        switch (winStrategy.execute(positionPlayer)){
            case WIN:
                this.eventManager.notify("win", positionPlayer);
                break;
            case DRAW:
                this.eventManager.notify("draw", positionPlayer);
                positionPlayer.setLastPosition(positionPlayer.getLastPosition()-4);
                break;
            default:
                this.eventManager.notify("roll", positionPlayer);
        }
        return this;
    }

    public List<PositionPlayer> getPositionPlayers() {
        return positionPlayers;
    }

    public void setPositionPlayers(List<PositionPlayer> positionPlayers) {
        this.positionPlayers = positionPlayers;
    }

    public PlayerStrategy<PositionPlayer> getAddPlayerStrategy() {
        return addPlayerStrategy;
    }

    public void setAddPlayerStrategy(PlayerStrategy<PositionPlayer> addPlayerStrategy) {
        this.addPlayerStrategy = addPlayerStrategy;
    }

    public PlayerStrategy<PositionPlayer> getRemovePlayerStrategy() {
        return removePlayerStrategy;
    }

    public void setRemovePlayerStrategy(PlayerStrategy<PositionPlayer> removePlayerStrategy) {
        this.removePlayerStrategy = removePlayerStrategy;
    }

    public PlayerStrategy<PositionPlayer> getMovePlayerStrategy() {
        return movePlayerStrategy;
    }

    public void setMovePlayerStrategy(PlayerStrategy<PositionPlayer> movePlayerStrategy) {
        this.movePlayerStrategy = movePlayerStrategy;
    }

    @Override
    public String toString() {
        return "Board{" +
                "positionPlayers=" + positionPlayers +
                '}';
    }

}
