package de.newspicel.greenfoot;

import de.newspicel.greenfoot.enums.Preposition;
import de.newspicel.greenfoot.enums.RadioFrequency;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public class BetterRover extends Actor {

    private final Planet world;


    private RadioFrequency radioFrequency = RadioFrequency.DEFAULT;
    private int drivenDistance = 0;
    private String name;

    public BetterRover(Planet world, int x, int y, RadioFrequency radioFrequency, String name) {
        this.world = world;
        this.radioFrequency = radioFrequency;
        this.name = name;
        world.addObject(this, x, y);
        setImage("images/rover.png");
    }

    public BetterRover(Planet world, int x, int y) {
        this.world = world;
        world.addObject(this, x, y);
        setImage("images/rover.png");
    }

    public int measureTemperature() {
        return world.getLessonRoverMethods().getTemperature(world.getTime());
    }

    public void drive() {
        if (!hillExist(Preposition.FRONT)) {
            move(1);
            drivenDistance++;
            Greenfoot.delay(1);
        }
    }

    public void drive(int length) {
        for (int i = 0; i < length; i++) {
            drive();
        }
    }

    public void rotate(Preposition preposition) {
        if (preposition.equals(Preposition.RIGHT)) {
            setRotation(getRotation() + 90);
        } else if (preposition.equals(Preposition.LEFT)) {
            setRotation(getRotation() - 90);
        } else {
            System.out.println("Befehl nicht korrekt!");
        }
    }

    public void turnAround() {
        setRotation(getRotation() + 180);
    }

    public boolean stoneAvailability() {
        return getOneIntersectingObject(Gestein.class) != null;
    }

    public boolean hillExist(Preposition preposition) {
        int rot = getRotation();

        if (preposition.equals(Preposition.FRONT) && rot == 0 || preposition.equals(Preposition.RIGHT) && rot == 270 || preposition.equals(Preposition.LEFT) && rot == 90) {
            if (getOneObjectAtOffset(1, 0, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(1, 0, Huegel.class)).getSteigung() > 30) {
                return true;
            }
        }

        if (preposition.equals(Preposition.FRONT) && rot == 180 || preposition.equals(Preposition.RIGHT) && rot == 90 || preposition.equals(Preposition.LEFT) && rot == 270) {
            if (getOneObjectAtOffset(-1, 0, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(-1, 0, Huegel.class)).getSteigung() > 30) {
                return true;
            }
        }

        if (preposition.equals(Preposition.FRONT) && rot == 90 || preposition.equals(Preposition.RIGHT) && rot == 0 || preposition.equals(Preposition.LEFT) && rot == 180) {
            if (getOneObjectAtOffset(0, 1, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(0, 1, Huegel.class)).getSteigung() > 30) {
                return true;
            }
        }

        if (preposition.equals(Preposition.FRONT) && rot == 270 || preposition.equals(Preposition.RIGHT) && rot == 180 || preposition.equals(Preposition.LEFT) && rot == 0) {
            if (getOneObjectAtOffset(0, -1, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(0, -1, Huegel.class)).getSteigung() > 30) {
                return true;
            }

        }

        if (preposition.equals(Preposition.BACK)) {
            System.out.println("You can´t look back!");
        }

        return false;
    }


    public void analyzingStone() {
        if (stoneAvailability()) {
            System.out.println("Gestein untersucht! Wassergehalt ist " + ((Gestein) getOneIntersectingObject(Gestein.class)).getWassergehalt() + "%.");
            Greenfoot.delay(1);
            removeTouching(Gestein.class);
        } else {
            System.out.println("Hier ist kein Gestein");
        }
    }


    public void setMark() {
        getWorld().addObject(new Marke(), getX(), getY());
    }


    public boolean markExist() {
        return getOneIntersectingObject(Marke.class) != null;
    }

    public void removeMark() {
        if (markExist()) {
            removeTouching(Marke.class);
        }
    }

    @Override
    public World getWorld() {
        return world;
    }

    public Planet getPlanet() {
        return world;
    }

    public String getName() {
        return name;
    }

    public RadioFrequency getRadioFrequency() {
        return radioFrequency;
    }

    public void setRadioFrequency(RadioFrequency radioFrequency) {
        this.radioFrequency = radioFrequency;
    }
}
