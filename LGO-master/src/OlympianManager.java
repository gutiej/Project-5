//..Joe Gutierrez
//..Project 5
//..12/11/2014


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class OlympianManager {

    private BufferedReader file;
    private ArrayList<Olympian> olympians = new ArrayList<Olympian>();
    private ArrayNode olympianLinkedList = new ArrayNode();


    OlympianManager(BufferedReader file){
        this.file = file;
        loadOlympians();
    }//..load olympians into the buffered reader

    public void loadOlympians(){
        String line;
        try {
            while ( (line = file.readLine()) != null){
                if(!line.equals("LGOO")) {

                    String[] parse = line.split(",");
                    String name = parse[0];
                    Sex sex;
                    int age = Integer.parseInt(parse[2]);

                    if(parse[1].equals("M")) {
                        sex = Sex.MALE;
                    }else{
                        sex = Sex.FEMALE;
                    }

                    olympians.add(new Olympian(name, sex, age));
                    olympianLinkedList.add(new Olympian(name, sex, age));
                }
            }//.. pulling info from my lgoo file and making an olympian based on the three criteria.....NAME,SEX,AGE

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showOlympians(){
        System.out.println("\n Olympians ");

        for(Olympian o : olympians){
            System.out.println(o.name+", "+o.sex+", "+o.age);
        }

    }//..

    public ArrayList<Olympian> getOlympians(){
        return olympians;
    }//..

    public ArrayNode getOlympianLinkedList(){
        return  olympianLinkedList;
    }//..

}//.. end OlympianManager