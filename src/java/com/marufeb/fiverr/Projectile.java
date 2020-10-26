package com.marufeb.fiverr;

public abstract class Projectile {
    private final String name;
    private float velocity;
    private int angle;
    private int height;
    private int iHeight;
    private float x = 0 ;
    private float timing = 0.5f;
    private float currentTime = 0;
    private static int MAX_H = 0;
    private static int MAX_W = 0;
    private static int[] plateaus;

    public Projectile(String name, float velocity, int angle, int height) {
        this.name = name;
        setVelocity(velocity);
        setAngle(angle);
        iHeight = height;
        setHeight(height);
    }

    public boolean moveUntilHit(boolean augment) {
        x += (float) (velocity * timing * Math.cos(Math.toRadians(angle))) + (augment&&currentTime%1.5f==0?10:0);
        height -= (int) (velocity * timing * Math.sin(Math.toRadians(angle)) - (0.5 * 9.81 * Math.pow(timing, 2)));
        currentTime += timing;
        return height <= plateaus[(int) (x/100)] || height >= MAX_H || x >= MAX_W;
    }

    public float distance(Projectile other) {
        return Math.abs(Math.max(other.getHitPoint(), getHitPoint()) - Math.min(other.getHitPoint(), getHitPoint()));
    }

    public float distanceToTheGround() {
        return height-plateaus[(int) x/100];
    }

    //-----| GETTERS AND SETTERS |-----//


    public float getCurrentTime() {
        return currentTime;
    }

    public float getHitPoint() {
        return (float) (velocity * (2 * velocity * Math.sin(Math.toRadians(angle)))/9.81 * Math.cos(Math.toRadians(angle)));
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

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
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

    public static int getMaxH() {
        return MAX_H;
    }

    public static void setMaxH(int maxH) {
        MAX_H = maxH;
    }

    public static int getMaxW() {
        return MAX_W;
    }

    public static void setMaxW(int maxW) {
        MAX_W = maxW;
    }

    public static int[] getPlateaus() {
        return plateaus;
    }

    public static void setPlateaus(int[] plateaus) {
        Projectile.plateaus = plateaus;
    }
}
