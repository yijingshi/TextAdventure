package adventure;

/**
 * 
 *This class extends the Command class. Taking items will add items to the
 * inventory. This call will remove items from the room.
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class TakeCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        
        String name = getSecondWord();
        
        if (name == null) {
            return "What should we take?";
        }
        
        
        if (player.hasItem(name)) {
            return Message.takeAlreadyHaveMessage(name);
        }
        Item item = room.getItem(name);
        if (room.hasItem(name)) {
            if (item.hasState(State.LOCKED)) {
                return Message.takeLockedMessage(name);
            }
            if (item.getWeight() + player.getInventoryWeight() <= player.getMaxWeight()) {
                player.addItem(item);
                
                room.removeItem(name);
                return Message.takeSuccessMessage(name);
            }
            return Message.takeNotEnoughRoomMessage(name);
        }
        return Message.cantSeeMessage(name);
     
   
    }

}
