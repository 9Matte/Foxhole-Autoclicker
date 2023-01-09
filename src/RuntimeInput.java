import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RuntimeInput implements NativeKeyListener {
    public static Midder handler = new Midder();

    public void nativeKeyPressed(NativeKeyEvent e) {
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(KeyBind.MINING)) { handler.Click(); Starter.setMining(); }
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(KeyBind.GATE)) { handler.Gate(); Starter.setGate(); }
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(KeyBind.FORWARD)) { handler.Forward(); Starter.setForward(); }
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(KeyBind.RUN)) { handler.Run(); Starter.setRun(); }
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(KeyBind.DRIVE)) { handler.Drive(); Starter.setDrive(); }
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals(KeyBind.ARTY)) { handler.Arty(); Starter.setArty(); }
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("F2")) { handler.Disable(); Starter.setDisabled(); } //Disable all new input
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("F3")) safeStop(); //Safe close for all active keys
    }

    public void buttonActivation(String s) {
        if(s.equals("mining")) { handler.Click(); Starter.setMining(); }
        if(s.equals("gate")) { handler.Gate(); Starter.setGate(); }
        if(s.equals("moving")) { handler.Forward(); Starter.setForward(); }
        if(s.equals("run")) { handler.Run(); Starter.setRun(); }
        if(s.equals("drive")) { handler.Drive(); Starter.setDrive(); }
        if(s.equals("arty"))  { handler.Arty(); Starter.setArty(); }
    }

    public void start(){
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new RuntimeInput());

        Clicker obj = new Clicker();
        obj.setMidder(handler);
        new Thread(obj).start();

        setUpKeys();
    }

    public void setUpKeys() {
        try {
            File myObj = new File("./keybind.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                KeyBind.setKey(myReader.nextLine());
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void safeStop() {
        if(handler.getClickPressed()) { handler.Click(); Starter.setMining(); }
        if(handler.getGatePressed()) { handler.Gate(); Starter.setGate(); }
        if(handler.getForwardPressed()) { handler.Forward(); Starter.setForward(); }
        if(handler.getRunPressed()) { handler.Run(); Starter.setRun(); }
        if(handler.getDrivePressed()) { handler.Drive(); Starter.setDrive(); }
        if(handler.getArtyPressed()) { handler.Arty(); Starter.setArty(); }
        if(!handler.getDisabled()) { handler.Disable(); Starter.setDisabled(); }
    }
}