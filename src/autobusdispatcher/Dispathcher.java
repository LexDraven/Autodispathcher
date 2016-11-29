package autobusdispatcher;

import autobusdispatcher.events.Event;
import autobusdispatcher.speakers.Speaker;
import autobusdispatcher.speakers.TemporarySpeaker;


public class Dispathcher {
    Speaker speaker;
    Shedule shedule;
    EventsTimer timer;
    int time=1100;

    public Dispathcher(Speaker speaker, Shedule shedule) {
        this.speaker = speaker;
        this.shedule = shedule;
        initTimer();
    }

    public Dispathcher() {
        speaker = new TemporarySpeaker();
        shedule = new Shedule();
        initTimer();
    }
    
    private void initTimer(){
        timer = new EventsTimer(1);
        timer.start();
    }
    
    public void saySomething (String message) {
        speaker.speak(message);
    }
    
    public void saySomething (Event event) {
        speaker.speak(event);
    }
    
    public void createNewEvent(){
        //TODO 1
    }

    public void addEvent(Event event){
        shedule.addEvent(event);
    }
    
    public void removeEvent(Event event){
        shedule.removeEvent(event);
    }
    
    public void clearShedule(){
        shedule.clear();
    }
    
    public void checkShedule(){
        while (!shedule.isIsSheduleOver()) {
         int currentTime = timer.getCurrentTime();
         if (time!= currentTime) {
             time = currentTime;
             while (true){
                 Event newEventToSpeak = shedule.checkShedule(time);
                 if (!newEventToSpeak.isEmptyEvent()){
                   speaker.speak(newEventToSpeak);
                 }
                 else {
                     break;
                 }                
             }            
         }
        }
        timer.stop();
        shedule.print();
    }
    

}
