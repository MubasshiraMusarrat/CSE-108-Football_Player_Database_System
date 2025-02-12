package PlayerProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class searchPlayer {
    public player searchByName(List<player> playerList, String name) throws Exception {
        boolean searchIndex = false;
        player t=new player();
        for(player p : playerList){
            if(p.getName().equalsIgnoreCase(name))
            {
                searchIndex=true;
                t=p;
            }
        }
        if(!searchIndex)
            return null;
        else
            return t;

    }

   public List<player> searchByClubAndCountry(List<player> playerList, String country) throws Exception {
        boolean searchIndex=false;
       List<player>list=new ArrayList<>();
        for(player p : playerList) {
            if (p.getCountry().equalsIgnoreCase(country)) {
                searchIndex=true;
                list.add(p);
                }
            }
        if(!searchIndex)
            return null;
        else
                return list;
    }

    public List<player> searchBySalary(List<player> playerList, double lowerRange, double upperRange) throws Exception {
        boolean searchIndex=false;
        List<player>list=new ArrayList<>();
        for(player p : playerList){
            if(p.getWeeklySalary()<=upperRange && p.getWeeklySalary()>=lowerRange){
                searchIndex=true;
                list.add(p);
            }
        }
        if(!searchIndex)
            return null;
        else
            return list;
    }

    public List<player> searchByPosition(List<player> playerList, String position) throws Exception
    {
        boolean searchIndex= false;
        List<player>list=new ArrayList<>();
        for(player p : playerList){
            if(p.getPosition().equalsIgnoreCase(position)){
                searchIndex=true;
                list.add(p);
            }
        }
        if(!searchIndex)
            return null;
        else
            return list;
    }

    public int Count(List<player> playerList, String country) throws Exception {
        boolean searchIndex=false;
        int count=0;
        for (player p: playerList)
        {
            if(p.getCountry().equalsIgnoreCase(country))
            {
                searchIndex=true;
                count++;
            }
        }
        if(!searchIndex)
            return 0;
        else
            return count;
    }
}
