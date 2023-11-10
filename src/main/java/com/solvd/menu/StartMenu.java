package com.solvd.menu;

import com.solvd.profile.Profile;

import java.util.Scanner;

public class StartMenu implements IMenu {

    @Override
    public String[] getInput() {
        LOGGER.info("Log in - option 0\nQuit - option 1");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
