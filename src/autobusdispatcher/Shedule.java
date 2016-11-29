package autobusdispatcher;

import autobusdispatcher.events.EmptyEvent;
import autobusdispatcher.events.Event;
import autobusdispatcher.events.EventComparator;
import java.util.Iterator;
import java.util.LinkedList;


public class Shedule {
    private LinkedList<Event> events;
    private boolean isSheduleOver=false;

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
        if (events.contains(event)) {
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
    
    public boolean isEmpty(){
        return events.isEmpty();
    }
    
    public Event checkShedule(int time){
        if (events.isEmpty()) {
            isSheduleOver = true;
            return new EmptyEvent();
        }
        Iterator <Event> iterator = events.iterator();
        Event ev=null; int max=0;
        while (iterator.hasNext()){
            ev =iterator.next();
            int eventTime = ev.getTimeSomeMinutesBefore(5);            
            if (eventTime==time) {
                iterator.remove();
                return ev;
            }   
            if (eventTime>max) {
                max=eventTime;
            }
        }
        isSheduleOver = time > max;
        return new EmptyEvent();
    }

    public boolean isIsSheduleOver() {
        return isSheduleOver;
    }

}
