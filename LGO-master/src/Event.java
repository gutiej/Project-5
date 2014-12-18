//..Joe Gutierrez
//..Project 5
//..12/11/2014



import java.util.ArrayList;

abstract class Event{

    protected ArrayList<Team> queue = new ArrayList<Team>();
    protected ArrayList<Team> stack = new ArrayList<Team>();

    String name;
    int playTo;
    boolean isPlayToExact;
    int playDistance;

    public abstract String getExtraInfo();

    public void BracketQueue(Team winningTeam, Team losingTeam){
        queue.add(winningTeam);//..winning team gets to be enqued back to the que
        stack.add(0,losingTeam);
    }//..losing team needs to go back on the stack

    public Team[] PeakNextTeams(){
        if(queue.size()>1) {
            Team[] t = new Team[]{queue.get(0), queue.get(1)};
            return t;
        }
        return null;
    }//..peak and see if there are any teams avail....que them up


    public Team[] GetNextTeams(){
        if(queue.size()>1) {
            Team t1 = queue.get(0),
                    t2 = queue.get(1);
            queue.remove(t1);
            queue.remove(t2);

            Team t[] = new Team[]{t1, t2};
            return t;
        }
        return null;
    }//..


}//.. end Event
