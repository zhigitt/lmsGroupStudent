package models;

public class Admin {
    private String adminName;
    private String adminLogin;
    private String password;

    public Admin(String adminName, String adminLogin, String password) {
        this.adminName = adminName;
        this.adminLogin = adminLogin;
        this.password = password;
    }


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", adminLogin='" + adminLogin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
