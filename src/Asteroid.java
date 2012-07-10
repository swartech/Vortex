import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//Creates Asteroid Objects with random velocities that deflect off walls

public class Asteroid extends GameObject
{

    public Asteroid(int x, int y)
    {
        setX(x);
        setY(y);
        setVelocityX((int)(Math.random() * 4 + 1));
        setVelocityY((int)(Math.random() * 4 + 1));
        setWidth(50);
        setHeight(50);
        
        try
        {
            setSprite(ImageIO.read(new File("img/asteroid.png")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        
        SDGame.gameObjects.add(this);                
    }    
}
