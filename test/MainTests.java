
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
        Event event = new Event("name", "message", 2357,1);
        assertEquals("name", event.getName());
        assertEquals(0, event.getTime());
        event = new Event("name1", "message1", 2355,1);
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
        Event event = new Event("Нытва", "автобус до Нытвы", 1700,1);
        shed.addEvent(event);
        event = new Event("Майский", "автобус до Майского", 1710,1);
        shed.addEvent(event);
        event = new Event("Оса", "автобус до Осы", 1200,1);
        shed.addEvent(event);
        event = new Event("Чернушка", "автобус до Чернушки", 1330,1);
        shed.addEvent(event);
        event = new Event("Краснокамск", "автобус до Краснокамска", 1700,1);
        shed.addEvent(event);
        shed.sortEventsByTime();
        assertEquals(1710,shed.getLastElement().getTime());
        assertEquals(1200,shed.getFirstElement().getTime());
    } 
    
    @Test
    public void testEventsByTime(){
        Shedule shed = new Shedule();
        Event event = new Event("Нытва", "Нытвы", 1115,13);
        shed.addEvent(event);
        event = new Event("Майский", "Майского", 1120, 10);
        shed.addEvent(event);      
        assertEquals(false, shed.checkShedule(1110).isEmptyEvent());
        assertEquals(false, shed.checkShedule(1115).isEmptyEvent());
        assertEquals(true, shed.checkShedule(1120).isEmptyEvent());
    }
    
    
    
}
