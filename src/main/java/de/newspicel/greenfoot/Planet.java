package de.newspicel.greenfoot;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class Planet extends World {
    private static int zellenGroesse = 50;

    /**
     * Erschaffe eine Welt mit 15 * 12 Zellen.
     */
    public Planet() {
        super(16, 12, zellenGroesse);
        setBackground("images/boden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(20);
        setupDefaultWorld();
    }

    private void setupDefaultWorld() {
        Rover rover = new Rover(this, 1, 1);
    }


}
