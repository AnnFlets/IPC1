package hilo;

public class Hilo implements Runnable{
    
    Thread hilo;

    public Hilo() {
        hilo = new Thread(this, "Hilo Movimiento");
        hilo.start();
    }

    
    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hola " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("[Error-Hilo]: " + e.getMessage());
        }
    }
    
}
