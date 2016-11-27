package autobusdispatcher;

import autobusdispatcher.speakers.TemporarySpeaker;

public class AutobusDispatcher {

    public static void main(String[] args) {
        Shedule shed = new Shedule();
        Event event = new Event("Нытва", "Нытвы", 1115,13);
        shed.addEvent(event);
        event = new Event("Майский", "Майского", 1135, 10);
        shed.addEvent(event);
        event = new Event("Оса", "Осы", 1200, 2);
        shed.addEvent(event);
        event = new Event("Чернушка", "Чернушки", 1210, 2);
        shed.addEvent(event);
        event = new Event("Краснокамск", "Краснокамска", 1155,1);
        shed.addEvent(event);
        Dispathcher disp = new Dispathcher(new TemporarySpeaker(),shed);
        disp.checkShedule();  


    }
    
}
