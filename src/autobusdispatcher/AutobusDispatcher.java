package autobusdispatcher;

import autobusdispatcher.speakers.TemporarySpeaker;

public class AutobusDispatcher {

    public static void main(String[] args) {
        Shedule shed = new Shedule();
        Event event = new Event("Нытва", "Нытвы", "11-15",13);
        shed.addEvent(event);
        event = new Event("Майский", "Майского", "11-35", 10);
        shed.addEvent(event);
        event = new Event("Оса", "Осы", "12-00", 2);
        shed.addEvent(event);
        event = new Event("Чернушка", "Чернушки", "12-10", 2);
        shed.addEvent(event);
        event = new Event("Краснокамск", "Краснокамска", "11-55",1);
        shed.addEvent(event);
        Dispathcher disp = new Dispathcher(new TemporarySpeaker(),shed);
        disp.checkShedule();
    }
    
}
