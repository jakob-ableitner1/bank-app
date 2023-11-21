package com.solvd.bankapp.menu;

import java.util.Scanner;

public class StartMenu implements IMenu {

    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Log in - option 0\nQuit - option 1");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
