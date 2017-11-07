package javamutithread;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Gustavo
 */
public class LogClass {
    
    String msg;
    static final Logger logger = Logger.getLogger("thread");
    FileHandler fh;
    
    public LogClass(String msg){
        this.msg=msg;
    }
    
    public void register(){
        try{
                fh=new FileHandler("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\JavaMutithread\\src\\log\\thread.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                logger.setUseParentHandlers(false);
                logger.info(this.msg);
                
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(RunnerA.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
