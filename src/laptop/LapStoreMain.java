package laptop;

public class LapStoreMain {
    public static void main(String[] args) {
        Laptop laptopOne = new Laptop();
        Laptop laptopTwo = new Laptop();

        Processor processorOne = new Processor();
        processorOne.setGhz(16);
        processorOne.setGen("First");

        Ram ram = new Ram();
        ram.setType("TestRam");
        ram.setRamSize(16);

        Harddisk harddisk = new Harddisk();
        harddisk.setSize(512);
        harddisk.setType("Standard");

        laptopOne.setLogo("Mac");
        laptopOne.setHdd(harddisk);
        laptopOne.setProcessor(processorOne);
        laptopOne.setRam(ram);

        Processor processorTwo = new Processor();
        processorTwo.setGhz(8);
        processorTwo.setGen("Second");

        Harddisk hardDiskTwo = new Harddisk();
        hardDiskTwo.setSize(256);
        hardDiskTwo.setType("SDD");

        laptopTwo.setLogo("Mac");
        laptopTwo.setHdd(hardDiskTwo);
        laptopTwo.setProcessor(processorTwo);
        laptopTwo.setRam(ram);

        System.out.println("Laptop delivered to Bob :" + laptopOne);
        System.out.println("Laptop delivered to Tom :" + laptopTwo);
    }
}
