import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Clicker implements Runnable {
    private Midder midder;
    private boolean stopped = false;


    public void run() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            //if the bot is disable, no command should be taken
            if(!midder.getDisabled()) {
                //disable driving
                driveOFF(robot);
                //If user clicked drive, Start pressing W and space
                walk(robot);
                //if user run, start W and shift
                run(robot);
                //if drive pressed, start W
                driveON(robot);
                //If user clicked Click, then left-click
                click(robot);
                //if user clicked Gate, then press E
                gate(robot);
                //if user clicked ARty, they left-click and R
                arty(robot);
            }
        }
    }
    public void setMidder(Midder m) {
        midder = m;
    }

    private synchronized void walk(Robot robot) {
        //walk. W + space
        if(midder.getForwardPressed()) {
            robot.keyPress(KeyEvent.VK_W);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            stopped = false;
        }
    }
    private synchronized void run(Robot robot) {
        //run. W + shift + space
        if(midder.getRunPressed()) {
            robot.keyPress(KeyEvent.VK_W);
            robot.keyPress(KeyEvent.VK_SHIFT);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            stopped = false;
        }
    }
    private synchronized void driveON(Robot robot) {
        //drive. W
        if(midder.getDrivePressed()) {
            robot.keyPress(KeyEvent.VK_W);
            stopped = false;
        }
    }
    private synchronized void driveOFF(Robot robot) {
        if(!midder.getForwardPressed()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!stopped) {
                robot.keyRelease(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                stopped = true;
            }
        }
    }
    private synchronized void click(Robot robot) {
        //left click
        if(midder.getClickPressed()) {
            // Simulate a mouse click
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }
    private synchronized void gate(Robot robot) {
        //E
        if(midder.getGatePressed()) {
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
        }
    }
    private synchronized void arty(Robot robot) {
        //left click + right click + R
        if(midder.getArtyPressed()) {
            robot.mousePress(InputEvent.BUTTON3_MASK);

            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            robot.mouseRelease(InputEvent.BUTTON3_MASK);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
        }
    }
}
