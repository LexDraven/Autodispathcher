package autobusdispatcher.speakers;

import autobusdispatcher.Event;


public class TemporarySpeaker implements Speaker {

    @Override
    public void speak(String message) {
        System.out.println("Dispatcher: " +message);
    }

    @Override
    public void speak(Event event) {
        speak(event.getMessage());
    }

}
