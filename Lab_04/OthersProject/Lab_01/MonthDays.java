package Lab__01;

import java.util.Scanner;

public class MonthDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = 0;
        int year;

        System.out.print("Enter month: ");
        String input = sc.nextLine().trim();

        if (input.equalsIgnoreCase("January") || input.equalsIgnoreCase("Jan") || input.equals("1")) {
            month = 1;
        } else if (input.equalsIgnoreCase("February") || input.equalsIgnoreCase("Feb") || input.equals("2")) {
            month = 2;
        } else if (input.equalsIgnoreCase("March") || input.equalsIgnoreCase("Mar") || input.equals("3")) {
            month = 3;
        } else if (input.equalsIgnoreCase("April") || input.equalsIgnoreCase("Apr") || input.equals("4")) {
            month = 4;
        } else if (input.equalsIgnoreCase("May") || input.equals("5")) {
            month = 5;
        } else if (input.equalsIgnoreCase("June") || input.equalsIgnoreCase("Jun") || input.equals("6")) {
            month = 6;
        } else if (input.equalsIgnoreCase("July") || input.equalsIgnoreCase("Jul") || input.equals("7")) {
            month = 7;
        } else if (input.equalsIgnoreCase("August") || input.equalsIgnoreCase("Aug") || input.equals("8")) {
            month = 8;
        } else if (input.equalsIgnoreCase("September") || input.equalsIgnoreCase("Sep") || input.equals("9")) {
            month = 9;
        } else if (input.equalsIgnoreCase("October") || input.equalsIgnoreCase("Oct") || input.equals("10")) {
            month = 10;
        } else if (input.equalsIgnoreCase("November") || input.equalsIgnoreCase("Nov") || input.equals("11")) {
            month = 11;
        } else if (input.equalsIgnoreCase("December") || input.equalsIgnoreCase("Dec") || input.equals("12")) {
            month = 12;
        } else {
            System.out.println("Invalid month!");
            return;
        }

        System.out.print("Enter year: ");
        year = sc.nextInt();

        if (year < 0) {
            System.out.println("Invalid year!");
            return;
        }

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = isLeap ? 29 : 28;
                break;
        }

        System.out.println("Number of days: " + days);
    }
}
