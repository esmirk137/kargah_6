package com.company;

import java.util.ArrayList;

/**
 * This class represent a system for booking cinema tickets.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since April.16.2020
 */
public class CinemaBookingSystem {
    private ArrayList<Show> shows;

    /**
     * This method search a show with name and date as input.
     * @param nameOfShow is name of show
     * @param day is day that you want to know the show exist or not
     */
    public void searchAShowInADay(String nameOfShow, int day){
        boolean flag=true;
        for(Show show: shows)
            if(show.getDay()==day || show.getName().equals(nameOfShow)){
                System.out.print(show.getTime());
                flag=false;
            }
        if(flag)
            System.out.print("There isn't this show in this day of present month.");
    }

    /**
     * This method show detail of a show.
     */
    public void printDetailOfAShow(Show show){
        for(Show show1: shows)
            if(show1.equals(show)) {
                show1.printDetail();
                return;
            }
        System.out.print("There is not such show in list.");
    }

    /**
     * This method check input seats for a show and if was empty book it to user
     * @param show is show that we wanna book its seats
     * @param row is number of row of seats in cinema
     * @param numberOfSeats is number of seat that user want to book
     */
    public void checkSeatsForBookingAndBooking(Show show, int row, int[] numberOfSeats){
        for (Show value : shows)
            if (value.equals(show))
                value.bookSeats(row, numberOfSeats);
    }

    /**
     * Find seat of a user in a show with its tracking code
     * @param show is show that you wanna search in it
     * @param trackingCode is tracking code of user
     */
    public void findSeats(Show show, int trackingCode){
        boolean first=true;
        for(Show show1: shows)
            if(show1.equals(show))
                for(Row row: show1.getTheater().getRows())
                    for(int i: row.getSeats())
                        if(i==trackingCode){
                            if(first)
                                System.out.print("Your seats are:");
                            System.out.print("number of row is: "+ row+"\t number of seat is: "+i);
                            first=false;
                        }

        if(first)
            System.out.print("You does not have seat in this show.");
    }

    /**
     * this method remove a book
     * @param show is show that you wanna search in it
     * @param trackingCode is tracking code of user
     */
    public void removeBook(Show show, int trackingCode){
        for(Show show1: shows)
            if(show1.equals(show))
                for(Row row: show1.getTheater().getRows())
                    for(int i=0; i<row.getSeats().length; i++)
                        if(row.getSeats()[i]==trackingCode)
                            row.getSeats()[i]=-1;
    }

}
