package adventure;

import java.applet.Applet;


public class adventureApplet extends Applet {
    /**
     * 
     */
    
    private Game game;

    @Override
    public void init() {
        game = new MyGame();
    }
}