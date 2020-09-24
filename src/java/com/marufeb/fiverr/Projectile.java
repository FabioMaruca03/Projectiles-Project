package com.marufeb.fiverr;

public class Projectile {
    private final String name;
    private int velocity;
    private int angle;
    private int height;
    private float x = 0 ;
    private float timing = 0.5f;
    private float currentTime = 0;

    public Projectile(String name, int velocity, int angle, int height) {
        this.name = name;
        setVelocity(velocity);
        setAngle(angle);
        setHeight(height);
    }

    public boolean moveUntilHit(int ground) {
        x = (float) (velocity * timing * Math.cos(Math.toRadians(angle)) + x);
        height -= (int) (velocity * timing * Math.sin(Math.toRadians(angle)) - (0.5 * 9.81 * Math.pow(timing, 2)));
        currentTime += timing;
        return height <= ground;
    }

    public float distance(Projectile other) {
        return Math.abs(other.x-getX());
    }

    //-----| GETTERS AND SETTERS |-----//


    public float getCurrentTime() {
        return currentTime;
    }

    public float getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public float getTiming() {
        return timing;
    }

    public void setTiming(float timing) {
        this.timing = timing;
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
