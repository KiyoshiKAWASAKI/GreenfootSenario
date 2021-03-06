import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
 

    public Space() 
    {
        super(600, 400, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 380);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        
        createStars(200);
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing
        int x=getWidth()/2;
        int y=getHeight()/2;
        addObject(new ScoreBoard(999),x,y);
    }
    
    /**This method draw stars on the background,the number give the number of the stars it creats
     * 
     */
    private void createStars(int number)
    {
        GreenfootImage background=getBackground();
        for (int i=0;i<number;i++)
        {
            int x =Greenfoot.getRandomNumber(getWidth());
            int y =Greenfoot.getRandomNumber(getHeight());
            int colorR =200-Greenfoot.getRandomNumber(80);
            int colorB =200-Greenfoot.getRandomNumber(80);
            int colorG =200-Greenfoot.getRandomNumber(80);
            background.setColor(new Color(colorR,colorB,colorG));
            background.fillOval(x,y,2,2);
        }
    }

}
