/**
 * 
 * @author Sai Rahul Reddy Kondlapuddi
 * 
 * 
 * 
 * @Description Calendar Printer
 * 
 * 
 * 
 * @Version 1.0
 * 
 */


import java.util.ArrayList;

import java.util.Scanner;


public class CalendarPrinter {


  /**
   * 
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * 
   * example, the year 2034 has the century index of 20 (as do * the other years 2000-2099).
   * 
   * 
   * 
   * @param year to compute the century offset for
   * 
   * @return number of centuries between year 0 and the specified year
   * 
   */

  public static int fullCenturiesContained(Year year) {

    int numberOfYears = year.intValue();

    int centuries = (numberOfYears / 100);

    return centuries;


  }


  /**
   * 
   * Calculates the number of years between the specified year and the first year of * its century.
   * 
   * For example, the year 2034 has the offset within its century of 34 * (as do 1234 and 9999934).
   * 
   * 
   * 
   * @param year to compute the offset within century for
   * 
   * @return number of years between the specified year and the first year of century
   * 
   */

  public static int yearOffsetWithinCentury(Year year) {

    int numberOfYears = year.intValue();

    int yearsSinceCentury = (numberOfYears % 100);

    return yearsSinceCentury;


  }


  /**
   * 
   * This method computes whether the specified year is a leap year or not.
   * 
   * 
   * 
   * @param year is the year is being checked for leap-year-ness
   * 
   * @return true when the specified year is a leap year, and false otherwise
   * 
   */

  public static boolean isLeapYear(Year year) {

    int numberOfYears = year.intValue();

    if ((numberOfYears % 4) == 0) {

      if ((numberOfYears % 100) == 0) {

        if ((numberOfYears % 400) == 0) {

          return true;

        }

        return false;

      }

      return true;

    }


    return false;


  }


  /**
   * 
   * Calculates the number of days in the specified month, while taking into consideration whether
   * 
   * or not the specified month is in a leap year. Note: that this is calculated based on the
   * 
   * month's monthOfYear and year, and * is NOT retrieved from the month's getDayCount() method.
   * 
   * This is because this * method is used to generate the day objects that are stored within each
   * 
   * month. * @param month to determine the number of days within (within its year)
   * 
   * 
   * 
   * @return the number of days in the specified month (between 28-31)
   * 
   */

  public static int numberOfDaysInMonth(Month month) {

    Year year = month.getYear();

    boolean leapYear = isLeapYear(year);

    if ((month.getMonthOfYear() == MonthOfYear.January)

            || (month.getMonthOfYear() == MonthOfYear.March)

            || (month.getMonthOfYear() == MonthOfYear.May)

            || (month.getMonthOfYear() == MonthOfYear.July)

            || (month.getMonthOfYear() == MonthOfYear.August)

            || (month.getMonthOfYear() == MonthOfYear.October)

            || (month.getMonthOfYear() == MonthOfYear.December)) {


      return 31;

    } else if ((month.getMonthOfYear() == MonthOfYear.April)

            || (month.getMonthOfYear() == MonthOfYear.June)

            || (month.getMonthOfYear() == MonthOfYear.September)

            || (month.getMonthOfYear() == MonthOfYear.November)) {


      return 30;

    }


    else if (leapYear && (month.getMonthOfYear() == MonthOfYear.February)) {

      return 28;

    }


    else if (!leapYear && (month.getMonthOfYear() == MonthOfYear.February)) {

      return 29;

    }


    else

      return 0;

  }


  /**
   * 
   * Calculates which day of the week the first day of the specified month falls on. * Note: that
   * 
   * this is calculated based on the month's monthOfYear and year, and is NOT retrieved from the
   * 
   * month's getDayByDate(1) day. This is because this method is used to generate the day objects
   * 
   * that are stored within each month.
   * 
   * 
   * 
   * @param month within which we are calculate the day of week for the first day
   * 
   * @return DayOfWeek corresponding to the first day within the specified month
   * 
   */

  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {

    Year year = month.getYear();

    int yearValue = year.intValue();

    if ((month.getMonthOfYear() == MonthOfYear.January)

            || (month.getMonthOfYear() == MonthOfYear.February)) {

      yearValue = yearValue - 1;

    }

    int yearOfTheCentury = yearValue % 100;

    int zeroBasedCentury = yearValue / 100;

    int monthNumber = 0;

    switch (month.getMonthOfYear()) {

      case March:

        monthNumber = 3;

        break;

      case April:

        monthNumber = 4;

        break;

      case May:

        monthNumber = 5;

        break;

      case June:

        monthNumber = 6;

        break;

      case July:

        monthNumber = 7;

        break;

      case August:

        monthNumber = 8;

        break;

      case September:

        monthNumber = 9;

        break;

      case October:

        monthNumber = 10;

        break;

      case November:

        monthNumber = 11;

        break;

      case December:

        monthNumber = 12;

        break;

      case January:

        monthNumber = 13;

        break;

      case February:

        monthNumber = 14;

        break;

      default:

        break;


    }

    int intDayNumber = ((1 + ((13 * (monthNumber + 1)) / 5) + yearOfTheCentury

            + (yearOfTheCentury / 4) + (zeroBasedCentury / 4) + (5 * zeroBasedCentury)) % 7);


    switch (intDayNumber) {

      case 0:

        return DayOfWeek.Saturday;


      case 1:

        return DayOfWeek.Sunday;


      case 2:

        return DayOfWeek.Monday;


      case 3:

        return DayOfWeek.Tuesday;


      case 4:

        return DayOfWeek.Wednesday;


      case 5:

        return DayOfWeek.Thursday;


      case 6:

        return DayOfWeek.Friday;


      default:

        break;


    }

    return null;

  }


  /**
   * 
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * 
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * 
   * 
   * @param dayBefore is the day of week that comes before the day of week returned * @return day of
   * 
   *                  week that comes after dayBefore
   * 
   */

  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {


    switch (dayBefore) {

      case Monday:

        return DayOfWeek.Tuesday;

      case Tuesday:

        return DayOfWeek.Wednesday;

      case Wednesday:

        return DayOfWeek.Thursday;

      case Thursday:

        return DayOfWeek.Friday;

      case Friday:

        return DayOfWeek.Saturday;

      case Saturday:

        return DayOfWeek.Sunday;

      case Sunday:

        return DayOfWeek.Monday;

      default:

        return null;

    }

  }


  /**
   * 
   * Calculates the month of the year that follows the specified month. For example, * July comes
   * 
   * after June, and January comes after December.
   * 
   * 
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * 
   * @return month of year that comes after monthBefore
   * 
   */

  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {

    switch (monthBefore) {

      case January:

        return MonthOfYear.February;

      case February:

        return MonthOfYear.March;

      case March:

        return MonthOfYear.April;

      case April:

        return MonthOfYear.May;

      case May:

        return MonthOfYear.June;

      case June:

        return MonthOfYear.July;

      case July:

        return MonthOfYear.August;

      case August:

        return MonthOfYear.September;

      case September:

        return MonthOfYear.October;

      case October:

        return MonthOfYear.November;

      case November:

        return MonthOfYear.December;

      case December:

        return MonthOfYear.January;


      default:

        return null;

    }

  }


  /**
   * 
   * Creates a new month object and fully initializes with its corresponding days. * @param
   * 
   * monthOfYear which month of the year this new month represents
   * 
   * 
   * 
   * @param year in which this month is a part
   * 
   * @return reference to the newly created month object
   * 
   */

  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {

    Month monthCreated = new Month(monthOfYear, year);

    DayOfWeek sampleDay = calcFirstDayOfWeekInMonth(monthCreated);

    monthCreated.addDay(new Day(sampleDay, 1, monthCreated));


    for (int i = 2; i < numberOfDaysInMonth(monthCreated) + 1; i++) {

      sampleDay = dayOfWeekAfter(sampleDay);

      monthCreated.addDay(new Day(sampleDay, i, monthCreated));

    }

    return monthCreated;


  }


  /**
   * 
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * 
   * with the Month an year of the month. The next line should * contain the three letter
   * 
   * abbreviations for the seven days of the week. And then * the dates of each day of that month
   * 
   * should follow: one week per line, with periods in positions of days that are a part of the
   * 
   * month before or after. For * example, January 2020 should be printed as follows:
   *
   * 
   * 
   * January 2020 MON TUE WED THU FRI SAT SUN . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
   * 
   * 21 22 23 24 25 26 27 28 29 30 31 . .
   *
   * 
   * 
   * @param month which is to be printed by this method
   * 
   */

  public static void printMonth(Month month) {

    System.out.println(month);



    /**
     * 
     * Prints out the Days of the Week on the top of the calendar
     * 
     */

    System.out.println("MON TUE WED THU FRI SAT SUN");


    /**
     * 
     * Checks the day the first day of the month lands on
     * 
     * Then prints the first three weeks of the month
     * 
     * The fourth week changes according to the number of days in the specified month
     * 
     */

    switch (calcFirstDayOfWeekInMonth(month)) {



      case Monday:

        System.out.println(" 1   2   3   4   5   6   7");

        System.out.println(" 8   9   10  11  12  13  14");

        System.out.println(" 15  16  17  18  19  20  21");

        System.out.println(" 22  23  24  25  26  27  28");


        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 29  30  31   .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 29  30   .   .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 29   .   .   .   .   .   .");

        }

        break;

      case Tuesday:

        System.out.println(" .   1   2   3   4   5   6");

        System.out.println(" 7   8   9   10  11  12  13");

        System.out.println(" 14  15  16  17  18  19  20");

        System.out.println(" 21  22  23  24  25  26  27");


        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 28  29  30  31  .   .   .");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 29  30  31  .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 28  29  .   .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 28) {

          System.out.println(" 28  .   .   .   .   .   .");

        }


        break;

      case Wednesday:

        System.out.println(" .   .   1   2   3   4   5");

        System.out.println(" 6   7   8   9   10  11  12");

        System.out.println(" 13  14  15  16  17  18  19");

        System.out.println(" 20  21  22  23  24  25  26");


        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 27  28  29  30  31  .   .");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 27  28  29  30  .   .   .");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 27  28  29  .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 28) {

          System.out.println(" 28  .   .   .   .   .   .");

          System.out.println(" 28  .   .   .   .   .   .");

        }

        break;

      case Thursday:

        System.out.println(" .   .   .   1   2   3   4");

        System.out.println(" 5   6   7   8   9   10  11");

        System.out.println(" 12  13  14  15  16  17  18");

        System.out.println(" 19  20  21  22  23  24  25");

        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 26  27  28  29  30  31  .");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 26  27  28  29  30  .   .");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 26  27  28  29  .   .   .");

        } else if (numberOfDaysInMonth(month) == 28) {

          System.out.println(" 26  27  28  .   .   .   .");

        }

        break;

      case Friday:

        System.out.println(" .   .   .   .   1   2   3");

        System.out.println(" 4   5   6   7   8   9   10");

        System.out.println(" 11  12  13  14  15  16  17");

        System.out.println(" 18  19  20  21  22  23  24");


        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 25  26  27  28  29  30  31");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 25  26  27  28  29  30  .");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 25  26  27  28  29  .   .");

        } else if (numberOfDaysInMonth(month) == 28) {

          System.out.println(" 25  26  27  28  .   .   .");

        }

        break;

      case Saturday:

        System.out.println(" .   .   .   .   .   1   2");

        System.out.println(" 3   4   5   6   7   8   9");

        System.out.println(" 10  11  12  13  14  15  16");

        System.out.println(" 17  18  19  20  21  22  23");

        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 24  25  26  27  28  29  30");

          System.out.println(" 31  .   .   .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 24  25  26  27  28  29  30");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 24  25  26  27  28  29  .");

        } else if (numberOfDaysInMonth(month) == 28) {

          System.out.println(" 24  25  26  27  28  .   .");

        }

        break;

      case Sunday:

        System.out.println(" .   .   .   .   .   .   1");

        System.out.println(" 2   3   4   5   6   7   8");

        System.out.println(" 9   10  11  12  13  14  15");

        System.out.println(" 16  17  18  19  20  21  22");


        if (numberOfDaysInMonth(month) == 31) {

          System.out.println(" 23  24  25  26  27  28  29");

          System.out.println(" 30  31  .   .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 30) {

          System.out.println(" 23  24  25  26  27  28  29");

          System.out.println(" 30  .   .   .   .   .   .");

        } else if (numberOfDaysInMonth(month) == 29) {

          System.out.println(" 23  24  25  26  27  28  29");

        } else if (numberOfDaysInMonth(month) == 28) {

          System.out.println(" 23  24  25  26  27  28  .");

        }

        break;

    }


  }


  /**
   * 
   * Creates an array list of months that are initialized with their full complement * of days.
   * 
   * Prints out each of these months in calendar form, and then returns the * resulting ArrayList.
   * 
   * 
   * 
   * @param month of the year for the first month that is created and printed
   * 
   * @param year  that the first month created and printed is a part of
   * 
   * @param count is the total number of sequential months created and printed
   * 
   */

  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {

    ArrayList<Month> createdMonths = new ArrayList<Month>();

    MonthOfYear addMonth = month;

    createdMonths.add(createNewMonth(addMonth, year));

    printMonth(createNewMonth(addMonth, year));

    System.out.println();

    for (int i = 0; i < count - 1; i++) {

      if (monthOfYearAfter(addMonth) != MonthOfYear.January) {

        addMonth = monthOfYearAfter(addMonth);

        createdMonths.add(createNewMonth(addMonth, year));

        printMonth(createNewMonth(addMonth, year));

        System.out.println();

      }

      if (monthOfYearAfter(addMonth) == MonthOfYear.January) {

        addMonth = monthOfYearAfter(addMonth);

        year = new Year(year.intValue() + 1);

        createdMonths.add(createNewMonth(addMonth, year));

        printMonth(createNewMonth(addMonth, year));

        System.out.println();

      }



    }


    return createdMonths;


  }


  /**
   * 
   * Driver for the CalendarPrinter Application. This program asks the user to enter * an initial
   * 
   * month, an initial year, and the total number of months to create and * display in calendar
   * 
   * form.
   * 
   * 
   * 
   * @param args is not used by this program
   * 
   */


  public static void main(String[] args) {

    // print welcome message

    Scanner in = new Scanner(System.in);

    System.out.println("Welcome to the Calendar Printer.");

    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");

    // read input from the user

    System.out.print("Enter the month to begin calendar: ");


    String monthString = in.nextLine().trim();

    System.out.print("Enter the year to begin calendar: ");

    String yearString = in.nextLine().trim();

    System.out.print("Enter the number of months to include in this calendar: ");

    String countString = in.nextLine().trim();

    // convert user input into usable form

    monthString = monthString.substring(0, 3).toUpperCase();

    MonthOfYear month = null;

    for (int i = 0; i < MonthOfYear.values().length; i++)

      if (monthString.equals(MonthOfYear.values()[i].name().substring(0, 3).toUpperCase()))

        month = MonthOfYear.values()[i];

    Year year = new Year(Integer.parseInt(yearString.trim()));

    int count = Integer.parseInt(countString.trim());

    // create months and display them in calendar form

    System.out.println();

    createAndPrintMonths(month, year, count);

    // display thank you message

    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");

    System.out.println("Thanks, and have a nice day.");

    in.close();

  }


}
