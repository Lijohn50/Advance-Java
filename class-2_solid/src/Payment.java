public class Payment {

    public void pay(String type){

        if(type.equals("Cash")){

            IO.println("Cash Payment");
        }else if(type.equals("Credit Card")){

            IO.println("Credit Card Payment");
        }
    }
}
