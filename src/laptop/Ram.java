package laptop;

public class Ram {
    private int ramSize;
    private String type;

    Ram() {
        System.out.println("Setting up RAM...");
    }

    public int getRamSize () {
        return ramSize;
    }

    public void setRamSize (int ramSize) {
        this.ramSize = ramSize;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "ramSize=" + ramSize +
                ", type='" + type + '\'' +
                '}';
    }
}
