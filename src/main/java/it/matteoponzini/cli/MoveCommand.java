package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
import it.matteoponzini.game.Player;
import it.matteoponzini.utils.MovePlayer;

import java.lang.reflect.InvocationTargetException;

//TODO: add javadoc
public class MoveCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board board) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        board.movePlayer(new Player((String) args[1]));
    }
}
