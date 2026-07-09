public class Switch {

    //Dependency Inversion Principle(DIP)
    private Bulb bulb;

    public Switch(Bulb bulb){

        this.bulb = bulb;
    }

    public void press(){

        this.bulb.turnOn();
    }
}
