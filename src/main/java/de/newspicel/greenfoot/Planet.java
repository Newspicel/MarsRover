package de.newspicel.greenfoot;

import de.newspicel.greenfoot.enums.Preposition;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Planet extends World {

    private LessonRoverMethods lessonRoverMethods;

    private BetterRover betterRover;


    public Planet() {
        super(16, 12, 50);
        setBackground("images/boden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(20);
        this.lessonRoverMethods = new LessonRoverMethods();
    }

    public void act() {
        
        setupDefaultWorld();
        Greenfoot.delay(1);
        //Edit here
        betterRover.drive(100);
    }

    public void setupDefaultWorld() {
        deleteRover();
        this.betterRover = new BetterRover(this, 0, 0);

    }

    public void deleteRover() {
        removeObjects(getObjects(BetterRover.class));
        removeObjects(getObjects(Rover.class));
    }

}
