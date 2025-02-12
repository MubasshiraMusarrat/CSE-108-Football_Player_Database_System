package PlayerProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchClub {
    public List<player> maxSalary(List<player> playerList) throws Exception {
        List<player>list=new ArrayList<>();
                player pMax = new player();
                pMax = playerList.get(0);
                for (player p : playerList){
                    if (pMax.getWeeklySalary() < p.getWeeklySalary())
                        pMax = p;
                }
        for (player p : playerList){
            if (p.getWeeklySalary() == pMax.getWeeklySalary())
                list.add(p);
        }
                return list;
            }

    public List<player> maxAge(List<player>playerList) throws Exception {
        List<player>list=new ArrayList<>();
                player pMax= new player();
                pMax = playerList.get(0);
                for (player p : playerList) {
                    if (pMax.getAge() < p.getAge())
                        pMax = p;
                }
        for (player p : playerList){
            if (p.getAge() == pMax.getAge())
                list.add(p);
        }
        return list;
    }

    public List<player> maxHeight(List<player>playerList) throws Exception {
        List<player>list=new ArrayList<>();
                player pMax= new player();
                pMax = playerList.get(0);
                for (player p : playerList) {
                    if (pMax.getHeight() < p.getHeight())
                        pMax = p;
                }
        for (player p : playerList) {
            if (p.getHeight() == pMax.getHeight())
                list.add(p);
        }
                    return list;
        }

    public double totalSalary(List<player>playerList) throws Exception {
        double totalSalary = 0.0;
                for (player p : playerList)
                    totalSalary += p.getWeeklySalary();
                return totalSalary;
        }
}
