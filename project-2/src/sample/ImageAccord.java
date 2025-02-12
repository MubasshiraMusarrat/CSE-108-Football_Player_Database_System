package sample;

import PlayerProperties.player;

import java.util.List;

public class ImageAccord {
    public static List<player> accord(List<player> playerList) {
        player p;
        for (int i = 0; i < playerList.size(); i++) {
            p = new player();
            p = playerList.get(i);
            String s = p.getName();
            if (s.equalsIgnoreCase("David de Gea"))
                p.setImgSrc("/playerImage/david.jpg");
            else if (s.equalsIgnoreCase("Harry Maguire"))
                p.setImgSrc("/playerImage/harry.PNG");
            else if (s.equalsIgnoreCase("Paul Pogba"))
                p.setImgSrc("/playerImage/pogba.PNG");
            else if (s.equalsIgnoreCase("Bruno Fernandes"))
                p.setImgSrc("/playerImage/bruno.PNG");
            else if (s.equalsIgnoreCase("Edinson Cavani"))
                p.setImgSrc("/playerImage/cavani.jpg");
            else if (s.equalsIgnoreCase("Ederson"))
                p.setImgSrc("/playerImage/enderson.jpg");
            else if (s.equalsIgnoreCase("Ruben Dias"))
                p.setImgSrc("/playerImage/ruben dias.PNG");
            else if (s.equalsIgnoreCase("Kevin De Bruyne"))
                p.setImgSrc("/playerImage/de brunye.jpg");
            else if (s.equalsIgnoreCase("Ilkay Gundogan"))
                p.setImgSrc("/playerImage/ilkay.PNG");
            else if (s.equalsIgnoreCase("Raheem Sterling"))
                p.setImgSrc("/playerImage/sterling.jpg");
            else if (s.equalsIgnoreCase("Edouard Mendy"))
                p.setImgSrc("/playerImage/mundy.PNG");
            else if (s.equalsIgnoreCase("Cesar Azpilicueta"))
                p.setImgSrc("/playerImage/Caezer.PNG");
            else if (s.equalsIgnoreCase("N'Golo Kante"))
                p.setImgSrc("/playerImage/n'golo.jpg");
            else if (s.equalsIgnoreCase("Jorginho"))
                p.setImgSrc("/playerImage/joringho.PNG");
            else if (s.equalsIgnoreCase("Timo Werner"))
                p.setImgSrc("/playerImage/timo.PNG");
            else if (s.equalsIgnoreCase("Alisson"))
                p.setImgSrc("/playerImage/allison.jpg");
            else if (s.equalsIgnoreCase("Virgil van Dijk"))
                p.setImgSrc("/playerImage/virgil.jpg");
            else if (s.equalsIgnoreCase("Jordan Henderson"))
                p.setImgSrc("/playerImage/henderson.png");
            else if (s.equalsIgnoreCase("Thiago Alcantaram"))
                p.setImgSrc("/playerImage/thiago.jpg");
            else if (s.equalsIgnoreCase("Mohamed Salah"))
                p.setImgSrc("/playerImage/salah.jpg");
            else if (s.equalsIgnoreCase("Bernd Leno"))
                p.setImgSrc("/playerImage/bernd leno.jpg");
            else if (s.equalsIgnoreCase("Hector Bellerin"))
                p.setImgSrc("/playerImage/hector.jpg");
            else if (s.equalsIgnoreCase("Granit Xhaka"))
                p.setImgSrc("/playerImage/granit.png");
            else if (s.equalsIgnoreCase("Thomas Partey"))
                p.setImgSrc("/playerImage/thomas.jpg");
            else if (s.equalsIgnoreCase("Pierre-Emerick Aubameyang"))
                p.setImgSrc("/playerImage/Pierre-Emerick.jpg");
            playerList.set(i, p);
        }
        return playerList;
    }
}
