public class AppleBulb implements Bulb{

    //Dependency Inversion Principle(DIP)
        @Override
        public void turnOn() {
            IO.println("Apple bulb is turning on");
        }
}
