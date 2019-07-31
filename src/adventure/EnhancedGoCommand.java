package adventure;

/**
 * 
 * This Class extends the Command interface. This command is used to go to
 * different rooms in different directions. Directions are: east (e), west(w),
 * north(n), south(s).
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class EnhancedGoCommand extends GoCommand
{
    
    private String direction;
    
    
    /**
     * Create a new EnhancedGoCommand object.
     *
     * @param direction
     * movement direction
     */
    public EnhancedGoCommand(String direction)
    {
        super();
        this.direction = direction;
       // System.out.println("second word = " + getSecondWord());
    }

    /**
     * Create a new EnhancedGoCommand object.
     *
     */
    public EnhancedGoCommand()
    {
        super();
        direction = null;
    }

    @Override
    public String execute(Player playerArg)
    {
        
        EnhancedPlayer player = (EnhancedPlayer)playerArg;
        
        if (direction != null) {
            setSecondWord(direction);
        }
        
        Room room = player.getCurrentRoom();
        
        if (!room.getExitDirections().contains(getSecondWord())) {
            return Message.noExitInDirectionMessage();
        }
        
        
        if (player.getCurrentRoom().getShortDescription().equals("in your living room") &&
              getSecondWord().equals("south")) {
            if (!player.hasItem("ruby")) {
                return Message.exitWithoutTakingRubyMessage(); 
            }
            if (!player.hasAchievement(Achievement.LOCKED_BIKE)) {
                return Message.exitWithoutLockingBikeMessage();
            }
            if (!player.hasAchievement(Achievement.ATE_PB)) {
                return Message.exitWithoutEatingPBMessage();
            }
      
            player.setCurrentRoom(room);
        }
        
        if (player.getCurrentRoom().getShortDescription().equals("in the playground") && 
                getSecondWord().equals("east"))
        {
            if (!player.hasAchievement(Achievement.KISSED_DOG))
            {
                return "You don't want to go home without kiss the dog";
            }

        }

       
        return super.execute(player);
        
    }
    
    
    

}
