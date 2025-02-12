import java.io.*;
import java.util.List;
import java.util.Scanner;

public class menu {
    public static void Menu() throws Exception {
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("Main Menu:");
            System.out.println("(1) Search Players");
            System.out.println("(2) Search Clubs");
            System.out.println("(3) Add Player");
            System.out.println("(4) Exit System");
            System.out.println("Choose one:");
            input = sc.nextInt();
        } while (input < 1 || input > 5);
        System.out.println();

        switch (input) {
            case 1:
                searchPlayer();
                break;
            case 2:
                searchClub();
                break;
            case 3:
                addPlayer();
                break;
            case 4:
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void searchPlayer() throws Exception {
        Scanner sc=new Scanner(System.in);
        int input;
        do{
            System.out.println("Player Searching Options:");
            System.out.println("(1) By Player Name");
            System.out.println("(2) By Club and Country");
            System.out.println("(3) By Position");
            System.out.println("(4) By Salary Range");
            System.out.println("(5) Country-wise player count");
            System.out.println("(6) Back to Main Menu");
            input= sc.nextInt();
        }   while ((input < 1) || (input > 6));
        System.out.println();

            switch (input)
            {
                case 1:
                    searchPlayer.searchByName(FileOperations.readFromFile());
                    break;
                case 2:
                    searchPlayer.searchByClubAndCountry(Country.CountryList(FileOperations.readFromFile()));
                    break;
                case 3:
                    searchPlayer.searchByPosition(FileOperations.readFromFile());
                    break;
                case 4:
                    searchPlayer.searchBySalary(FileOperations.readFromFile());
                    break;
                case 5:
                    searchPlayer.Count(Country.CountryList(FileOperations.readFromFile()));
                    break;
                case 6:
                    Menu();
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
    }

    public static void searchClub() throws Exception {
        Scanner sc=new Scanner(System.in);
        int input;
        do{
            System.out.println("Club Searching Options:");
            System.out.println("(1) Player(s) with the maximum salary of a club");
            System.out.println("(2) Player(s) with the maximum age of a club");
            System.out.println("(3) Player(s) with the maximum height of a club");
            System.out.println("(4) Total yearly salary of a club");
            System.out.println("(5) Back to Main Menu");
            input= sc.nextInt();
        }   while (input<1 || input>5);
        System.out.println();

        switch (input)
        {
            case 1:
                SearchClub.maxSalary(Club.ClubList(FileOperations.readFromFile()));
                break;
            case 2:
                SearchClub.maxAge(Club.ClubList(FileOperations.readFromFile()));
                break;
            case 3:
                SearchClub.maxHeight(Club.ClubList(FileOperations.readFromFile()));
                break;
            case 4:
                SearchClub.totalSalary(Club.ClubList(FileOperations.readFromFile()));
                break;
            case 5:
                Menu();
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }

    public static void addPlayer() throws Exception {

        FileOperations file=new FileOperations();
            String name;
            String country;
            int age;
            double height;
            String club;
            String position;
            int number;
            double weeklySalary;

            Scanner scn = new Scanner(System.in);

            System.out.println("Enter Player Name: ");
            name = scn.nextLine();
            boolean AddName = Catch.catchName(name,FileOperations.playerList);
            if(!AddName) {
                System.out.println("Name already exists");
                addPlayer();
            }
            else{
                System.out.println("Enter Club Name: ");
                club = scn.nextLine();
                int AddToClub = Catch.catchClub(club, Club.ClubList(FileOperations.playerList)) ;
                if(AddToClub == 2) {
                    System.out.println("Can't add more to this club");
                    addPlayer();
                }
                else {
                    System.out.println("Enter Jersey Number: ");
                    number = scn.nextInt();
                    boolean AddNumber = Catch.catchNumber(number,club, FileOperations.playerList) ;
                    if(!AddNumber) {
                        System.out.println("This number exists.");
                        addPlayer();
                    }
                    else{

                        System.out.println("Enter Position : ");
                        position = scn.next();
                        boolean AddPosition = Catch.catchPosition(position);
                        if(!AddPosition){
                            System.out.println("No valid position");
                            addPlayer();
                        }
                        else {
                            System.out.println("Enter Age : ");
                            age = scn.nextInt();
                            System.out.println("Enter Height : ");
                            height = scn.nextDouble();
                            System.out.println("Enter Country : ");
                            country = scn.next();
                            System.out.println("Enter WeeklySalary : ");
                            weeklySalary = scn.nextDouble();

                            player p = new player();

                            p.setName(name);
                            p.setClub(club);
                            p.setNumber(number);
                            p.setCountry(country);
                            p.setAge(age);
                            p.setHeight(height);
                            p.setPosition(position);
                            p.setWeeklySalary(weeklySalary);

                            FileOperations.playerList.add(p);
                            FileOperations.writeToFile(FileOperations.playerList);

                        }
                    }
                }
            }
            Menu();
        }
    }
