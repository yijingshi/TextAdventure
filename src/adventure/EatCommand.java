package adventure;

/**
 * 
 * This Class is used to eat ediable items in room. In order to eat the object
 * must be taken. Once eaten the items will be removed from inventory and
 * room. 
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class EatCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        
        String name = getSecondWord();
        
        if (name == null) {
            return "What should we eat?";
        }
               
        Item item = player.getItem(name);
        
        if (room.hasItem(name)) {
            return Message.dontHaveMessage(name);
        }
        
        if (player.hasItem(name)) {
            if (item.hasAttribute(Attribute.EDIABLE)) {
                item.addState(State.EATEN);
                player.removeItem(name);
                player.earnAchievement(Achievement.ATE_PB);
                return Message.eatSuccessMessage(name);
            }
            return Message.eatNotEdibleMessage(name);
        }
        return Message.cantSeeMessage(name);
        
        
       
    }

}
