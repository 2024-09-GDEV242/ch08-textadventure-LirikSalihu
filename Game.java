/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Lirik Salihu
 * @version 2024.11.05
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    
    /**
     * Constructs a new Game instance, initializing the game environment by creating rooms 
     * and initializing the parser and player.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();  // Initialize the player
    }

    /**
     * Creates the rooms for the game world and sets up exits and items.
     */
    private void createRooms()
    {
        // Create rooms and add items to them
        Room outside = new Room("outside the main entrance of the university");
        outside.addItem(new Item("key", "A small rusty key", 0.5));
        Room theater = new Room("in a lecture theater");
        Room pub = new Room("in the campus pub");
        Room lab = new Room("in a computing lab");
        Room office = new Room("in the computing admin office");

        // Set exits between rooms (not shown here for brevity)

        currentRoom = outside;  // Start the game outside
    }

    /**
     * Starts the game, showing the welcome message and entering the game loop where commands are processed.
     */
    public void play() 
    {   
        printWelcome();
        
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Prints the welcome message to the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Processes the given command by invoking appropriate actions.
     * 
     * @param command The command issued by the player.
     * @return true if the game should end, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                lookRoom();
                break;

            case BACK:
                back();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    /**
     * Prints help text to the player.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Makes the player go to a new room based on the given command.
     * 
     * @param command The command containing the direction to go.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * Makes the player look at the current room and its items.
     */
    private void lookRoom() 
    {
        System.out.println(currentRoom.getLongDescription());
        currentRoom.showItems();
    }

    /**
     * Makes the player go back to the previous room.
     */
    private void back()
    {
        Room previousRoom = player.getPreviousRoom();
        if (previousRoom != null) {
            currentRoom = previousRoom;
            System.out.println(currentRoom.getLongDescription());
        } else {
            System.out.println("You can't go back any further.");
        }
    }

    /**
     * Quits the game if the command is valid.
     * 
     * @param command The quit command.
     * @return true if the game should end, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
