import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

//Display creates the game window and updates graphics
 
public class Display
{
    public BufferStrategy strategy;
    public Graphics2D g;
    Canvas canvas;
    
    public Display(int width, int height)
    {
        JFrame frame = new JFrame("Space Defender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIgnoreRepaint(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setBackground(Color.BLACK);
        canvas.setIgnoreRepaint(true); //IMPORTANT, MUST ALSO INCLUDE!
        frame.add(canvas);
        
        frame.pack();
        frame.setVisible(true);
        canvas.createBufferStrategy(2);
        strategy = canvas.getBufferStrategy();        
    }
    
    public void update() 
    {
        for (int i = 0; i < SDGame.gameObjects.size(); i++)
            SDGame.gameObjects.get(i).move();        
    }
}
