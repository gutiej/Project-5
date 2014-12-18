//..Joe Gutierrez
//..Project 5
//..12/11/2014


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CompetitionManager {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private  ArrayList<Team> teams = new ArrayList<Team>(); //..takes and handles the team inputs from the events
//..    private  ArrayList<Team> availableTeams = new ArrayList<Team>();    //..not sure about this yet
//..    private ArrayList<Event> availableEvents = new ArrayList<Event>(); //..ditto



    protected ArrayList<Competition> competitions = new ArrayList<Competition>();

    CompetitionManager(ArrayList<Team> teams) {
        this.teams=teams;
        startRandomCompetitions();
    }//..start Randomizer

    public void showCompetitions(){
//..method to show all current competitions
        System.out.println("\n Showing Competitions \n");

        for (Competition c: competitions){
//..iterates through all the competitions

            System.out.println("\nEvent: "+c.event.name+
                               "\n\n    Team A: "+c.team1.olympian1.name+
                               "\n            "+c.team1.olympian2.name+
                               "\n\n    Team B: "+c.team2.olympian1.name+
                               "\n            "+c.team2.olympian2.name);
        }

        if(competitions.size() == 0){
            boolean allEventsComplete = true;
            System.out.println("          All Events have been completed!\n    Enter \'e\' command to view the team standings.");
//..you will get this ONLY when ALL events have been completed
        }

    }
//..****************************************************************************************

/*    public void initiateStartCompetition(){
        System.out.println("\n******* Start New Competition *******\n");
        Event event;
        Team team1, team2;

        if( (event = chooseEvent()) == null){
            cancel();
            availableEvents.add(event);
            return;
        }

        if((team1 = chooseTeam(1))==null){
            cancel();
            availableTeams.add(team1);
            return;
        }

        if((team2 = chooseTeam(2))==null){
            cancel();
            availableTeams.add(team2);
            return;
        }

        System.out.println("\nStarting competition: " +
                "\nEvent - " + event.name +
                "\nTeam1 - " + team1.olympian1.name + ", " + team1.olympian2.name +
                "\nTeam2 - "+team2.olympian1.name+", "+team2.olympian2.name);

        startCompetition(event,team1,team2);

    */

    //..****************************************************************************************
    public void startCompetition(Event event,Team team1,Team team2){
        Competition competition = new Competition();
        competition.start(event, team1, team2);
        competitions.add(competition);
    }

    protected Event getRandomAvailableEvent(){
        Event event = LGO_Main.eventManager.getEvents().get((int)(Math.random()*LGO_Main.eventManager.getEvents().size()));
        for (Competition c :competitions){
            if(c.event.name.equals(event.name)){
                return getRandomAvailableEvent();
            }
            //..bonus??? get events at random based on the math.random function
            //..searches for events that are not being played
           //..matches them into a random competition
        }
        return event;
    }



 //..************************************************************************************************

/*   private Event chooseEvent(){
     System.out.print("Enter Event: ");

     String choice=getChoice();

     if (choice.toLowerCase().equals("q"))
         return null;

     for (Event e: availableEvents){
         if(choice.toLowerCase().equals(e.name.toLowerCase())){
             availableEvents.remove(e);
             return e;
         }
     }

     System.out.println("\nEither "+choice + " is not a LGO event \n"+
             "Or teams are already competing in this event");
     return chooseEvent();
 */





 //..************************************************************************************************
    public void initiateEndCompetition(){
        boolean ended=false;
        System.out.print("Enter Competition that you want to end: ");

        String eventName=getChoice();
        if(eventName.toLowerCase().equals("q")){
            return;
        }

        String teamMem;

        for (Competition c:competitions){
            if(eventName.toLowerCase().equals(c.event.name.toLowerCase())){
                System.out.print("Enter a name of an olympian from the winning team: ");
                teamMem=getChoice();
                if(teamMem.toLowerCase().equals(c.team1.olympian1.name.toLowerCase()) || teamMem.toLowerCase().equals(c.team1.olympian2.name.toLowerCase()) ){
                    endCompetition(c,c.team1);//.. when ending the competitions.....enter name of either olympian on this team...this marks their team as the winner
                    ended=true;
                    break;
                }else if(teamMem.toLowerCase().equals(c.team2.olympian1.name.toLowerCase()) || teamMem.toLowerCase().equals(c.team2.olympian2.name.toLowerCase()) ){
                    endCompetition(c,c.team2);//.. when ending the competitions.....enter name of either olympian on this team...this marks their team as the winner
                    ended=true;
                    break;
                }else {
                    System.out.println( eventName+" was not competing in this round of " + c.event.name);
                }//..if you enter the name of someone not in this event....you will get this message
            }
        }
        if(!ended) {
            System.out.println("No teams are currently competing in a " + eventName + " competition");
            initiateEndCompetition();//..if you enter the wrong event name in the end competition
        }
    }

    public void endCompetition(Competition competition,Team winningTeam){
        Team losingTeam;

        if(competition.team1 != winningTeam){
            losingTeam=competition.team1;
        }else {
            losingTeam=competition.team2;
        }

        for (Team t:teams){//.. increment the team wins by 1
            if(t==winningTeam){
                t.wins++;
            }
            if(t==losingTeam){//.. increment the teams losses by 1
                t.losses++;
            }
        }
//..        availableTeams.add(competition.team1);
//..        availableTeams.add(competition.team2);
//..        availableEvents.add(competition.event);
//..        competitions.remove(competition);
//..    }

        competition.event.BracketQueue(winningTeam, losingTeam);
        competitions.remove(competition);
        startRandomCompetitions();
    }//..uses info from the randomizer and deques 2 teams......i want this to deque 2 teams and then ultimately enque the winning team back to the que
    //.. the losing team needs to be sent to the stack

    protected void startRandomCompetitions(){
        for (Event e : LGO_Main.eventManager.getEvents()){
            boolean canStartComp = true;
            Team[] nextTeams = e.PeakNextTeams();
            if(nextTeams != null) {
                for (Competition c : competitions) {
                    if (c.event.name.equals(e.name)) {
                        canStartComp = false;
                    }
                    if (canStartComp) {
                        String cT1 = c.team1.olympian1.name,
                                cT2 = c.team2.olympian1.name;
                        if (cT1.equals(nextTeams[0].olympian1.name) || cT1.equals(nextTeams[1].olympian1.name)) {
                            canStartComp = false;
                        }
                        if (cT2.equals(nextTeams[0].olympian1.name) || cT2.equals(nextTeams[1].olympian1.name)) {
                            canStartComp = false;
                        }
                    }
                }
                if (canStartComp) {
                    System.out.println("\n Starting New Competition \n");
                    System.out.println("Event: " + e.name + "\n" +
                            "\n Team A: " + nextTeams[0].olympian1.name + "\n" +
                            "         " + nextTeams[0].olympian2.name + "\n" +
                            "\n Team B: " + nextTeams[1].olympian1.name + "\n" +
                            "         " + nextTeams[1].olympian2.name + "\n");
                    nextTeams = e.GetNextTeams();
                    startCompetition(e, nextTeams[0], nextTeams[1]);
                }
            }
        }
    }

    protected String getChoice(){
        String choice = "";
        try{
            choice = in.readLine();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return choice;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }//..getter

}//.. end Class CompetitionManager
