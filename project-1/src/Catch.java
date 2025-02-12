import java.util.List;
import java.util.Scanner;

public class Catch {
    public static boolean catchName(String name, List<player> playerList) {
        boolean searchIndex=false ;

        for(player p : playerList) {
            if(p.getName().equalsIgnoreCase(name)) {
                searchIndex=true ;
                System.out.println("Sorry! " + name + " is already in database! Try giving another name.");
                break;
            }
        }
        if(searchIndex)
            return false;
        else
            return true ;
    }

    public static int catchClub(String Name, List<Club> clubList) {
        int result = 0;
        for(Club c: clubList){
            if(c.getClub().equalsIgnoreCase(Name)) {
                if(c.Players.size() >= 7) {
                    System.out.println("Max player reached.");
                    result = 2 ;
                }
                else
                    result = 1 ;
            }
        }
        return result;
    }

    public static boolean catchNumber(int Number, String club, List<player> playerList) {
        boolean searchIndex = false ;

        for(player p : playerList) {
            if(p.getNumber() == Number && p.getClub().equalsIgnoreCase(club)) {
                searchIndex= true ;
                System.out.println("Sorry! The number " + Number + " is already in " + club+ "! Try giving another number.");
                break ;
            }
        }
        if(searchIndex)
            return false ;
        else
            return true ;
    }

    public static boolean catchPosition(String position){

        boolean searchIndex=false;
        if(position.equalsIgnoreCase("Goalkeeper")){
            searchIndex = true ; }
        else if(position.equalsIgnoreCase("Forward")){
            searchIndex = true ;
        }
        else if(position.equalsIgnoreCase("Midfielder")){
            searchIndex = true ;
        }
        else if(position.equalsIgnoreCase("Defender")){
            searchIndex = true ;
        }
        else{
            System.out.println("Invalid Position name.");
            System.out.println();
            searchIndex= false ;
        }
        return searchIndex;
    }

}
