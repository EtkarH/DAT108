import java.util.LinkedList;
import java.util.Queue;

public class Brett {

    private Queue<Burger> burgerBrett;
    private int maxCap;
    private int burgerCount;

    public Brett(int max){
        burgerBrett = new LinkedList<Burger>();
        this.maxCap = max;
        burgerCount = 1;

    }

    public void addBurger(Burger burger){
        if (burgerBrett.size() < maxCap || burgerBrett == null) {

            burgerBrett.add(burger);
            burgerCount++;
        }
    }

    public Burger getBurger(){
        return burgerBrett.poll();
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
