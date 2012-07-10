import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

//Main Game class, initiates game and handles the high level functionality

public class SDGame 
{
    public static ArrayList <GameObject>gameObjects = new ArrayList<GameObject>();
    public static Asteroid asteroid;
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 800;
    
    public static void main(String[] args) 
    {
	//create the game window
	Display display = new Display(WINDOW_WIDTH, WINDOW_HEIGHT);
	asteroid = new Asteroid(375, 375);
	
	while(true) 
	{
            display.update();            
            do
            {
                do
                {
                    Graphics2D g = (Graphics2D)display.strategy.getDrawGraphics();
                    
                    for (int i = 0; i < gameObjects.size(); i++)
                    {
                        try
                        {
                            g.drawImage(ImageIO.read(new File("img/black.png")), 0, 0, null);
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                       g.drawImage(gameObjects.get(i).getSprite(), gameObjects.get(i).getX(), gameObjects.get(i).getY(), null); 
                    }
                    g.dispose();
                }
                while(display.strategy.contentsRestored());            
                display.strategy.show();
            }
            while(display.strategy.contentsLost());
            //sleep
        }
    }
}
