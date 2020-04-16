package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * This class represent a show of cinema.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since April.16.2020
 */
public class Show {
    private String name;
    private int day; //number of day in present month
    private String time; // time of showing of the form hh:mm
    private Theater theater;
    private int capacity;
    private int remainingSeat;
    private ArrayList<Integer> trackingCodes;

    /**
     * This is a constructor of Show class and allocate or filed.
     * @param name is name of show
     * @param day is an integer as day showing
     * @param time is time of showing
     * @param capacity is capacity of this showing
     */
    public Show(String name, int day, String time, int capacity){
        this.name=name;
        this.day=day;
        this.time=time;
        this.capacity=capacity;
        remainingSeat=0;
        trackingCodes=new ArrayList<>();
    }

    /**
     * This method show detail of a this show.
     */
    public void printDetail(){
        System.out.print("name: "+name+"\n day: "+day+"\n time: "+time+ "\n capacity of cinema: "+capacity+
               "\n remaining Seat: "+remainingSeat);
    }

    /**
     * This method check a code was repeated or not.
     * @return answer sa boolean
     */
    private boolean iSARepeatedTackingCode(int code){
        for(int code1: trackingCodes)
            if(code1==code)
                return true;
        return false;
    }

    /**
     * This method book seat of show to user.
     * @param row is number of row of seats in cinema
     * @param numberOfASeat is number of a seat in a row
     */
    public void bookSeats(int row, int... numberOfASeat){
        if(theater.checkSeat(row,numberOfASeat)) {
            int trackingCode;
            Random random=new Random();
            do{
                trackingCode=random.nextInt();
            }while (iSARepeatedTackingCode(trackingCode));
            for (int i : numberOfASeat)
                theater.getRows()[row].getSeats()[i] = trackingCode;
            trackingCodes.add(trackingCode);
            System.out.print("Booking process done. your tracking code is "+ trackingCode);
            return;
        }
        System.out.print("some of this seats was booked in the past.");
    }

    /**
     * This is override of equals method for this class and compare this show with another show
     * @param o is a object for compare
     * @return answer as a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return day == show.day &&
                capacity == show.capacity &&
                remainingSeat == show.remainingSeat &&
                Objects.equals(name, show.name) &&
                Objects.equals(time, show.time) &&
                Objects.equals(theater, show.theater) &&
                Objects.equals(trackingCodes, show.trackingCodes);
    }

    /**
     * This method compare hash code of two show
     * @return answer as a boolean
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, day, time, theater, capacity, remainingSeat, trackingCodes);
    }

    /**
     * This method compare hash code of two show
     * @return answer as a boolean
     */
    public String getTime() {
        return time;
    }

    /**
     * get the name of show.
     * @return name field
     */
    public String getName() {
        return name;
    }

    /**
     * get the day of show.
     * @return day field
     */
    public int getDay() {
        return day;
    }

    /**
     * get the theater of show.
     * @return theater field
     */
    public Theater getTheater() {
        return theater;
    }
}
