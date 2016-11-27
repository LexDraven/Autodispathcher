package autobusdispatcher;

import autobusdispatcher.speakers.Speaker;
import autobusdispatcher.speakers.TemporarySpeaker;
import java.util.Iterator;


public class EventsTimer implements Runnable{
    private Shedule shedule;
    private volatile boolean canRun=true;
    private volatile boolean isRunning=false;
    private Thread tred;
    private int curTime=1100;
    private long longTime = System.currentTimeMillis();
    private final Speaker speaker;

    public EventsTimer(Shedule shedule) {
        this.shedule = shedule;    
        speaker = new TemporarySpeaker();
        shedule.sortEventsByTime();
    }
    
    public void setNewShedule(Shedule shedule){
        if (!isRunning) {
            this.shedule = shedule;
        }        
    }
    
    private void getCurrentTime(){
        if (System.currentTimeMillis()-longTime>=1000) {                
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
                checkShedule(curTime);
            }  
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
        while (isRunning) {
            //
        }
        canRun=true;        
    }

    @Override
    public void run() {
        isRunning = true;
        while (canRun){
            getCurrentTime();
            if (shedule.isEmpty()){
                break;            
            }
        }
        isRunning = false;
        System.out.println("Timer stopped now! ");        
    }
    
    public void checkShedule(int time){        
        Iterator <Event> iterator = shedule.getListOfEvents().iterator();
        while (iterator.hasNext()){
            Event ev =iterator.next();
            if (ev.getTime()>time){
                break;
            }
            if (ev.getTime()==time) {
                speaker.speak(ev);                
            }
            iterator.remove();
        }
    }

}
