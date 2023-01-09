public class KeyBind {
    public static String MINING;
    public static String GATE;
    public static String FORWARD;
    public static String RUN;
    public static String DRIVE;
    public static String ARTY;

    public static void setKey(String val) {
        val = val.toLowerCase().replace(" ", "").replace("-", "");
        String[] splittedData = val.split(":");
        splittedData[1] = splittedData[1].toUpperCase();
        switch (splittedData[0].toLowerCase()) {
            case "mining": MINING = splittedData[1]; Starter.addMiningTextKey(splittedData[1]); break;
            case "gate": GATE = splittedData[1]; Starter.addGateTextKey(splittedData[1]); break;
            case "forward": FORWARD = splittedData[1]; Starter.addForwardTextKey(splittedData[1]); break;
            case "run": RUN = splittedData[1]; Starter.addRunTextKey(splittedData[1]); break;
            case "drive" : DRIVE = splittedData[1]; Starter.addDriveTextKey(splittedData[1]); break;
            case "arty": ARTY = splittedData[1]; Starter.addArtyTextKey(splittedData[1]); break;
        }
    }
}
