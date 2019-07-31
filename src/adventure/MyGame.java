package adventure;



/**
 * 
 * MyGame class defines the new commands used to command on the object.
 * This class creates and describes room objects in different direction.
 * Also defines different objects in different rooms.
 * 
 *
 * @author yijing
 * @version Apr 21, 2019
 *
 */
public class MyGame extends Game {
    /**
     * Create a new MyGame object.
     *
     */
    public MyGame() {
        super(new EnhancedPlayer(), new Parser());
    }

    /**
     * This method creates a game object.
     *
     * @param args
     * String array
     */
    public static void main(String[] args) {
        Game game = new MyGame();
        game.play();
    }

    @Override
    public void createCommands() {
        CommandWords commands = parser().commandWords();
        commands.addCommand("go",   new EnhancedGoCommand());      
        commands.addCommand("help", new HelpCommand(commands));
        commands.addCommand("quit", new QuitCommand());        
        
        commands.addCommand("west", new EnhancedGoCommand("west"));
        commands.addCommand("w", new EnhancedGoCommand("west"));
        commands.addCommand("east", new EnhancedGoCommand("east"));
        commands.addCommand("e", new EnhancedGoCommand("east"));        
        commands.addCommand("north", new EnhancedGoCommand("north"));
        commands.addCommand("n", new EnhancedGoCommand("north"));
        commands.addCommand("south", new EnhancedGoCommand("south"));
        commands.addCommand("s", new EnhancedGoCommand("south")); 
        
        commands.addCommand("examine", new ExamineCommand());
        commands.addCommand("x", new ExamineCommand());
        
        commands.addCommand("inventory", new InventoryCommand());
        commands.addCommand("i", new InventoryCommand());
        
        commands.addCommand("take", new TakeCommand());
        commands.addCommand("eat", new EatCommand());
        commands.addCommand("take", new TakeCommand());
        commands.addCommand("drop", new DropCommand());
        commands.addCommand("lock", new LockCommand());
        commands.addCommand("kiss", new KissCommand());
        
    }

    @Override
    public void createRooms() {
        // create the rooms
        EnhancedRoom livingRoom = new EnhancedRoom("in your living room");
        EnhancedRoom bedroom = new EnhancedRoom("in your bedroom");
        EnhancedRoom kitchen = new EnhancedRoom("in your kitchen");
        EnhancedRoom outside = new EnhancedRoom("outside your apartment");
        EnhancedRoom playground = new EnhancedRoom("in the playground");

        // Initialize room exits
        livingRoom.setExit("west", bedroom);
        livingRoom.setExit("east", kitchen);
        livingRoom.setExit("south", outside);
        
        outside.setExit("north", livingRoom);
        bedroom.setExit("east", livingRoom);
        kitchen.setExit("west", livingRoom);
        
        outside.setExit("west", playground);
        playground.setExit("east", outside);
        
        
        //initialize room items
        
        Item ruby = new Item("ruby", Message.rubyDescriptionMessage());
        bedroom.addItem(ruby);
        ruby.setWeight(1);
        
        
        Item bicycle = new Item("bicycle", Message.bicycleDescriptionMessage());
        bicycle.addAttribute(Attribute.LOCKABLE);
        livingRoom.addItem(bicycle);
        bicycle.setWeight(10);
        
        Item peanutbutter = new Item("peanut-butter", Message.peanutButterDescriptionMessage());
        peanutbutter.addAttribute(Attribute.EDIABLE);
        kitchen.addItem(peanutbutter);
        peanutbutter.setWeight(2);
        
        Item dog = new Item("dog", null);
        dog.addAttribute(Attribute.KISSABLE);
        playground.addItem(dog);
        dog.setWeight(13);

        // the player starts the game outside
        player().setCurrentRoom(livingRoom);
    }

    @Override
    public String welcomeMessage() {
        return
            "<p>Welcome to The World of Simplicity!</p>"
            + "<p>Type 'help' if you need help.</p>"
            + "<p>Hit [return] to continue...</p>";
    }
} 