public class Burger {

    private int BurgerId;

    public Burger(int Id){
        this.BurgerId = Id;
    }

    public int getBurgerId() {
        return BurgerId;
    }

    public void setBurgerId(int burgerId) {
        BurgerId = burgerId;
    }

    @Override
    public String toString(){
        return "◖" + BurgerId + "◗";
    }
}
