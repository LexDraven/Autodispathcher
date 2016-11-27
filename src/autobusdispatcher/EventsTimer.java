package autobusdispatcher;

public class EventsTimer implements Runnable{
    private volatile boolean canRun=true;
    private volatile boolean isRunning=false;
    private Thread tred;
    private final int PERIOD;
    private volatile int curTime=1100;
    private long longTime = System.currentTimeMillis();

    public EventsTimer(int period) {
        PERIOD = period*1000;
    }   
  
    public int getCurrentTime(){
        return curTime;        
    }
    
    public void start(){
        if ((canRun) && (!isRunning)) {
            System.out.println("Timer is start now! ");
            tred = new Thread(this);
            tred.start();            
        }   
    }
    
    public void stop(){
        canRun=false;
        while (isRunning) ;
        canRun=true;        
    }

    @Override
    public void run() {
        isRunning = true;
        while (canRun){
            if (System.currentTimeMillis()-longTime>=PERIOD) {                
                curTime+=5;
                String time = Integer.toString(curTime);
                String min = time.substring(2);
                if (Integer.parseInt(min)>55){
                    String hour = time.substring(0, 2);
                    int i = Integer.parseInt(hour);
                    i++;
                    if (i>23) {
                        hour="00";
                    }
                    else {
                        hour = Integer.toString(i);
                    }
                    time = hour+"00";
                    curTime = Integer.parseInt(time);
                }
                longTime = System.currentTimeMillis();
            }  
        }
        isRunning = false;
        System.out.println("Timer stopped now! ");        
    }    

}
