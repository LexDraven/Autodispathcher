package autobusdispatcher.speakers;

import autobusdispatcher.events.Event;

public interface Speaker {
    public void speak(String message); 
    public void speak(Event event);
}
