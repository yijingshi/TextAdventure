package adventure;

/**
 * 
 * This class extends the Command class. This class gives the list of inventory
 * items on the player's inventory. 
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class InventoryCommand extends Command
{

    @Override
    public String execute(Player playerArg)
    {
        EnhancedPlayer player = (EnhancedPlayer) playerArg;
        
        return player.getInventoryString();
    }

}
