void main() {

    IO.println("hello solid");

    PaymentInterface cashPay = new CashPayment();
    cashPay.pay();

    PaymentInterface bkashPay = new BkashPayment();
    bkashPay.pay();

    Switch s1 = new Switch(new AppleBulb()); //Dependency Inversion Principle(DIP)
    s1.press();
}
