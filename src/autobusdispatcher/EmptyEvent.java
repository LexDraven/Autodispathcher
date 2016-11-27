package autobusdispatcher;


public class EmptyEvent extends Event{

    public EmptyEvent() {
        super("Empty", "test message", 2400,0);
    }
    
    public boolean isEmptyEvent(){
        return true;
    }

}
