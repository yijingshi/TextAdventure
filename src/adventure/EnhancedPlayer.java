package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This Class extends the Player interface.
 * It adds achievement when the player achieve a task
 * It adds item or removes item from player's inventory
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class EnhancedPlayer extends Player
{
    
    private Map<String, Item> itemMap;
    private Set<Achievement> achievements;
    private int maxWeight = 13;
    
    /**
     * Create a new EnhancedPlayer object.
     *
     */
    public EnhancedPlayer()
    {
        super();
        
        itemMap = new HashMap<>();
        achievements = new HashSet<>();
        
    }
    
    /**
     * The achievement the player has.
     *
     * @param a
     * achievement
     * @return achievement
     */
    public boolean hasAchievement(Achievement a) {
        return achievements.contains(a);
    }
    
    /**
     * The achievement the player earned.
     *
     * @param a
     * achievement
     */
    public void earnAchievement(Achievement a) {
        achievements.add(a);
    }
    
    /**
     * add the item in player's inventory.
     *
     * @param item
     * The item in inventory
     */
    public void addItem(Item item) {
        
        itemMap.put(item.getName(), item);
    }
    
    

    /**
     * get the item by matching name from player inventory.
     *
     * @param name
     * The name in inventory
     * @return name of the item
     */
    public Item getItem(String name)
    {
        return itemMap.get(name);
    }
    
    /**
     * find whether the object is in player's inventory.
     *
     * @param name
     * The name in inventory
     * @return
     * name of the item
     */
    public boolean hasItem(String name) {
        return itemMap.containsKey(name);
    }
    
    
    /**
     * remove the item from player's inventory.
     *
     * @param name
     * name of the item
     */
    public void removeItem(String name) {
        itemMap.remove(name);
    }
    /**
     * Get the current value of max weight.
     * 
     * @return The max weight for this object.
     */
    public int getMaxWeight() {
        return maxWeight;
    }
    /**
     * Get weight of all items in inventory
     *
     * @return int total weight
     */
    public int getInventoryWeight() {
        int totalWeight = 0;
        
        for (Item items : itemMap.values()) {
            totalWeight += items.getWeight();
        }
        return totalWeight;
        
    }
    
    /**
     * get the array list of the items in player inventory.
     * 
     * @return an array of items in inventory
     * 
     */
    
    public String getInventoryString() {
        if (itemMap.isEmpty()) {
            return Message.inventoryEmptyMessage();
        }
        
        String description = "<p>You are carrying ";
        
        List<String> itemNameList = new ArrayList<>();
        
        for (Item item : itemMap.values()) {
            itemNameList.add(item.toString());
        }
        
        description += Message.commaSeparatedList(itemNameList);
        description += " with you.";
        
        return description;
    }
    
}
