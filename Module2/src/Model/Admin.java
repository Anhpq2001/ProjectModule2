package Model;

import java.io.Serializable;

public class Admin implements Serializable {
    private static final long serialVersionUID = 1l;
    private String adminEmail = "admin@fpt.edu.vn";
    private String adminPasswork = "1234567890";

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPasswork() {
        return adminPasswork;
    }

    @Override
    public String toString() {
        return super.toString() + "Admin{" +
                "adminEmail='" + adminEmail + '\'' +
                ", adminPasswork='" + adminPasswork + '\'' +
                '}';
    }
}
