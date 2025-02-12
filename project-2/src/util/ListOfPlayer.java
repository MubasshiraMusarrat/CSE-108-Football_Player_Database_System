package util;

import PlayerProperties.player;

import java.io.Serializable;
import java.util.List;

public class ListOfPlayer implements Serializable {
    private List<player>playerList;
    public ListOfPlayer(List<player>playerList){
        this.playerList = playerList;
    }
    public List<player> getPlayerList(){return playerList;}
    public void setPlayerList(List<player> playerList)
    {
        this.playerList=playerList;
    }
}
