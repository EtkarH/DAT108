public class Cook extends Thread{

    private Brett brett;

    public Cook(String name, Brett brett){
        this.setName(name);
        this.brett = brett;
    }

    @Override
    public void run(){

        while(true){
                try {
                    Thread.sleep(getRandomNumber(2000,6000));
                    synchronized (brett) {
                        if (brett.isFull()) {
                            System.out.println(this.getName() + " (cook) tried to put out a burger, but the counter is full! Waiting for burgers to be served.");
                            brett.wait();

                        } else {
                            Burger burger = new Burger(brett.getBurgerCount());
                            brett.addBurger(burger);
                            System.out.println(this.getName() + " (cook) just made burger " + burger.toString() + ". " + brett.toString());
                            brett.notifyAll();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }



    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
