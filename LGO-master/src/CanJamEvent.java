//..Joe Gutierrez
//..Project 5
//..12/11/2014


import java.util.ArrayList;

public class CanJamEvent extends Event{

//..    CanJamEvent(){ name = "CanJam"; };  //..don't need

    CanJamEvent(ArrayList<Team> teams){this.queue = teams;
        name = "CanJam";
    };  //..adding events to the array list to help with the que/deque

    public String getExtraInfo(){
        return "";
    };


}//.. end CanJamEvent