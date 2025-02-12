package server;

import PlayerProperties.player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public static List<player> readFromFile(String INPUT_FILE_NAME) throws Exception {
        List<player> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            player p = new player(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), tokens[4], tokens[5], Integer.parseInt(tokens[6]), Double.parseDouble(tokens[7]));
            if(tokens.length==9) {
                p.setPrice(Double.parseDouble(tokens[8]));
            }
            PlayerList.add(p);
        }
        br.close();
        return PlayerList;
    }

    public static void writeToFile(List<player> playerList, String OUTPUT_FILE_NAME) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (player p : playerList) {
            bw.write(String.valueOf(p));
            bw.write("\n");
        }
        bw.close();
    }
}