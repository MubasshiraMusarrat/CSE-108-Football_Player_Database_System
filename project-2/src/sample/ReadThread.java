package sample;

import PlayerProperties.player;
import javafx.application.Platform;
import util.ListOfPlayer;
import util.LoginDTO;

import java.io.IOException;
import java.util.List;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;
    private List<player> playerList;
    private List<player>sellPlayerList;
    LoginDTO loginDTO=null;
    String clubname;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof ListOfPlayer) {
                        ListOfPlayer obj = (ListOfPlayer) o;
                        if(obj.getPlayerList().get(0).getClub().equalsIgnoreCase(loginDTO.getClubName())) {
                            playerList = obj.getPlayerList();
                            main.setPlayerList(playerList);
                            if(!main.isImp){
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (loginDTO.isStatus()) {
                                            try {
                                                main.showMenuPage(loginDTO.getClubName());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            main.showAlert();
                                        }
                                    }
                                });
                            }
                        }
                        else{
                            sellPlayerList=obj.getPlayerList();
                            if(sellPlayerList.size()!=0){
                                main.setSellPlayerList(sellPlayerList);
                                if(!main.isImp){
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (loginDTO.isStatus()) {
                                                try {
                                                    main.showBuyPlayerPage(clubname);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                main.showAlert();
                                            }
                                        }
                                    });
                                }
                            }
                        }

                    } else if (o instanceof LoginDTO) {
                        loginDTO = (LoginDTO) o;
                        System.out.println(loginDTO.isStatus());
                        if (loginDTO.isStatus()) {
                            System.out.println(loginDTO.getClubName() + " Login Successful.");
                            clubname=loginDTO.getClubName();
                            main.getNetworkUtil().write("player_list");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



