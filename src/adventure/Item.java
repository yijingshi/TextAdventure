package adventure;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Item class define the properties of item. This class is used to set and get the item properties. 
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class Item
{
    
    
    
    private String name;
    private String description;
    private int weight;
    
    private Set<Attribute> attributes;
    private Set<State> states;
    
    /**
     * Create a new Item object.
     *
     * @param name
     * name of the item
     * @param description
     * Description of the item
     */
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
        states = new HashSet<>();
        attributes = new HashSet<>();
    }
    
    /**
     * if the item has attribute.
     *
     * @param a
     * attributes
     * @return attributes
     */
    public boolean hasAttribute(Attribute a) {
        return attributes.contains(a);
    }
    
    /**
     * if the item has state.
     *
     * @param s
     * state
     * @return item state
     */
    public boolean hasState(State s) {
        return states.contains(s);
    }
    
    /**
     * add state to an item
     *
     * @param s
     * new state
     */
    public void addState(State s) {
        states.add(s);
    }
    
    /**
     * add attribute to an item
     *
     * @param a
     * new attribute
     */
    public void addAttribute(Attribute a) {
        attributes.add(a);
    }

    /**
     * Get the current name of object.
     *
     * @return name of object
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the current description of object.
     *
     * @return The description for this object.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Get the current value of weight.
     *
     * @return The value of weight for this object.
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Set the value of weight for this object.
     * 
     * @param weight
     *            The new value for weight.
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "the " + name;
    }
    
    
    
}
