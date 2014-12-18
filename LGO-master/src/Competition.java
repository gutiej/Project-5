//..Joe Gutierrez
//..Project 5
//..12/11/2014


public class Competition implements ICompetition {

    Event event;
    Team team1,team2;

    @Override
    public void start(Event event, Team team1, Team team2) {
        this.event=event;
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public Event getEvent() {
        return event;
    }//..pick one event

    @Override
    public Team getTeam1() {
        return team1;
    }//..pick one team

    @Override
    public Team getTeam2() {
        return team2;
    }//..pick one team


}//.. end Class Competition
