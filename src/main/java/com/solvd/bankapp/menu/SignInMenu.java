package com.solvd.bankapp.menu;

import java.util.Scanner;

public class SignInMenu implements IMenu {
    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("enter username");
        String username = scanner.nextLine();
        LOGGER.info("enter password");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }
}
