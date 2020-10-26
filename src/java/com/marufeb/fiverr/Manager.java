package com.marufeb.fiverr;

import java.util.Random;

public class Manager {
    private Projectile[] projectiles;
    private static Random randomizer = new Random(System.nanoTime());

    private void evaluate(int ground) {
        projectiles = new Projectile[] {
                new Hare("HARE",
                        randomizer.nextInt(50)+70,
                        randomizer.nextInt(90),
                        randomizer.nextInt(600)+400
                ),
                new Hound("HOUND",
                        11.3f,
                        randomizer.nextInt(90),
                        600
                )
        };

        for (int i = 0; i < 2; i++) {
            System.out.println("Projectile name: "+projectiles[i].getName());

            System.out.println("----------------------------------------------------------\n");
            System.out.println("| INITIAL VELOCITY |   INITIAL ANGLE  |  INITIAL HEIGHT  |");
            System.out.println("|\t"+projectiles[i].getVelocity()+" m/s\t|\t"+
                    projectiles[i].getAngle()+"\t|\t"+projectiles[i].getHeight()+"\t|");
            System.out.println("----------------------------------------------------------\n");

            System.out.println("|\tX\t|\tY\t|\tTIME\t|");
            do {
                System.out.println("|\t"+projectiles[i].getX()+"\t|\t"+
                        projectiles[i].getHeight()+"\t|\t"+projectiles[i].getCurrentTime());

            } while (!projectiles[i].moveUntilHit(ground, i==0));

        }
        System.out.println("Distance between projectiles: "+projectiles[0].distance(projectiles[1]));
        if (projectiles[0].distance(projectiles[1]) >= 7) {
            System.out.println("Hare won!");
        } else System.out.println("Hound won!");
    }

    public static void main(String[] args) {
        Projectile.setMaxH(2500);
        Projectile.setMaxW(2000);

        int[] plateaus = new int[20];
        for (int i = 0; i < plateaus.length; i++) plateaus[i] = randomizer.nextInt(250)+100;
        Projectile.setPlateaus(plateaus);

        Manager m = new Manager();
        m.evaluate(0);
        m.evaluate(120);
    }

}
