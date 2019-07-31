package adventure;

/**
 * 
 * This class is used to drop items from the hand or inventory.
 * once dropped, the items will be removed from the inventory
 * and being added to the room
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class DropCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        
        String name = getSecondWord();
        
        if (!hasSecondWord()) {
            return "The drop command requires an object in your inventory to " + "drop.";
        }
        
        Item item = player.getItem(name);
        
        if (player.hasItem(name)) {
            player.removeItem(name);
            room.addItem(item);
            return Message.dropSuccessMessage(name);
        }
               
        return Message.dropDontHaveMessage(name);
    }

}
