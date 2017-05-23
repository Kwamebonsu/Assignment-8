package assignment.pkg8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author bonsk5852
 */
public class Face extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
    Color lightbrown = new Color(248, 200, 171);
    Color tan = new Color(112, 65, 57);
    Color notWhite = new Color(210, 210, 210);
    int eyebrowHeight = 375;
    int eyebrowDirection = 1;
    int iris = 30;
    int irisDirection = 1;
    int irisX1 = 285;
    int irisX2 = 485;
    int irisY = 410;
    int eyeHeight = 50;
    int eyeYPosition = 400;
    int pupil = 10;
    int blinker = 200;
    int blink = 0;
    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)

    @Override
    public void paintComponent(Graphics g) {
//        Random rand = new Random();
//        int sieze = rand.nextInt(3) + 1;
//        switch (sieze) {
//            case 1:
//                g.setColor(Color.BLACK);
//                break;
//            case 2:
//                g.setColor(tan);
//                break;
//            case 3:
//                g.setColor(tan);
//                break;
//            case 4:
//                g.setColor(tan);
//                break;
//            case 5:
//                g.setColor(tan);
//                break;
//            case 6:
//                g.setColor(tan);
//                break;
//            case 7:
//                g.setColor(tan);
//                break;
//            case 8:
//                g.setColor(Color.magenta);
//                break;
//            case 9:
//                g.setColor(Color.CYAN);
//                break;
//            case 10:
//                g.setColor(tan);
//                break;
//            default:
//                break;
//        }
//        g.fillRect(0, 0, WIDTH, HEIGHT);
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        // GAME DRAWING GOES HERE 
        // Draw hair
        g.setColor(Color.BLACK);
        g.fillRoundRect(200, 150, 400, 400, 10, 10);
        // Draw a head
        g.setColor(tan);
        g.fillOval(200, 200, 400, 600);
        // Fix that Hairline
        g.setColor(Color.BLACK);
        g.fillRect(200, 200, 400, 100);
        g.fillOval(210, 220, 380, 100);
        g.setColor(tan);
        // Draw ears
        g.fillOval(180, 420, 40, 130);
        g.fillOval(580, 420, 40, 130);
        // Draw closed eyes
        g.setColor(Color.BLACK);
        g.fillRect(250, 420, 100, 10);
        g.fillRect(450, 420, 100, 10);
        // Draw 2 eyes
        g.setColor(Color.WHITE);
        g.fillOval(250, eyeYPosition, 100, eyeHeight);
        g.fillOval(450, eyeYPosition, 100, eyeHeight);
        // Draw eyebrows
        g.setColor(Color.BLACK);
        g.fillRect(250, eyebrowHeight, 100, 15);
        g.fillRect(450, eyebrowHeight, 100, 15);
        // Draw details on the eyes
        g.setColor(Color.CYAN);
        g.fillOval(irisX1, irisY, iris, iris);
        g.fillOval(irisX2, irisY, iris, iris);
        g.setColor(Color.BLACK);
        g.fillOval(295, 420, pupil, pupil);
        g.fillOval(495, 420, pupil, pupil);
        // Draw a nose
        g.drawArc(350, 500, 100, 50, 180, 180);
        // Draw a mouth
        g.setColor(Color.PINK);
        g.fillArc(300, 600, 200, 100, 180, 180);
        // Draw teeth
        g.setColor(Color.WHITE);
        g.fillRect(310, 650, 180, 20);
        g.fillArc(325, 660, 150, 40, 180, 180);
        g.setColor(notWhite);
        g.drawRect(310, 650, 20, 20);
        g.drawRect(330, 650, 20, 20);
        g.drawRect(350, 650, 20, 20);
        g.drawRect(370, 650, 20, 20);
        g.drawRect(390, 650, 20, 20);
        g.drawRect(410, 650, 20, 20);
        g.drawRect(430, 650, 20, 20);
        g.drawRect(450, 650, 20, 20);
        g.drawRect(470, 650, 20, 20);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE
            if (eyebrowHeight > 375) {
                eyebrowDirection = -1;
            }
            if (eyebrowHeight < 325) {
                eyebrowDirection = 1;
            }
            eyebrowHeight = eyebrowHeight + eyebrowDirection * 3;

            if (blinker >= 200) {
                eyeHeight = 0;
                iris = 0;
                blink = -20;
            }
            if (blinker <= 50) {
                eyeHeight = 50;
                iris = 30;
                blink = 1;
            }
            blinker = blinker + blink;

            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        Face game = new Face();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());

        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}