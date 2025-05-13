import greenfoot.*;  // Import necessary Greenfoot classes

/**
 * The Apple class represents a falling apple in the game.
 * It moves downward on the screen and triggers a game over if it reaches the bottom.
 * 
 * Author: Saiful Shaik
 * Version: April 30, 2025
 */
public class Apple extends Actor
{
    // Speed at which the apple falls (not currently used in movement)
    int speed = 1;

    // Constructor: sets the apple image
    public Apple() {
        setImage("images/apple.png");
    }

    // Called repeatedly during the game to define the apple's behavior
    public void act()
    {
        // Get the current x and y coordinates of the apple
        int x = getX();
<<<<<<< HEAD
        int y = getY() + speed;
        setLocation(x, y);
        
=======
        int y = getY() + 1; // Move apple down by 1 pixel
        setLocation(x, y);  // Update the apple's location

        // Get a reference to the current world and cast it to MyWorld
>>>>>>> main
        MyWorld world = (MyWorld) getWorld();

        // Check if the apple has reached the bottom of the screen
        if(getY() >= world.getHeight()) {
            world.gameOver();         // Trigger the game over sequence
            world.removeObject(this); // Remove the apple from the world
        }
    }

    // Method to set the apple's falling speed (currently unused)
    public void setSpeed(int spd) {
        speed = spd;
    }
}