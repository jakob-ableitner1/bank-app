package com.solvd.bankapp.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CreateMemberProfileMenu implements IMenu{
    Logger LOGGER = LogManager.getLogger(CreateMemberProfileMenu.class);

    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Enter the values for the following fields and press the enter button after each value: Name, Username, Password, Age");
        String name = scanner.nextLine();
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String age = scanner.nextLine();

        return new String[]{name, username, password, age};
    }
}
