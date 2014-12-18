//..Joe Gutierrez
//..Project 5
//..12/11/2014


import java.util.ArrayList;

public class WashoosEvent extends Event{

    boolean hasAutoWinStick;
    int numWashoos;

//..    WashoosEvent(){ name = "Washoos"; };    //..don't need

    WashoosEvent(ArrayList<Team> teams){this.queue = teams; name = "Washoos";
    };
    //..adding events to the array list to help with the que/deque
    public String getExtraInfo(){
        return "";
    };

}//.. end Washoos