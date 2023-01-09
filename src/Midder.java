public class Midder {
    private boolean clickPressed = false;
    private boolean closeGatePressed = false;
    private boolean forwardPressed = false;
    private boolean runPressed = false;
    private boolean drivePressed = false;
    private boolean artyPressed = false;
    private boolean disabled = false;



    public void Click() {
        clickPressed = !clickPressed;
        System.out.println(clickPressed + " " + getClickPressed());
    }
    public void Gate() { closeGatePressed = !closeGatePressed; }
    public void Forward() { forwardPressed = !forwardPressed; }
    public void Run() { runPressed = !runPressed; }
    public void Drive() { drivePressed = !drivePressed; }
    public void Arty() { artyPressed = !artyPressed; }
    public void Disable() { disabled = !disabled; }



    public synchronized boolean getClickPressed() {
        return clickPressed;
    }
    public synchronized boolean getGatePressed() {
        return closeGatePressed;
    }
    public synchronized boolean getForwardPressed() {
        return forwardPressed;
    }
    public synchronized boolean getRunPressed() {
        return runPressed;
    }
    public synchronized boolean getDrivePressed() {
        return drivePressed;
    }
    public synchronized boolean getArtyPressed() {
        return artyPressed;
    }
    public synchronized boolean getDisabled() {
        return disabled;
    }
}
