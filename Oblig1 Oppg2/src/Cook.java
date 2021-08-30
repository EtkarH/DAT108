public class Cook extends Thread{

    private Brett brett;

    public Cook(String name, Brett brett){
        this.setName(name);
        this.brett = brett;
    }

    @Override
    public void run(){
        synchronized (brett){
        while(true){

                try {
                    if (brett.isFull()){
                        System.out.println("Brett full!");
                        wait();
                    } else {
                        brett.addBurger(new Burger(brett.getBurgerCount()));
                        System.out.println(brett.toString());
                        notifyAll();
                    }
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
