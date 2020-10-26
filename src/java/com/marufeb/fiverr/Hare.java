package com.marufeb.fiverr;

public class Hare extends Projectile{
    public Hare(String name, float velocity, int angle, int height) {
        super(name, velocity, angle, height);
    }

    public void burnFuel() {
        super.setHeight((int)(super.getHeight()+11));
    }
}
