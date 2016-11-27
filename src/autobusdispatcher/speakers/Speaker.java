package autobusdispatcher.speakers;

import autobusdispatcher.Event;

public interface Speaker {
    public void speak(String message); 
    public void speak(Event event);
}
