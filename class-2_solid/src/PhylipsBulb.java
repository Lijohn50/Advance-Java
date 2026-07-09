public class PhylipsBulb implements Bulb{

    //Dependency Inversion Principle(DIP)
    @Override
    public void turnOn() {
        IO.println("Phylips bulb is turning on");
    }
}
