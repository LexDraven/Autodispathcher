
import autobusdispatcher.EmptyEvent;
import autobusdispatcher.Event;
import autobusdispatcher.Shedule;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTests {
    
    public MainTests() {
    }
    
    @Test
    public void eventTest(){
        Event event = new Event("name", "message", "23-57",1);
        assertEquals("name", event.getName());
        assertEquals(2357, event.getTime());
        event = new Event("name1", "message1", "23-55",1);
        assertEquals("name1", event.getName());
        assertEquals(2355, event.getTime());
        assertEquals(false,event.isEmptyEvent());
    }
    
    @Test
    public void emptyEventTest(){
        EmptyEvent event = new EmptyEvent();
        assertEquals("Empty", event.getName());
        assertEquals(0, event.getTime());
        assertEquals(true,event.isEmptyEvent());
    }
    
    @Test
    public void sheduleTest(){
        Shedule shed = new Shedule();
        Event event = new Event("Нытва", "автобус до Нытвы", "17-00",1);
        shed.addEvent(event);
        event = new Event("Майский", "автобус до Майского", "17-10",1);
        shed.addEvent(event);
        event = new Event("Оса", "автобус до Осы", "12-00",1);
        shed.addEvent(event);
        event = new Event("Чернушка", "автобус до Чернушки", "13-30",1);
        shed.addEvent(event);
        event = new Event("Краснокамск", "автобус до Краснокамска", "17-00",1);
        shed.addEvent(event);
        shed.sortEventsByTime();
        assertEquals(1710,shed.getLastElement().getTime());
        assertEquals(1200,shed.getFirstElement().getTime());
    } 
    
    @Test
    public void testEventsByTime(){
        Shedule shed = new Shedule();
        Event event = new Event("Нытва", "Нытвы", "11-15",13);
        shed.addEvent(event);
        event = new Event("Майский", "Майского", "11-20", 10);
        shed.addEvent(event);      
        assertEquals(false, shed.checkShedule(1110).isEmptyEvent());
        assertEquals(false, shed.checkShedule(1115).isEmptyEvent());
        assertEquals(true, shed.checkShedule(1120).isEmptyEvent());
    }
    
    @Test
    public void testTimeBefore(){
        Event event = new Event("Нытва", "Нытвы", "11-15",13);
        assertEquals(1110, event.getTimeSomeMinutesBefore(5));
        assertEquals(1112, event.getTimeSomeMinutesBefore(3));
        assertEquals(1100, event.getTimeSomeMinutesBefore(15));
        event = new Event("Нытва", "Нытвы", "12-00",13);
        assertEquals(1155, event.getTimeSomeMinutesBefore(5));
    }
    
    
    
}
