package autobusdispatcher;

import java.util.Comparator;
import java.util.LinkedList;


public class Shedule {
    private LinkedList<Event> events;

    public Shedule() {
        events = new LinkedList<>();
    }
    
    public Shedule(LinkedList<Event> events) {
        this.events = events;
    }
    
    public void clear(){
        events.clear();
    }
    
    public void addEvent(Event event){
        if (!events.contains(event)){
            events.add(event);
        }
    }
    
    public void removeEvent(Event event){
        if (events.contains(this)) {
            events.remove(event);
        }
    }
    
    public void sortEventsByTime(){
        events.sort(new EventComparator());
    }
    
    public void print(){
        for (Event e:events){
            System.out.println(e.getName()+" - "+e.getMessage()+", time: "+e.getTime());
        }
    }
    
    public Event getLastElement(){
        return events.getLast();
    }
    
    public Event getFirstElement(){
        return events.getFirst();
    }
    
    public LinkedList<Event> getListOfEvents(){
        return events;
    }
    
    public boolean isEmpty(){
        return events.isEmpty();
    }
    
    

}
