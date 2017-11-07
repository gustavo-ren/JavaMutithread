package javamutithread;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


class Runner extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.print("Hello " + i+", ");
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Runner2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Hello2 " + i+", ");
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}

class RunnerA extends Thread{
    
    static final Logger logger = Logger.getLogger("thread");
    FileHandler fh;
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try{
                fh=new FileHandler("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\JavaMutithread\\src\\log\\thread.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                logger.setUseParentHandlers(false);
                logger.info("Hello from Thread A");
                
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(RunnerA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class RunnerB implements Runnable{

    static final Logger logger = Logger.getLogger("thread");
    FileHandler fh;
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try{
                fh=new FileHandler("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\JavaMutithread\\src\\log\\thread.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                logger.setUseParentHandlers(false);
                logger.info("Hello from Thread B");
                
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(RunnerA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
public class JavaMutithread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runner runner = new Runner();
        Runner runner1 = new Runner();
                
        runner.start();        
        runner1.start();
                
        Thread thread = new Thread(new Runner2());
        Thread thread2 = new Thread(new Runner2());
        
        thread.start();
        thread2.start();
        
        (new RunnerA()).start();
        (new Thread(new RunnerB())).start();
    }
    
}
