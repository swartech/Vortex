import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//template for all Game Objects (asteroids, spaceship, UFO, black hole ...)

abstract class GameObject
{
    private BufferedImage sprite;        
    private boolean collidable;
    private int x, y, width, height, velocityX, velocityY;
    
    Rectangle getBounds()
    {
        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());    
    }
    
    //boolean collisionCheck(GameObject other)
    //{
    //  if (this.getBounds().intersects(other.getBounds()) && this.getCollidable() == true || other.getCollidable() == true && this.getBounds().intersects(other.getBounds()))
    //    return true;
    //  else 
    //    return false;        
    // }
    
    BufferedImage getSprite()
    {
        return sprite;
    }
    
    void setSprite(BufferedImage sprite)
    {
        this.sprite = sprite;
    }

    boolean getCollidable()
    {
        return collidable;
    }
    
    void setCollidable(boolean collidable)
    {
        this.collidable = collidable;
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
    
    public void collideWithWalls()
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
    
    public void collide()
    {
        //collideWithWalls();  
        for (int i = 1; i < SDGame.gameObjects.size(); i++)
        {
            if (SDGame.gameObjects.get(i).getBounds().intersects(SDGame.gameObjects.get(0).getBounds()))
            {
                SDGame.gameObjects.get(i).nullify();
                Vortex.lives--;
                if (Vortex.lives < 0)
                {
                    SDGame.gameObjects.get(0).nullify();
                    System.out.println("GAME OVER!");
                    
                }
            }
        }
    }

    private void reflect()
    {
        setVelocityX(getVelocityX() * -1);
        setVelocityY(getVelocityY() * -1);        
    }
    
    private void nullify()
    {
        setSprite(null);
        setVelocityX(0);
        setVelocityY(0);
        setX(-100);
        setY(-100);
        setCollidable(false);        
    }

    public void move()
    {
        collide();
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());  
    }
}