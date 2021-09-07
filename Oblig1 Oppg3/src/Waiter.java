public class Waiter extends Thread{

    private Brett brett;

    public Waiter(String name, Brett brett){
        this.setName(name);
        this.brett = brett;
    }

    @Override
    public void run(){

        while(true){
                try {
                    Thread.sleep(getRandomNumber(2000,6000));
                            Burger burger = brett.getBurger();
                            System.out.println(this.getName() + " (waiter) just served burger " + burger.toString() + ". " + brett.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }



    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
