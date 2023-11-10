package com.solvd.menu;

import com.solvd.profile.Profile;

public class StartMemberMenu implements IMenu{
    @Override
    public String[] getInput() {
        LOGGER.info("Member Log In - option 0\nMember Sign Up - option 1\nQuit - option 2");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
