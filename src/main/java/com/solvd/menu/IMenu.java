package com.solvd.menu;

import java.util.Scanner;

public interface IMenu {
    Scanner scanner = new Scanner(System.in);
    String[] getInput();
}
