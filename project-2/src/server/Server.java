package server;

import PlayerProperties.Club;
import PlayerProperties.player;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String,Integer>userMap;
    private List<Club> ClubList= new ArrayList<>();
    public List<player> sellPlayerlist=new ArrayList<>();

    Server() {
        try {
            ClubList=Club.getClubList(FileOperations.readFromFile("players.txt"));
            sellPlayerlist=FileOperations.readFromFile("Sell_Players.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        userMap=new HashMap<>();
        userMap.put("Manchester United", 1905088);
        userMap.put("Manchester City", 1905088);
        userMap.put("Chelsea", 1905088);
        userMap.put("Liverpool", 1905088);
        userMap.put("Arsenal", 1905088);
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
        finally {
            try {
                FileOperations.writeToFile(sellPlayerlist,"Sell_Players.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            for(Club C: ClubList) {
                try {
                    FileOperations.writeToFile(C.Players, "players.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap, networkUtil, ClubList, sellPlayerlist);
    }

    public static void main(String[] args) {
        new Server();
    }
}
