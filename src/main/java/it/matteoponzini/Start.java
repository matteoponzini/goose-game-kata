package it.matteoponzini;

import it.matteoponzini.board.Board;
import it.matteoponzini.cli.AddCommand;
import it.matteoponzini.cli.Command;
import it.matteoponzini.cli.CommandFactory;
import it.matteoponzini.game.Dice;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Board board = new Board();
        CommandFactory commandFactory = new CommandFactory();
        while (true){
            System.out.print("Inserisci il comando: ");
            String userInput = scanner.nextLine();
            String[] splitedInput = userInput.split("[ ]+");
            Command<Board> command = CommandFactory.getTypeCommand(splitedInput[0]);
            try {
                command.execute(splitedInput, board);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
