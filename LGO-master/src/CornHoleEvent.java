//..Joe Gutierrez
//..Project 5
//..12/11/2014


import java.util.ArrayList;

public class CornHoleEvent extends Event{

    int numBeanBags;

   //.. CornHoleEvent(){ name = "CornHole"; } //..don't need

    CornHoleEvent(ArrayList<Team> teams){this.queue = teams;name = "CornHole";
    }
    //..adding events to the array list to help with the que/deque

    public String getExtraInfo(){
        return null;
    }


}//.. end CornHoleEvent