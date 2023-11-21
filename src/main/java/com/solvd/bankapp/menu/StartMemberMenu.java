package com.solvd.bankapp.menu;

import java.util.Scanner;

public class StartMemberMenu implements IMenu{
    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Log In - option 0\nMember Sign Up - option 1\nQuit - option 2");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
