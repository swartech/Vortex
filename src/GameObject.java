import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//template for all Game Objects (asteroids, spaceship, UFO, black hole ...)

abstract class GameObject
{
    private BufferedImage sprite;
    private int x, y, width, height, velocityX, velocityY;
    
    Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);    
    }
    
    boolean collisionCheck(GameObject other)
    {
        if (this.getBounds().intersects(other.getBounds()))
            return true;
        else 
            return false;        
    }
    
    BufferedImage getSprite()
    {
        return sprite;
    }
    
    void setSprite(BufferedImage sprite)
    {
        this.sprite = sprite;
    }

    int getX()
    {
        return x;
    }
    
    void setX(int x)
    {
        this.x = x;
    }
    
    int getY()
    {
        return y;
    }

    void setY(int y)
    {
        this.y = y;
    }
    
    int getWidth()
    {
        return width;
    }
    
    void setWidth(int width)
    {
        this.width = width;
    }
    
    int getHeight()
    {
        return height;
    }

    void setHeight(int height)
    {
        this.height = height;
    }
    
    public int getVelocityX()
    {
        return velocityX;
    }

    public void setVelocityX(int velocityX)
    {
        this.velocityX = velocityX;
    }

    public int getVelocityY()
    {
        return velocityY;
    }

    public void setVelocityY(int velocityY)
    {
        this.velocityY = velocityY;
    }
    
    public void collide()
    {
        if (getX() > SDGame.WINDOW_WIDTH - getWidth() || getX() < 0)
        {
            setVelocityX(getVelocityX() * -1);
        }
        else if (getY() > SDGame.WINDOW_WIDTH - getHeight() || getY() < 0)
        {
            setVelocityY(getVelocityY() * -1);
        }
    }

    public void move()
    {
        collide();
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());  
    }
}