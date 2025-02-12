import java.util.ArrayList;
import java.util.List;

public class Country {
    String country;
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<player> Players = new ArrayList();

    public static List<Country> CountryList(List<player> playerList) {
        List<Country> countryList = new ArrayList();

        for (player p : playerList) {
            boolean searchIndex = false;
            for (Country c : countryList) {
                if (c.country.equalsIgnoreCase(p.getCountry())) {
                    searchIndex = true;
                    c.Players.add(p);
                }
            }

            if (!searchIndex) {
                Country c = new Country();
                c.setCountry(p.getCountry());
                c.Players.add(p);
                countryList.add(c);
            }
        }
        return countryList;
    }
}
