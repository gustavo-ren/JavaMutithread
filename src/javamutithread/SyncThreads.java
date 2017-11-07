package javamutithread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class SyncThreads {
    
    private Integer count = 0;
    
    private synchronized void increment(){
        this.count++;
    }
    public String doCount(){
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SyncThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.count.toString();
    }
}
