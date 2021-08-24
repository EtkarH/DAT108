import javax.swing.*;

public class Main {

    public static void main (String[] args){

        TextObj tekst = new TextObj("Hello world.");
        Thread printer = new Thread(new Runnable() {
            @Override
            public void run() {

                    while (tekst.isQuit()) {
                        try {
                            System.out.println(tekst.getString());
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            }
        });
        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {

                    while(tekst.isQuit()){
                        tekst.setString(JOptionPane.showInputDialog("Skriv noe her: "));
                        if(tekst.getString().equalsIgnoreCase("quit")){
                            tekst.setQuit(false);
                        }
                    }

            }
        });
        printer.start();
        writer.start();

    }

}
