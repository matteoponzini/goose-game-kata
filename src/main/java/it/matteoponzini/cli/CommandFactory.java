package it.matteoponzini.cli;
//TODO: add javadoc
public class CommandFactory {
    //TODO: add javadoc
    public static Command getTypeCommand(String commandName){
        switch (TypeCommand.getTypeCommand(commandName.toUpperCase())){
            case ADD: return new AddCommand();
            case MOVE:return new MoveCommand();
            case EXIT: return new ExitCommand();
            default: return new HelpCommand();
        }
    }
}
