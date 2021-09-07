import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Brett {

    private BlockingQueue<Burger> burgerBrett;
    private int maxCap;
    private int burgerCount;

    public Brett(int max){
        burgerBrett = new LinkedBlockingQueue<>(max);
        this.maxCap = max;
        burgerCount = 1;

    }

    public void addBurger(Burger burger) throws InterruptedException {
        if (burgerBrett.size() < maxCap || burgerBrett == null) {

            burgerBrett.put(burger);
            burgerCount++;
        }
    }

    public Burger getBurger() throws InterruptedException {
        return burgerBrett.take();
    }

    public boolean isEmpty(){
        return burgerBrett.isEmpty();
    }

    public boolean isFull(){
        return burgerBrett.size() == maxCap;
    }

    public int getBurgerCount(){
        return burgerCount;
    }

    @Override
    public String toString(){
        return "Counter: " + burgerBrett.toString();
    }

}
