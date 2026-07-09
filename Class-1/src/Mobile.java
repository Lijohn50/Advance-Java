public class Mobile {

    private String brand;
    private int ramSize;
    private double price;

    public Mobile() {

        this.price = -50;
    }

    public Mobile(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public int getRamSize() {

        return ramSize;
    }

    public void setRamSize(int ramSize) {
        if(ramSize < 0){

            IO.println("size not valid");
        }else {

            this.ramSize = ramSize;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
