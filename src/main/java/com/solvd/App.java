package com.solvd;

import com.solvd.profile.Member;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        //use these for log in
        Member member1 = new Member("Jakob Ableitner", "jableitn", "pw");
        Member member2 = new Member("Tim Smith", "tsmith", "timspw");
        Member member3 = new Member("Bob Cook", "bcook", "bobspw");
        Member[] members = {member1, member2, member3};
        boolean hasTerminitedApp = false;

        while (!hasTerminitedApp)  {

            System.out.println("Type 0 if you are a bank member");
            System.out.println("Type 1 if you are an employee. Not implemented yet.");
            System.out.println("Type 2 if you want to quit this application");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 0:
                    memberMenu(members);
                    continue;
//                case 1:
//                    employeeMenu();
                case 2:
                    hasTerminitedApp = true;
                    System.out.println("Leaving application. Goodbye");
                    continue;
                default:
                    System.out.println("This input is unvalid");
            }
        }
    }

    public static void memberMenu(Member[] members){
        boolean hasTerminatedMenu = false;

        while (!hasTerminatedMenu){
            System.out.println("select 0 if you are a current member");
            System.out.println("select 1 to quit");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input){
                case 0:
                    System.out.println("enter username");
                    String username = scanner.nextLine();
                    System.out.println("enter password");
                    String password = scanner.nextLine();
                    Member member = findMember(members, username, password);

                    if(member != null){
                        System.out.println("Hello " + member.getName());
                    } else{
                        System.out.println("username or password is incorrect");
                    }
                    continue;
                case 1:
                    hasTerminatedMenu = true;
                default:
                    System.out.println("Input not valid. Please try again");
            }
        }
    }

    public static Member findMember(Member[] members, String username, String password) {
        for (Member member : members) {
            if (username.equals(member.getUsername()) && password.equals(member.getPassword())){
                return member;
            }
        }
        return null;
    }
}