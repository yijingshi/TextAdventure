package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class is inherited from Room class. This class describes the room type
 * and its properties.
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class EnhancedRoom extends Room
{
    
    private Map<String, Item> itemMap;
    
    /**
     * Create a new EnhancedRoom object.
     *
     * @param description
     * room description
     */
    public EnhancedRoom(String description)
    {
        super(description);
        
        itemMap = new HashMap<>();       
        
    }
    
    
    /**
     * add the item to the room.
     *
     * @param item
     * The item in inventory
     */
    public void addItem(Item item) {
        
        itemMap.put(item.getName(), item);
    }


    /**
     * get the item from the room.
     *
     * @param name
     * The name of the inventory
     * @return the Item matches the item name
     */
    public Item getItem(String name)
    {
        return itemMap.get(name);
    }
    
    /**
     * checks to see if the room has the item.
     *
     * @param name
     * The name of the inventory
     * @return the item in inventory
     */
    public boolean hasItem(String name) {
        return itemMap.containsKey(name);
    }
    
    
    /**
     * remove the item from the room.
     *
     * @param name
     * The item in inventory
     */
    public void removeItem(String name) {
        itemMap.remove(name);
    }
    
    @Override
    public String getLongDescription()
    {
        String description = super.getLongDescription();
        
        if (itemMap.isEmpty()) {
            return description;
        }
        
        description += "<p>You see ";
        
        List<String> itemNameList = new ArrayList<>();
        
        for (Item item : itemMap.values()) {
            itemNameList.add(item.toString());
        }
        
        description += Message.commaSeparatedList(itemNameList);
        description += " here.";
        
        return description;
        
        
    }
    
    
}
