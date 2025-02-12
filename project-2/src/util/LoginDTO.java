package util;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String ClubName) {
        this.ClubName = ClubName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String ClubName;
    private Integer password;
    private boolean status;
}
