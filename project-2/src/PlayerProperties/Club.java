package PlayerProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable {
    public List<player> Players = new ArrayList();
    String club;

    public void setClub(String club){
        this.club=club;
    }

    public String getClub() {
        return club;
    }

    public static List<Club> getClubList (List<player>playerList){
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
