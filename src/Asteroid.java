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
        setWidth(getSprite().getWidth());
        setHeight(getSprite().getHeight());
        setVelocityX((int)(Math.random() * 5 + 1));
        setVelocityY((int)(Math.random() * 5 + 1));
        setCollidable(true);
        
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
    
    public Asteroid()
    {
        setX((int)(Math.random() * ((SDGame.WINDOW_WIDTH * 4)) -(SDGame.WINDOW_WIDTH * 2)));
        setY((int)(Math.random() * ((SDGame.WINDOW_HEIGHT * 4)) -(SDGame.WINDOW_HEIGHT * 2)));
        setWidth(50);
        setHeight(50);
        setVelocityX((SDGame.WINDOW_CENTRE_X - getX()) / 250);
        setVelocityY((SDGame.WINDOW_CENTRE_Y - getY()) / 250);
        
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
