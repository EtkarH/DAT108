public class HamMain {

    public static void main (String[] args){

        Brett brett = new Brett(10);
        Cook cook1 = new Cook("Mordi", brett);
        Waiter waiter1 = new Waiter("Fardin", brett);

        cook1.start();
        waiter1.start();


    }

}
