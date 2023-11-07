package com.solvd.menu;

import com.solvd.profile.Profile;

import java.util.Scanner;

public class StartMenu implements IMenu {

    @Override
    public String[] getInput() {
        System.out.println("Bank Member - option 0\nEmployee. Not implemented yet. - option 1\nQuit - option 2");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
