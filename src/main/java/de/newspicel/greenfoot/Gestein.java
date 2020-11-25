package de.newspicel.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Write a description of class de.newspicel.greenfoot.Gestein here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gestein extends Actor {
    private String farbe;
    private int wassergehalt;


    public Gestein() {
        wassergehalt = Greenfoot.getRandomNumber(20);

        if (Greenfoot.getRandomNumber(2) == 0) {
            farbe = "rot";
            setImage("images/gesteinRot.png");
        } else {
            farbe = "blau";
            setImage("images/gesteinBlau.png");
        }
    }

    public int getWassergehalt() {
        return wassergehalt;
    }

}
