//..Joe Gutierrez
//..Project 5
//..12/11/2014


import java.util.ArrayList;

public class LadderBallEvent extends Event {

    int numRungs;

//..    LadderBallEvent() { name = "LadderBall"; } //..don't need

    LadderBallEvent(ArrayList<Team> teams){this.queue = teams; name = "LadderBall"; }
    //..adding events to the array list to help with the que/deque

    public String getExtraInfo() {
        return null;
    }


}//.. end LadderBallEvent
