package com.solvd.bankapp.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public interface IMenu {
    Logger LOGGER = LogManager.getLogger(IMenu.class);
    String[] getInput(Scanner scanner);
}
