package com.solvd.bankapp.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MemberMenu implements IMenu{
    Logger LOGGER = LogManager.getLogger(MemberMenu.class);

    @Override
    public String[] getInput(Scanner scanner) {
        LOGGER.info("Change Address - option 0\nView Profile Details - option 1\nView Account Details - option 2\nTransfer Money - option 3\nLog Out - option 4");
        String input = scanner.nextLine();
        return new String[]{input};
    }
}
