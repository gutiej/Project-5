//..Joe Gutierrez
//..Project 5
//..12/11/2014



import java.util.ArrayList;

public class HorseShoesEvent extends Event{

    int numHorseShoes;

//..   HorseShoesEvent(){ name = "HorseShoes"; } //..don't need

    HorseShoesEvent(ArrayList<Team> teams){this.queue = teams; name = "HorseShoes";
    }
    //..adding events to the array list to help with the que/deque

    public String getExtraInfo(){
        return null;
    }


}//.. end HorseShoesEvent