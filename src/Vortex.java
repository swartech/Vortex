import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Vortex extends GameObject
{
    public static int lives = 3;
    
    public Vortex()
    {
        try
        {
            setSprite(ImageIO.read(new File("img/vortex.png")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        
        setWidth(getSprite().getWidth());
        setHeight(getSprite().getHeight());
        setX((SDGame.WINDOW_WIDTH - getWidth()) / 2);
        setY((SDGame.WINDOW_HEIGHT - getHeight()) / 2 );
        setVelocityX(0);
        setVelocityY(0);
   
        SDGame.gameObjects.add(this);
    }
}
