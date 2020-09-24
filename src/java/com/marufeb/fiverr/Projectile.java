package com.marufeb.fiverr;

import java.util.Random;

public class Projectile {
    private int velocity;
    private int angle;
    private int height;

    public Projectile(int velocity, int angle, int height) {
        setVelocity(velocity);
        setAngle(angle);
        setHeight(height);
    }

    public boolean modeUntilHit() {
        // todo: make movement, true if hits the ground
        return true;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
