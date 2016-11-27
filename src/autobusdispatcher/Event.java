package autobusdispatcher;


public class Event {
    private String name;
    private String message;
    private int time;
    private int platform;

    public int getPlatform() {
        return platform;
    }    

    public Event(String name, String message, int time, int platform) {
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
        return time;
    }

    public void setTime(int time) {
        if (time>2355) {
            time=0;
        }
        this.time=time;
    }
    
    public boolean isEmptyEvent(){
        return false;
    }
    
    
    
    
    

}
