public class Waiter extends Thread{

    private Brett brett;

    public Waiter(String name, Brett brett){
        this.setName(name);
        this.brett = brett;
    }

    @Override
    public void run(){
        synchronized (brett){
        while(true){



                try {
                    if (brett.isEmpty()){
                        System.out.println("Brett empty!");
                        wait();
                    } else {
                        brett.getBurger();
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
