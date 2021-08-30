public class HamMain {

    public static void main (String[] args){

        Brett brett = new Brett(5);
        Cook cook1 = new Cook("Etkar", brett);
        Cook cook2 = new Cook("AM", brett);
        Waiter waiter1 = new Waiter("Adrian", brett);

        cook1.start();
        waiter1.start();
        cook2.start();


    }

}
