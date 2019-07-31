package adventure;

/**
 * 
 * This Class is used to lock lockable items in room. In order to lock the item
 * must be taken. Once locked item will be added as an achievement to the player.
 *
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class LockCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        
        String name = getSecondWord();
        
        if (name == null) {
            return "What should we lock?";
        }
        
        
        if (player.hasItem(name)) {
            return Message.lockPutDownMessage(name);
        }
        
        
        if (room.hasItem(name)) {
            Item item = room.getItem(name);
            if (item.hasState(State.LOCKED)) {
                return Message.objectIsLockedMessage(name);
            }
            if (item.hasAttribute(Attribute.LOCKABLE)) {
                item.addState(State.LOCKED);
                player.earnAchievement(Achievement.LOCKED_BIKE);
                return Message.lockSuccessMessage(name);
            }
            
            return Message.lockNotPossibleMessage(name);
        }
        
        
        return Message.cantSeeMessage(name);
        
    }

}
