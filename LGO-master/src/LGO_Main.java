//..Joe Gutierrez
//..Project 5
//..12/1


import java.io.*;
import java.util.ArrayList;

public class LGO_Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader file;
    static String fileLocation;
    static String command;


    static OlympianManager olympianManager;

    static TeamManager teamManager;

    static EventManager eventManager;

    static CompetitionManager competitionManager;

    public static void showHelp(){

        System.out.println("******* Lawn Game Olympics Help *********\n*");
        System.out.println("* ARGUMENTS            -- DETAILS\n*");
        System.out.println("* help, h              -- Displays this help message");
        System.out.println("* events, e            -- List of the day\'s events");
        System.out.println("* olympians, o         -- List of the day\'s olympians");
        System.out.println("* teams, t             -- List of the day\'s teams as well as their record");
        System.out.println("* competitions, c      -- List of the currently running competitions");
//..    System.out.println("* startcompetition, sc -- Start a new competition");   //.....Don't need this anymore
        System.out.println("* endcompetition, ec   -- Ends a currently running competition");
        System.out.println("* quit, q              -- Exits the program");
        System.out.println("*\n****************************************");

    }
    //..Full help menu for the user to navigate thru the game.
    //..I think this final version looks more appealing to the eye
    //..

    public static void processCommand() throws IOException{
        command = in.readLine();
        command.toLowerCase();
     //..this toLowerCase helps to assist the user in entering the correct commands.
     //..the user is able to enter the command in any fashion without regard to case sensitivity


        if(command.equals("help") || command.equals("h")){
            showHelp();
        }else if(command.equals("quit") || command.equals("q")){
            System.exit(0);
        }else if(command.equals("olympians") || command.equals("o")){
            showOlympians();
        }else if(command.equals("events") || command.equals("e")){
            showEvents();
        }else if(command.equals("queue") || command.equals("t")){
            showTeams();
        }else if(command.equals("competitions") || command.equals("c")){
            showCompetitions();
        }else if(command.equals("endcompetition") || command.equals("ec")){
            endCompetition();
        }else{
            showHelp();
        }
    }
    //..if/else loop to handle the inputs from the user
    //..handles two different inputs from the user, both the full name command and the first letter of the command



    public static void showOlympians(){
        olympianManager.showOlympians();
    }//...display method for the olympianManager

    public static void showTeams(){
        teamManager.showTeams();
    }//..display method for the teamManager

    public static void showEvents() { eventManager.showEvents(); }//..display method for the eventManager

    public static void showCompetitions(){ competitionManager.showCompetitions(); }//..display method for the showCompetitions

//..public static void startCompetition(){ competitionManager.initiateStartCompetition(); }//..don't need this anymore

    public static void endCompetition(){ competitionManager.initiateEndCompetition(); }//..initiates the end of a competition

    public static void main(String[] args) {
        if (args.length < 1) {  //.. handles non-existent arguments
            System.out.println("You must enter an .lgoo file location");    //..in the command line.....don't forget to load in this file
            System.exit(1);                                                 //..otherwise it won't know how to form the teams
        }else {
            try{

                System.out.println("******* Lawn Game Olympics Help ********\n");

                fileLocation = args[0];
                file = new BufferedReader(new FileReader(new File(fileLocation)));


                olympianManager = new OlympianManager(file);

                teamManager = new TeamManager(olympianManager.getOlympians());

                eventManager = new EventManager(teamManager.getTeams());

                competitionManager = new CompetitionManager(teamManager.getTeams());


                while(true) {
                    System.out.print("\nEnter Command: ");
                    processCommand();
                }

            }catch (FileNotFoundException fnfe){//.. handles invalid arguments
                fnfe.printStackTrace();
                System.out.println("Cannot locate file at location "+fileLocation);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Error: internal errors");
            }
        }
    }


}//.. end Class LGO_Main
