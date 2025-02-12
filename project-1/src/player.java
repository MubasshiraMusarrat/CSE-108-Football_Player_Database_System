import java.util.ArrayList;
import java.util.List;

class player {
    private String Name;
    private String Country;
    private int Age;
    private double Height;
    private String Club;
    private String Position;
    private int Number;
    private double WeeklySalary;

    public player()
    {

    }

    public player(String Name,String Country,int Age,double Height,String Club,String Position,int Number,double WeeklySalary)
    {
        this.Name=Name;
        this.Country=Country;
        this.Age=Age;
        this.Height=Height;
        this.Club=Club;
        this.Position=Position;
        this.Number=Number;
        this.WeeklySalary=WeeklySalary;
    }

    public String getName() { return Name; }
    public void setName(String Name) { this.Name=Name; }

    public String getCountry() { return Country; }
    public void setCountry(String Country) { this.Country=Country; }

    public int getAge() { return Age; }
    public void setAge(int Age) { this.Age=Age; }

    public double getHeight() { return Height; }
    public void setHeight(double Height) { this.Height=Height; }

    public String getClub() { return Club; }
    public void setClub(String Club) { this.Club=Club; }

    public String getPosition() { return Position; }
    public void setPosition(String Position) {this.Position=Position; }

    public int getNumber() { return Number; }
    public void setNumber(int Number) { this.Number=Number; }

    public double getWeeklySalary() { return WeeklySalary;}
    public void setWeeklySalary(double WeeklySalary) { this.WeeklySalary=WeeklySalary; }

    @Override
    public String toString(){
        return (Name+ "," +Country+ "," +Age+ "," +Height+ "," +Club+ "," +Position+ "," +Number+ "," +WeeklySalary);
    }
}
