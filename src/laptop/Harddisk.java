package laptop;

public class Harddisk {
    private int size;
    private String type;

    Harddisk(){
        System.out.println("Setting up Harddisk...");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Harddisk{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
