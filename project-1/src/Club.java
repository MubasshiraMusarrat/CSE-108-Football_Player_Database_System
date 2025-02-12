import java.util.ArrayList;
import java.util.List;

public class Club {
    public List<player> Players = new ArrayList();
    String club;

    public void setClub(String club){
        this.club=club;
    }

    public String getClub() {
        return club;
    }

    public double getMaxSalary(){
        double MaxS = 0;
        for(player p : Players)
            if(MaxS < p.getWeeklySalary())
                MaxS=p.getWeeklySalary();

        return MaxS;
    }

    public double getMaxAge(){
        double MaxA = 0;
        for(player p : Players)
            if(MaxA< p.getAge())
                MaxA=p.getAge();

        return MaxA;
    }

    public double getMaxHeight(){
        double MaxH = 0;
        for(player p : Players)
            if(MaxH< p.getHeight())
                MaxH=p.getHeight();

        return MaxH;
    }

    public static List<Club> ClubList (List<player>playerList){
        List<Club>clubList = new ArrayList();

        for(player p : playerList){
            boolean searchIndex=false;
            for(Club c : clubList){
                if(c.club.equalsIgnoreCase(p.getClub())){
                    searchIndex=true;
                    c.Players.add(p);
                }
            }
            if(!searchIndex){
                Club c= new Club();
                c.setClub(p.getClub());
                c.Players.add(p);
                clubList.add(c);
            }
        }
        return clubList;
    }
}
