import java.util.LinkedList;
import java.util.Queue;

public class Brett {

    private Queue<Burger> burgerBrett = new LinkedList<>();
    private int maxCap;
    private int burgerCount;

    public Brett(int max){
        this.maxCap = max;
        burgerCount = 1;

    }

    public void addBurger(Burger burger){
        if (burgerBrett.size() < maxCap) {
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
        String string = "Brett: [";

        while (burgerBrett.iterator().hasNext()){
            string += burgerBrett.iterator().next().toString() + "' ";
        }
        string += "]";
        return string;
    }

}
