package de.newspicel.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Rover extends Actor {

    private World world;


    public Rover(World world, int x, int y) {
        world.addObject(this, x, y);
        setImage("images/rover.png");
    }

    public void fahre() {
        int posX = getX();
        int posY = getY();

        if (huegelVorhanden("vorne")) {
            System.out.println("Zu steil!");
        } else if (getRotation() == 270 && getY() == 1) {
            System.out.println("Ich kann mich nicht bewegen");
        } else {
            move(1);
            Greenfoot.delay(1);
        }

        if (posX == getX() && posY == getY() && !huegelVorhanden("vorne")) {
            System.out.println("Ich kann mich nicht bewegen");
        }
    }

    public void drehe(String richtung) {
        if (richtung.equals("rechts")) {
            setRotation(getRotation() + 90);
        } else if (richtung.equals("links")) {
            setRotation(getRotation() - 90);
        } else {
            System.out.println("Befehl nicht korrekt!");
        }
    }

    public boolean gesteinVorhanden() {
        if (getOneIntersectingObject(Gestein.class) != null) {
            System.out.println("Gestein gefunden!");
            return true;

        }

        return false;
    }

    public boolean huegelVorhanden(String richtung) {
        int rot = getRotation();

        if (richtung.equals("vorne") && rot == 0 || richtung.equals("rechts") && rot == 270 || richtung.equals("links") && rot == 90) {
            if (getOneObjectAtOffset(1, 0, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(1, 0, Huegel.class)).getSteigung() > 30) {
                return true;
            }
        }

        if (richtung.equals("vorne") && rot == 180 || richtung.equals("rechts") && rot == 90 || richtung.equals("links") && rot == 270) {
            if (getOneObjectAtOffset(-1, 0, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(-1, 0, Huegel.class)).getSteigung() > 30) {
                return true;
            }
        }

        if (richtung.equals("vorne") && rot == 90 || richtung.equals("rechts") && rot == 0 || richtung.equals("links") && rot == 180) {
            if (getOneObjectAtOffset(0, 1, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(0, 1, Huegel.class)).getSteigung() > 30) {
                return true;
            }

        }

        if (richtung.equals("vorne") && rot == 270 || richtung.equals("rechts") && rot == 180 || richtung.equals("links") && rot == 0) {
            if (getOneObjectAtOffset(0, -1, Huegel.class) != null && ((Huegel) getOneObjectAtOffset(0, -1, Huegel.class)).getSteigung() > 30) {
                return true;
            }

        }

        if (!richtung.equals("vorne") && !richtung.equals("links") && !richtung.equals("rechts")) {
            System.out.println("Befehl nicht korrekt!");
        }

        return false;
    }


    public void analysiereGestein() {
        if (gesteinVorhanden()) {
            System.out.println("Gestein untersucht! Wassergehalt ist " + ((Gestein) getOneIntersectingObject(Gestein.class)).getWassergehalt() + "%.");
            Greenfoot.delay(1);
            removeTouching(Gestein.class);
        } else {
            System.out.println("Hier ist kein Gestein");
        }
    }


    public void setzeMarke() {
        getWorld().addObject(new Marke(), getX(), getY());
    }


    public boolean markeVorhanden() {
        return getOneIntersectingObject(Marke.class) != null;
    }

    public void entferneMarke() {
        if (markeVorhanden()) {
            removeTouching(Marke.class);
        }
    }

    @Override
    public World getWorld() {
        return world;
    }
}
