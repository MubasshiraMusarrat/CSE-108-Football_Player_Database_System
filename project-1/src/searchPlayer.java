import java.util.List;
import java.util.Scanner;

public class searchPlayer {
    public static void searchByName(List<player> playerList) throws Exception {
        System.out.println("Enter Player's Name:");
        boolean searchIndex = false;

        Scanner sc =new Scanner(System.in);
        String name= sc.nextLine();
        for(player t : playerList){
            if(t.getName().equalsIgnoreCase(name))
            {
                searchIndex=true;
                System.out.println(t);
            }
        }
        if(!searchIndex)
            System.out.println("No such player with this name");
        sc.nextLine();
        menu.searchPlayer();
    }

    public static void searchByClubAndCountry(List<Country> countryList) throws Exception {
        boolean searchIndex=false;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a Country: ");
        String country= sc.nextLine();

        for(Country c : countryList) {
            if (c.getCountry().equalsIgnoreCase(country)) {
                System.out.println("Enter a Club: ");
                String club= sc.nextLine();
                if (club.equalsIgnoreCase("any")) {
                    searchIndex = true;
                    for (player p : c.Players)
                        System.out.println(p);
                } else {
                    for (player p : c.Players)
                        if (p.getClub().equalsIgnoreCase(club)) {
                            searchIndex = true;
                            System.out.println(p);
                        }
                }
            }
        }
            if(!searchIndex)
                System.out.println("No player with this country & club.");
        sc.nextLine();
            menu.searchPlayer();
    }

    public static void searchBySalary(List<player> playerList) throws Exception {
        boolean searchIndex= false;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Lower Range :");
        int lowerRange= sc.nextInt();
        System.out.println("Enter Upper Range :");
        int upperRange= sc.nextInt();

        for(player p : playerList){
            if(p.getWeeklySalary()<=upperRange && p.getWeeklySalary()>=lowerRange){
                searchIndex=true;
                System.out.println(p);
            }
        }
        if(!searchIndex)
            System.out.println("No player with this weekly salary range");
        sc.nextLine();
        menu.searchPlayer();
    }

    public static void searchByPosition(List<player> playerList) throws Exception
    {
        boolean searchIndex= false;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Position :");
        String position= sc.nextLine();

        for(player p : playerList){
            if(p.getPosition().equalsIgnoreCase(position)){
                searchIndex=true;
                System.out.println(p);
            }
        }
        if(!searchIndex)
            System.out.println("No player with this position");
        sc.nextLine();
        menu.searchPlayer();
    }

    public static void Count(List<Country> countryList) throws Exception {
        Scanner sc =new Scanner(System.in);
        boolean searchIndex=false;
        String Country;
        System.out.println("Enter Country:");
        Country=sc.nextLine();

        for (Country c : countryList)
        {
            if(c.country.equalsIgnoreCase(Country))
            {
                searchIndex=true;
                System.out.println("Total number of players in country "+c.country+ " is "+ c.Players.size());
            }
        }
        if(!searchIndex)
            System.out.println("No country with this name is found.");
        sc.nextLine();
        menu.searchPlayer();
    }
}
