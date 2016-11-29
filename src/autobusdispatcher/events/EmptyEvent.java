package autobusdispatcher.events;


public class EmptyEvent extends Event{

    public EmptyEvent() {
        super("Empty", "test message", "24-00",0);
    }
    
    public boolean isEmptyEvent(){
        return true;
    }

}
