package adventure;

/**
 * 
 * This Class is used to kiss kissable items in room. In order to kiss the item
 * must be taken. Once kiss the item will be added as an achievement to the player.
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class KissCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
       // EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        
        String name = getSecondWord();
        
        if (name == null) {
            return "What should we do?";
        }
        
        Item item = player.getItem(name);
        if (player.hasItem(name)) {
            if (item.hasAttribute(Attribute.KISSABLE)) {
                item.addState(State.KISSED);
                player.earnAchievement(Achievement.KISSED_DOG);               
                return "You kiss the dog. " + Message.youWinMessage();            
            }
            return name + " is not kissable";
        }

        
        return "You need to take the " + name + " in order to kiss it.";

    }

}
