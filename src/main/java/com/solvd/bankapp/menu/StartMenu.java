package com.solvd.bankapp.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class StartMenu implements IMenu {
    Logger LOGGER = LogManager.getLogger(StartMenu.class);

    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Log in - option 0\nQuit - option 1");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
