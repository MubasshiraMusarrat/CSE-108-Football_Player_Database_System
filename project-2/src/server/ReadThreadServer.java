package server;

import PlayerProperties.Club;
import PlayerProperties.player;
import util.ListOfPlayer;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    private HashMap<String, Integer> userMap;
    private List<Club>clubList=new ArrayList<>();
    private List<player>sellingPlayerList=new ArrayList<>();
    String name=null;


    public ReadThreadServer(HashMap<String, Integer> map, NetworkUtil networkUtil,List<Club>clubList, List<player>sellplayerList) {
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.clubList = clubList;
        this.sellingPlayerList=sellplayerList;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof String) {
                        String s = (String) o;
                        if (s.equals("player_list")) {
                                for (Club c : clubList) {
                                    if (name != null && c.getClub().equals(name)) {
                                        ListOfPlayer obj = new ListOfPlayer(c.Players);
                                        try {
                                            networkUtil.write(obj);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                        } else if (s.equals("BuyPlayerList")) {
                                List<player> localList = new ArrayList<>();
                                for (player p : sellingPlayerList) {
                                    if (p.getClub().equalsIgnoreCase(name)) ;
                                    else
                                        localList.add(p);
                                }
                                ListOfPlayer obj = new ListOfPlayer(localList);
                                try {
                                    networkUtil.write(obj);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        }
                    }else if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        Integer password = userMap.get(loginDTO.getClubName());
                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
                        name = loginDTO.getClubName();
                        networkUtil.write(loginDTO);
                    } else if (o instanceof player) {
                        player p = (player) o;
                        if(p.getClub().equalsIgnoreCase(name)){
                            boolean searchIndex = false;
                            for (player s : sellingPlayerList) {
                                if (p.getName().equalsIgnoreCase(s.getName()))
                                    searchIndex = true;
                            }
                            if (!searchIndex)
                                sellingPlayerList.add(p);
                        }
                        else{
                            for(int i=0; i<sellingPlayerList.size();i++){
                                if(sellingPlayerList.get(i).getName().equalsIgnoreCase(p.getName()))
                                    sellingPlayerList.remove(i);
                                break;
                            }
                            for (Club c: clubList){
                                if(p.getClub().equalsIgnoreCase(c.getClub())) {
                                    for (int i=0; i<c.Players.size();i++){
                                        if(p.getName().equalsIgnoreCase(c.Players.get(i).getName()))
                                            c.Players.remove(i);
                                    }
                                }
                            }
                            p.setClub(name);
                            for (Club c: clubList){
                                if (name != null && c.getClub().equals(name)){
                                    c.Players.add(p);
                                }
                            }
                        }
                    }
                 }
            }
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



