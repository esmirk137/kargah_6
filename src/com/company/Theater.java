package com.company;

/**
 * This class represent collection of seats
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since April.16.2020
 */
public class Theater {
    private Row[] rows;

    /**
     * This is constructor of Row class.
     * @param numberOfRow is number of row in cinema
     */
    public Theater(int numberOfRow){
        rows=new Row[numberOfRow];
    }

    /**
     * This method check seats for booking
     * @param row is number of row of seats in cinema
     * @param numberOfASeat is number of a seats that user want to book
     * @return return answer as a boolean
     */
    public boolean checkSeat(int row, int... numberOfASeat){
        for(int i: numberOfASeat)
            if(rows[row].getSeats()[i] == -1)
                return false;
        return true;
    }

    /**
     * get the rows of theater.
     * @return rows field
     */
    public Row[] getRows() {
        return rows;
    }
}
