package com.solvd.bankapp.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@FunctionalInterface
public interface IMenu {
    String[] getInput(Scanner scanner);
}
