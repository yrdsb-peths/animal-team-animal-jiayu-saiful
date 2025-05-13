import greenfoot.*;  // Import necessary Greenfoot classes

/**
 * The Elephant class represents the player character.
 * It can move left and right, play an animation, and eat apples.
 * 
 * Author: Jiayu
 * Version: April 28
 */
public class Elephant extends Actor
{
    // Sound to play when the elephant eats an apple
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    // Arrays to hold animation frames for idle right and idle left
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // Current direction the elephant is facing
    String facing = "right";
    
    // Timer to control animation speed
    SimpleTimer animationTimer = new SimpleTimer();

    // Constructor: load and prepare animation images
    public Elephant() {
        // Load and scale right-facing images
        for (int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        setImage(idleRight[0]); // Set initial image

        // Load, flip, and scale left-facing images
        for (int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();  // Flip image to face left
            idleLeft[i].scale(100, 100);
        }

        animationTimer.mark();  // Start the animation timer

        setImage(idleLeft[0]);  // Optional: could set initial image based on facing
    }

    int imageIndex = 0;  // Current index for animation frame

    // Method to cycle through animation frames based on direction
    public void animateElephant() {
        // Limit how often the frame changes (every 100 milliseconds)
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();  // Reset the timer

        // Set the next image based on the current facing direction
        if (facing.equals("right")) {
            setImage(idleRight[imageIndex]);
        } else {
            setImage(idleLeft[imageIndex]);
        }

        // Move to the next frame (loop back to 0 at the end)
        imageIndex = (imageIndex + 1) % idleRight.length;
    }

    // Called repeatedly to define the elephant's behavior
    public void act()
    {
        // Handle left and right movement based on key presses
        if (Greenfoot.isKeyDown("left")) {
<<<<<<< HEAD
            move(-3);
            facing = "left";
        } else if (Greenfoot.isKeyDown("right")) {
            move(3);
            facing = "right";
=======
            move(-1);           // Move left
            facing = "left";    // Update facing direction
        } else if (Greenfoot.isKeyDown("right")) {
            move(1);            // Move right
            facing = "right";   // Update facing direction
>>>>>>> main
        }

        eat();              // Check for and handle apple collection
        animateElephant();  // Update animation
    }

    // Method for handling apple collection
    public void eat() {
        // If touching an Apple object
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class); // Remove the apple
            MyWorld world = (MyWorld) getWorld(); // Get the game world
            world.createApple();         // Create a new apple
            world.increaseScore();       // Increase the player's score
            elephantSound.play();        // Play the eating sound
        }
    }
}