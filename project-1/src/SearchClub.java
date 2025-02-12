import java.util.List;
import java.util.Scanner;

public class SearchClub {
    public static void maxSalary(List<Club> clubList) throws Exception {
        System.out.println("Enter Club Name: ");
        Scanner sc = new Scanner(System.in);
        String Club = sc.nextLine();
        boolean searchIndex = false;
        for (Club c : clubList) {
            if (c.getClub().equalsIgnoreCase(Club)) {
                searchIndex = true;
                player pMax = new player();
                pMax = c.Players.get(0);

                for (player p : c.Players)
                    if (pMax.getWeeklySalary() < p.getWeeklySalary())
                        pMax = p;
                for (player p : c.Players)
                    if (p.getWeeklySalary() == pMax.getWeeklySalary())
                        System.out.println(p);
            }
        }
        if(!searchIndex)
            System.out.println("No such club with this name");
        menu.searchClub();
    }

    public static void maxAge(List<Club>clubList) throws Exception {
        System.out.println("Enter Club Name: ");
        Scanner sc =new Scanner(System.in);
        String name= sc.nextLine();
        boolean searchIndex= false;
        for(Club c : clubList) {
            if (c.getClub().equalsIgnoreCase(name)) {
                searchIndex=true;
                player pMax= new player();
                pMax = c.Players.get(0);
                for (player p : c.Players)
                    if (pMax.getAge() < p.getAge())
                        pMax = p;
                for (player p : c.Players)
                    if (p.getAge() == pMax.getAge())
                        System.out.println(p);
            }
        }
        if(!searchIndex)
            System.out.println("No such club with this name");
        menu.searchClub();
    }

    public static void maxHeight(List<Club>clubList) throws Exception {
        System.out.println("Enter Club Name: ");
        Scanner sc =new Scanner(System.in);
        String name= sc.nextLine();
        boolean searchIndex= false;
        for(Club c : clubList) {
            if (c.getClub().equalsIgnoreCase(name)) {
                searchIndex=true;
                player pMax= new player();
                pMax = c.Players.get(0);
                for (player p : c.Players)
                    if (pMax.getHeight() < p.getHeight())
                        pMax = p;
                for (player p : c.Players)
                    if (p.getHeight() == pMax.getHeight())
                        System.out.println(p);
            }
        }
        if(!searchIndex)
            System.out.println("No such club with this name");
        menu.searchClub();
    }

    public static void totalSalary(List<Club>clubList) throws Exception {
        int totalSalary = 0;
        System.out.println("Enter Club Name: ");
        Scanner sc =new Scanner(System.in);
        String name= sc.nextLine();
        boolean searchIndex= false;
        for(Club c : clubList) {
            if (c.getClub().equalsIgnoreCase(name)) {
                searchIndex=true;
                for (player p : c.Players) totalSalary += p.getWeeklySalary();
                System.out.println("Total Salary of " + name + " is " + totalSalary);
            }
        }
        if(!searchIndex)
            System.out.println("No such club with this name");
        menu.searchClub();
    }
}
