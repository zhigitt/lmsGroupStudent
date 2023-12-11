package sevice.impl;

import models.Admin;
import models.db.DataBase;
import sevice.AdminService;

import java.util.Scanner;

public class AdminServiceImpl implements AdminService {
    DataBase dataBase;

    public AdminServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean login(String login, String password) {
        for (Admin admin : dataBase.admin) {
            if (admin.getAdminLogin().equalsIgnoreCase(login) && admin.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void forgotPassword(String login) {
        Scanner sc = new Scanner(System.in);

        for (Admin admin : dataBase.admin) {
            if (admin.getAdminLogin().equalsIgnoreCase(login)){
                System.out.print("Жаны пароль жазынз: ");
                String newPass = sc.nextLine();
                admin.setPassword(newPass);

                System.out.println("Пароль озгортулду");
                return;
            }
        }
        System.out.println("Мындай логинде админ жок!");
    }
}
