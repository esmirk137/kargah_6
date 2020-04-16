package com.company;

/**
 * This class represent row of cinema.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since April.16.2020
 */
public class Row {
    private int[] seats;

    /**
     * This is constructor of Row class.
     * @param numberOfSeats is number of seat in a row
     */
    public Row(int numberOfSeats){
        seats=new int[numberOfSeats];
        for(int i=0; i<numberOfSeats; i++)
            seats[i]=-1;
    }

    /**
     * get the seats of a row.
     * @return seats field
     */
    public int[] getSeats() {
        return seats;
    }
}
