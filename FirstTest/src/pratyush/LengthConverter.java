package pratyush;

public class LengthConverter {


    /**
     * This program should convert measurements expressed in inches,
     * feet, yards, or miles into each of the possible units of
     * measure.
     */



    public static void main(String[] args) {

        double measurement = 12.37;

        int  unit = 1; //we will use 1 for inches, 2 for feet, 3 for yard and 4 for miles.

        String unitName = "NOT_DEFINED";//you should assign it correctly based on unit

        double inches = 0;
        double feet = 0;
        double yards = 0;
        double miles = 0;

        /* your code starts */



        /* your code Ends */

        System.out.println("The measurement given was " + measurement + " " + unitName);
        System.out.println("The measurement in inch is :" + inches);
        System.out.println("The measurement in feet is :" + feet);
        System.out.println("The measurement in yards is :" + yards);
        System.out.println("The measurement in miles is :" + miles);

    }
}
