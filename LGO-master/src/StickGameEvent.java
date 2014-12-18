//..Joe Gutierrez
//..Project 5
//..12/11/2014




import java.util.ArrayList;

public class StickGameEvent extends Event{

    int frisbeeSize;

//..    StickGameEvent() { name = "StickGame"; }    //..don't need

    StickGameEvent(ArrayList<Team> teams){this.queue = teams; name = "StickGame"; }

    //..adding events to the array list to help with the que/deque

    public String getExtraInfo() {
        return null;
    }

}//.. end StickGameEvent
