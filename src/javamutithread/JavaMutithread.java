package javamutithread;

import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    LogClass logClass=new LogClass("Hello from Thread A");
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
           logClass.register();
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class RunnerB implements Runnable{
    
    LogClass logClass=new LogClass("Hello from Thread B");
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            logClass.register();
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
        
        SyncThreads st=new SyncThreads();
        
        System.out.println(st.doCount());
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
