package com.solvd.menu;

public class MemberMenu implements IMenu{

    @Override
    public String[] getInput() {
        LOGGER.info("Change Address - option 0\nView Profile Details - option 1\nView Account Details - option 2\nTransfer Money - option 3\nLog Out - option 4");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
