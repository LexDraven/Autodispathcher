package autobusdispatcher.events;


public class Event {
    private String name;
    private String message;
    private String time;
    private int platform;
    private int hour,min;

    public int getPlatform() {
        return platform;
    }    

    public Event(String name, String message, String time, int platform) {
        this.name = name;        
        this. platform = platform;
        setTime(time);
        message = "На площадке номер "+platform+" начинается посадка до "+message+". Время отправления: "+time;
        this.message = message;
    }
    
    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getTime() {
        String hour1 = Integer.toString(hour);
        if (hour1.length()==1) {
            hour1 = "0"+hour;
        }
        String min1 = Integer.toString(min);
        if (min1.length()==1) {
            min1 = "0"+min1;
        }
        return Integer.parseInt(hour1+min1);
    }

    public void setTime(String time) {
        String [] tokens = time.split("-");
        hour = Integer.parseInt(tokens[0]);
        min = Integer.parseInt(tokens[1]);
        if (hour>23 || hour<0) {
            hour=0;
        }
        if (min>59 || min<0) {
            min=0;
        }
        this.time=time;
    }
    
    public int getTimeSomeMinutesBefore(int minutes){
        int hourResult = hour;
        int minResult = min-minutes;
        if (minResult<0) {
            hourResult = hourResult-1;
            if (hourResult<0) {
                hourResult = 23;
            }
            minResult = 60+minResult;
        }
        String hour = Integer.toString(hourResult);
        if (hour.length()==1) {
            hour = "0"+hour;
        }
        String min = Integer.toString(minResult);
        if (min.length()==1) {
            min = "0"+min;
        }
        return Integer.parseInt(hour+min);
    }
    
    public boolean isEmptyEvent(){
        return false;
    }
    
    
    
    
    

}
