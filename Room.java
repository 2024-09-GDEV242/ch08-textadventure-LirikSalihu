import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Lirik Salihu
 * @version 2024.11.05
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; 
    private ArrayList<Item> items;  // Items in the room

    /**
     * Creates a room with a specified description. Initially, the room
     * has no exits and no items.
     * 
     * @param description A short description of the room (e.g., "in a library").
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();  // Initialize item list
    }

    /**
     * Sets an exit from this room in a given direction to a neighboring room.
     * 
     * @param direction The direction of the exit (e.g., "north", "south").
     * @param neighbor The neighboring room in the specified direction.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Adds an item to this room's list of items.
     * 
     * @param item The item to add to the room.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Provides a long description of this room, including available exits.
     * 
     * @return A string describing the room and its exits.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Displays a list of items currently in the room. If no items are present,
     * informs the player that the room is empty.
     */
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("There are no items here.");
        } else {
            for (Item item : items) {
                System.out.println("Item: " + item.getName() + " - " + item.getDescription());
            }
        }
    }

    /**
     * Generates a string listing all exits available from this room.
     * 
     * @return A string representing the available exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Retrieves the neighboring room in the specified direction.
     * 
     * @param direction The direction of the desired exit.
     * @return The room in the specified direction, or null if no exit exists.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}