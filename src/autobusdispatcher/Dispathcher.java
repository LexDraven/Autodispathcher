package autobusdispatcher;

import autobusdispatcher.speakers.Speaker;
import autobusdispatcher.speakers.TemporarySpeaker;


public class Dispathcher {
    Speaker speaker;
    Shedule shedule;

    public Dispathcher(Speaker speaker, Shedule shedule) {
        this.speaker = speaker;
        this.shedule = shedule;
    }

    public Dispathcher() {
        speaker = new TemporarySpeaker();
        shedule = new Shedule();
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
    

}
