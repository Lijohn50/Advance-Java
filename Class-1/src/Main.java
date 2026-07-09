import javax.imageio.stream.IIOByteBuffer;

void main() {

    IO.println("hello");

    Mobile m1 = new Mobile();
    m1.setBrand("Apple");
    m1.setRamSize(12);
    m1.setPrice(12334.34);
    IO.println(m1.getBrand() + " " + m1.getPrice() + " " + m1.getPrice());

    Mobile m2 = new Mobile("nothing", 120000.32);
    IO.println(m2.getBrand());

    Faculty f1 = new Faculty();
    f1.name = "doe";
    f1.age = 34;
    f1.gender = "male";
    IO.println(f1.name + " " + f1.age + " " + f1.gender);
}
