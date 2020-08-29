
/**
 * 
 * @author Sai Rahul Reddy Kondlapuddi
 * 
 * 
 * 
 * @Description Calendar Printer Tester
 * 
 * 
 * 
 * @Version 1.0
 * 
 */


public class CalendarTester {


  /**
   * 
   * Checks whether CalendarPrinter.fullCenturiesContained() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */


  public static boolean testFullCenturiesContained() {

    if (CalendarPrinter.fullCenturiesContained(new Year(24)) != 0) {

      System.out.println(

              "Your method should have returned 0 when input provided is 24 Instead it returned "

                      + CalendarPrinter.fullCenturiesContained(new Year(24)));

      return false;

    }


    if (CalendarPrinter.fullCenturiesContained(new Year(3442)) != 34) {

      System.out.println(

              "Your method should have returned 34 when input provided is 3442. Instead it returned "

                      + CalendarPrinter.fullCenturiesContained(new Year(3442)));

      return false;

    }


    if (CalendarPrinter.fullCenturiesContained(new Year(99999)) != 999) {

      System.out.println(

              "Your method should have returned 99999 when input provided is 999. Instead it returned "

                      + CalendarPrinter.fullCenturiesContained(new Year(99999)));

      return false;

    }

    System.out.println("testFullCenturiesContained() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.yearOffsetWithinCentury() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */


  public static boolean testYearOffsetWithinCentury() {

    if (CalendarPrinter.yearOffsetWithinCentury(new Year(9999934)) != 34) {

      System.out.println(

              "Your method should have returned 34 when input provided is 99999934. Instead it returned "

                      + CalendarPrinter.yearOffsetWithinCentury(new Year(9999934)));

      return false;

    }


    if (CalendarPrinter.yearOffsetWithinCentury(new Year(22000)) != 0) {

      System.out.println(

              "Your method should have returned 0 when input provided is 22000. Instead it returned "

                      + CalendarPrinter.yearOffsetWithinCentury(new Year(22000)));

      return false;

    }


    if (CalendarPrinter.yearOffsetWithinCentury(new Year(99)) != 99) {

      System.out.println(

              "Your method should have returned 99 when input provided is 99. Instead it returned "

                      + CalendarPrinter.yearOffsetWithinCentury(new Year(99)));


      return false;

    }

    System.out.println("testYearOffsetWithinCentury() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.isLeapYear() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */


  public static boolean testIsLeapYear() {

    if (CalendarPrinter.isLeapYear(new Year(2068)) == false) {

      System.out.println(

              "Your method should have returned true when input provided is 2068. Instead it returned "

                      + CalendarPrinter.isLeapYear(new Year(2068)));

      return false;

    }


    if (CalendarPrinter.isLeapYear(new Year(99)) == true) {

      System.out.println(

              "Your method should have returned false when input provided is 99. Instead it returned "

                      + CalendarPrinter.isLeapYear(new Year(99)));

      return false;

    }


    if (CalendarPrinter.isLeapYear(new Year(1624)) == false) {

      System.out.println(

              "Your method should have returned true when input provided is 1624. Instead it returned "

                      + CalendarPrinter.isLeapYear(new Year(1624)));


      return false;

    }

    System.out.println("testIsLeapYear() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.numberOfDaysInMonth() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */

  public static boolean testNumberOfDaysInMonth() {

    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.January, new Year(2436))) != 31) {

      System.out.println(

              "Your method should have returned 31 when input provided is January 2436 Instead it returned "

                      + CalendarPrinter

                              .numberOfDaysInMonth(new Month(MonthOfYear.January, new Year(2436))));

      return false;

    }


    if (CalendarPrinter

            .numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2000))) != 28) {

      System.out.println(

              "Your method should have returned 31 when input provided is January 2436 Instead it returned "

                      + CalendarPrinter.numberOfDaysInMonth(

                              new Month(MonthOfYear.February, new Year(2000))));

      return false;

    }


    if (CalendarPrinter

            .numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(1977))) != 29) {

      System.out.println(

              "Your method should have returned 31 when input provided is January 2436 Instead it returned "

                      + CalendarPrinter.numberOfDaysInMonth(

                              new Month(MonthOfYear.February, new Year(1977))));

      return false;

    }


    System.out.println("testNumberOfDaysInMonth() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.calcFirstDayOfWeekInMonth() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */


  public static boolean testCalcFirstDayOfWeekInMonth() {


    if (CalendarPrinter.calcFirstDayOfWeekInMonth(

            new Month(MonthOfYear.January, new Year(2000))) != DayOfWeek.Saturday) {

      System.out.println(

              "Your method should have returned Saturday when input provided is January 2000 Instead it returned "

                      + CalendarPrinter.calcFirstDayOfWeekInMonth(

                              new Month(MonthOfYear.January, new Year(2000))));

      return false;

    }


    if (CalendarPrinter.calcFirstDayOfWeekInMonth(

            new Month(MonthOfYear.March, new Year(2000))) != DayOfWeek.Wednesday) {

      System.out.println(

              "Your method should have returned Wednesday when input provided is March 2000 Instead it returned "

                      + CalendarPrinter.calcFirstDayOfWeekInMonth(

                              new Month(MonthOfYear.March, new Year(2000))));

      return false;

    }


    if (CalendarPrinter.calcFirstDayOfWeekInMonth(

            new Month(MonthOfYear.April, new Year(2439))) != DayOfWeek.Friday) {

      System.out.println(

              "Your method should have returned Friday when input provided is April 2439 Instead it returned "

                      + CalendarPrinter.calcFirstDayOfWeekInMonth(

                              new Month(MonthOfYear.April, new Year(2439))));

      return false;

    }


    System.out.println("testCalcFirstDayOfWeekInMonth() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.dayOfWeekAfter() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */

  public static boolean testDayOfWeekAfter() {


    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday) != DayOfWeek.Monday) {

      System.out.println(

              "Your method should have returned Monday when input provided is Sunday Instead it returned "

                      + CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday));

      return false;

    }


    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Tuesday) != DayOfWeek.Wednesday) {

      System.out.println(

              "Your method should have returned Wednesday when input provided is Tuesday Instead it returned "

                      + CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday));

      return false;

    }


    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Thursday) != DayOfWeek.Friday) {

      System.out.println(

              "Your method should have returned Friday when input provided is Thursday Instead it returned "

                      + CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday));

      return false;

    }


    System.out.println("testDayOfWeekAfter() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.monthOfYearAfter() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */


  public static boolean testMonthOfYearAfter() {


    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.January) != MonthOfYear.February) {

      System.out.println(

              "Your method should have returned February when input provided is January Instead it returned "

                      + CalendarPrinter.monthOfYearAfter(MonthOfYear.January));

      return false;

    }


    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.December) != MonthOfYear.January) {

      System.out.println(

              "Your method should have returned January when input provided is December Instead it returned "

                      + CalendarPrinter.monthOfYearAfter(MonthOfYear.December));

      return false;

    }


    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.March) != MonthOfYear.April) {

      System.out.println(

              "Your method should have returned April when input provided is March Instead it returned "

                      + CalendarPrinter.monthOfYearAfter(MonthOfYear.March));

      return false;

    }


    System.out.println("testMonthOfYearAfter() : All tests passed");

    return true;


  }


  /**
   * 
   * Checks whether CalendarPrinter.createNewMonth() method works as expected.
   * 
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */

  public static boolean testCreateNewMonth() {


    Month testCase1 = CalendarPrinter.createNewMonth(MonthOfYear.January, new Year(1982));

    if (testCase1.getDayCount() != 31) {

      System.out.println("Your Input of January 1982 gave the wrong number of days.");

      return false;

    }


    if (CalendarPrinter.calcFirstDayOfWeekInMonth(testCase1) != DayOfWeek.Friday) {

      System.out.println("Your Input of January 1982 gave the wrong first day of the month.");

      return false;

    }


    System.out.println("testCreateNewMonth() : All tests passed");

    return true;

  }


  /**
   * 
   * Initializes Test methods
   * 
   * 
   * 
   * Prints "All Tests Passed", If all tests Passed
   * 
   */


  public static void main(String[] args) {


    testFullCenturiesContained();

    testYearOffsetWithinCentury();

    testIsLeapYear();

    testNumberOfDaysInMonth();

    testCalcFirstDayOfWeekInMonth();

    testDayOfWeekAfter();

    testMonthOfYearAfter();

    testCreateNewMonth();

  }

}
