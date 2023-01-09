import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Starter {
    private static JButton disabled;
    private static JButton mining;
    private static JButton gate;
    private static JButton forward;
    private static JButton arty;
    private static JButton drive;
    private static JButton run;
    private static RuntimeInput r = new RuntimeInput();

    private static int startTimeBTN_MS = 1000;


    public static void main(String s[]) {

        JFrame f=new JFrame("Auto clicker");//creating instance of JFrame

        disabled=new JButton("Disable F2");//creating instance of JButton
        mining=new JButton("Mining");//creating instance of JButton
        gate=new JButton("Gates");//creating instance of JButton
        forward =new JButton("Walk");//creating instance of JButton
        run =new JButton("Run");//creating instance of JButton
        drive=new JButton("Drive");//creating instance of JButton
        arty=new JButton("Arty");//creating instance of JButton

        disabled.setBounds(0,0,120, 40);//x axis, y axis, width, height
        mining.setBounds(0,40,120, 40);//x axis, y axis, width, height
        gate.setBounds(0,80,120, 40);//x axis, y axis, width, height
        forward.setBounds(0,120,120, 40);//x axis, y axis, width, height
        run.setBounds(0,160,120, 40);//x axis, y axis, width, height
        drive.setBounds(0,200,120, 40);//x axis, y axis, width, height
        arty.setBounds(0,240,120, 40);//x axis, y axis, width, height

        disabled.setBackground(Color.RED);
        mining.setBackground(Color.RED);
        gate.setBackground(Color.RED);
        forward.setBackground(Color.RED);
        run.setBackground(Color.RED);
        drive.setBackground(Color.RED);
        arty.setBackground(Color.RED);


        disabled.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setDisabled();
                try { Thread.sleep(startTimeBTN_MS); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                r.buttonActivation("disabled");
            }
        });
        mining.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!r.handler.getDisabled()) {
                    setMining();
                    try { Thread.sleep(startTimeBTN_MS); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                    r.buttonActivation("mining");
                }
            }
        });
        gate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!r.handler.getDisabled()) {
                    setGate();
                    try { Thread.sleep(startTimeBTN_MS); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                    r.buttonActivation("gate");
                }
            }
        });
        forward.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!r.handler.getDisabled()) {
                    setForward();
                    try { Thread.sleep(startTimeBTN_MS); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                    r.buttonActivation("driving");
                }
            }
        });
        run.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!r.handler.getDisabled()) {
                    setRun();
                    try { Thread.sleep(startTimeBTN_MS); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                    r.buttonActivation("run");
                }
            }
        });
        drive.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!r.handler.getDisabled()) {
                    setDrive();
                    try { Thread.sleep(startTimeBTN_MS); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                    r.buttonActivation("drive");
                }
            }
        });
        arty.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!r.handler.getDisabled()) {
                    setArty();
                    try { Thread.sleep(3000); } catch (InterruptedException ex) { throw new RuntimeException(ex); }
                    r.buttonActivation("arty");
                }
            }
        });




        f.add(disabled);//adding button in JFrame
        f.add(mining);//adding button in JFrame
        f.add(gate);//adding button in JFrame
        f.add(forward);//adding button in JFrame
        f.add(run);//adding button in JFrame
        f.add(drive);//adding button in JFrame
        f.add(arty);//adding button in JFrame


        f.setSize(120,320);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        r.start();
    }

    public static void setDisabled() {
        if(disabled.getBackground() == Color.RED)
            disabled.setBackground(Color.GREEN);
        else
            disabled.setBackground(Color.RED);
    }
    public static void setMining() {
        if(mining.getBackground() == Color.RED)
            mining.setBackground(Color.GREEN);
        else
            mining.setBackground(Color.RED);
    }
    public static void setGate() {
        if(gate.getBackground() == Color.RED)
            gate.setBackground(Color.GREEN);
        else
            gate.setBackground(Color.RED);
    }
    public static void setForward() {
        if(forward.getBackground() == Color.RED)
            forward.setBackground(Color.GREEN);
        else
            forward.setBackground(Color.RED);
    }
    public static void setRun() {
        if(run.getBackground() == Color.RED)
            run.setBackground(Color.GREEN);
        else
            run.setBackground(Color.RED);
    }
    public static void setDrive() {
        if(drive.getBackground() == Color.RED)
            drive.setBackground(Color.GREEN);
        else
            drive.setBackground(Color.RED);
    }
    public static void setArty() {
        if(arty.getBackground() == Color.RED)
            arty.setBackground(Color.GREEN);
        else
            arty.setBackground(Color.RED);
    }


    public static void addMiningTextKey(String add) {
        mining.setText(mining.getText() + " " + add);
    }
    public static void addGateTextKey(String add) {
        gate.setText(gate.getText() + " " + add);
    }
    public static void addForwardTextKey(String add) {
        forward.setText(forward.getText() + " " + add);
    }
    public static void addRunTextKey(String add) {
        run.setText(run.getText() + " " + add);
    }
    public static void addDriveTextKey(String add) {
        drive.setText(drive.getText() + " " + add);
    }
    public static void addArtyTextKey(String add) {
        arty.setText(arty.getText() + " " + add);
    }
}
