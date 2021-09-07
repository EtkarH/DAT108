import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockMain {

    public static void main (String[] args){

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        Brett brett = new Brett(KAPASITET);
        for (String navn : kokker) {
            new Cook(navn, brett).start();
        }
        for (String navn : servitorer) {
            new Waiter(navn, brett).start();
        }

        

    }

}
