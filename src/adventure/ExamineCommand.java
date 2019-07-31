package adventure;

/**
 * 
 * This class extends the Command class. This class will be used to examine the
 * objects. This class gives the information about the objects.
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class ExamineCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
        
        String name = getSecondWord();
        
        if (!room.hasItem(name) && !player.hasItem(name)) {
            return Message.cantSeeMessage(name);
        }
        
        Item item = null;
        if (room.hasItem(name)) {
            item = room.getItem(name);
        }
        else {
            item = player.getItem(name);
        }
        
        if (item.hasState(State.LOCKED)) {
            return item.getDescription() + " " + Message.objectIsLockedMessage(name);
        }
        
        if (item.getDescription() == null) {
            return Message.examineDefaultMessage(name);
        }
        return item.getDescription();
        
     
    }

}
