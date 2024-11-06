import java.util.ArrayList;


/**
 * Write a description of class Player here.
 *
 * @author Lirik Salihu
 * @version 2024.11.05
 */
public class Player 
{
    private ArrayList<Item> inventory;
    private Room previousRoom;

    /**
     * Constructs a new Player instance with an empty inventory and no previous room.
     */
    public Player() {
        inventory = new ArrayList<>();
        previousRoom = null;
    }

    /**
     * Adds an item to the player's inventory.
     * 
     * @param item The item to be added to the inventory.
     */
    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    /**
     * Sets the previous room the player was in.
     * 
     * @param room The room that the player was previously in.
     */
    public void setPreviousRoom(Room room) {
        previousRoom = room;
    }

    /**
     * Gets the previous room the player was in.
     * 
     * @return The room that the player was in before the current one, or null if no previous room exists.
     */
    public Room getPreviousRoom() {
        return previousRoom;
    }
}
