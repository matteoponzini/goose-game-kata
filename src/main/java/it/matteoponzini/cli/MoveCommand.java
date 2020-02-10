package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
import it.matteoponzini.game.Player;
import it.matteoponzini.utils.MovePlayer;

//TODO: add javadoc
public class MoveCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board board) {
        board.movePlayer(new Player((String) args[1]));
    }
}
