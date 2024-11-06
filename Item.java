/**
 * Class Item - represents an item in the adventure game.
 * 
 * This class holds the details of an item, including its name, description, and weight.
 * 
 * @author  Lirik Salihu
 * @version 2024.11.05
 */
public class Item 
{
    private String name;
    private String description;
    private double weight;

    /**
     * Constructs a new Item instance with the given name, description, and weight.
     * 
     * @param name The name of the item.
     * @param description A brief description of the item.
     * @param weight The weight of the item, typically measured in kilograms or grams.
     */
    public Item(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    /**
     * Gets the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the item.
     * 
     * @return A brief description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the weight of the item.
     * 
     * @return The weight of the item.
     */
    public double getWeight() {
        return weight;
    }
}
