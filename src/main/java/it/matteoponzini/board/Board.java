package it.matteoponzini.board;

import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.exception.PlayerNotExistException;
import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.output.*;
import it.matteoponzini.utils.*;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

//TODO: javadoc
public class Board {
    private List<PositionPlayer> positionPlayers;
    private PlayerStrategy<PositionPlayer> addPlayerStrategy;
    private PlayerStrategy<PositionPlayer> removePlayerStrategy;
    private PlayerStrategy<PositionPlayer> movePlayerStrategy;
    private WinStrategy winStrategy;
    public EventManager eventManager;
    Map<Integer, BoostStrategy> boostPosition = new HashMap<>();


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
        this.eventManager.subscribe("boost", new BoostListener());
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
        this.eventManager.subscribe("boost", new BoostListener());
    }

    public Board addPlayer(Player player) throws PlayerAlredyExistExeptionException, PlayerNotExistException {
        addPlayerStrategy.execute(player, positionPlayers);
        this.eventManager.notify("add", player);
        return this;
    }

    public Board removePlayer(Player player){
        return this;
    }

    public Board movePlayer(Player player) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, PlayerAlredyExistExeptionException, PlayerNotExistException {
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
                boolean boost = false;
                boolean show = true;
                Reflections ref = new Reflections("it.matteoponzini.boost");
                Iterator<Class<?>> iterator = ref.getTypesAnnotatedWith(Position.class).iterator();
                while (iterator.hasNext() && !boost){
                    Class<?> cl = iterator.next();
                    Position findable = cl.getAnnotation(Position.class);
                    BoostStrategy  boostStrategy = (BoostStrategy) cl.getDeclaredConstructor().newInstance();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Player: ")
                            .append(positionPlayer.getPlayer().getName())
                            .append(" rolls ")
                            .append(positionPlayer.getFirstDice())
                            .append(", ")
                            .append(positionPlayer.getSecondDice())
                            .append(" ")
                            .append(positionPlayer.getPlayer().getName()).append(" moves from ");
                    if(positionPlayer.getLastPosition() == 0){
                        stringBuilder.append("Start to ");
                    }else{
                        stringBuilder.append(positionPlayer.getLastPosition())
                                .append(" to ");
                    }
                    for (Integer find: findable.positon()) {
                        if(find == positionPlayer.getPosition()){
                            boost = true;
                            show = false;
                            boostStrategy.execute(positionPlayer);
                            if(positionPlayer.getLastPosition() != 0){
                                stringBuilder.append(positionPlayer.getLastPosition()).append(" ");
                            }
                            stringBuilder.append(findable.name())
                                    .append(" ")
                                    .append(positionPlayer.getPlayer().getName())
                                    .append(" ").append(findable.action())
                                    .append(" to ");
                        }
                    }
                    if(boost){
                        stringBuilder.append(positionPlayer.getPosition());
                        this.eventManager.notify("boost", stringBuilder);
                    }
                }
                if(show) {
                    this.eventManager.notify("roll", positionPlayer);
                }
                break;
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
