package com.marufeb.fiverr;

import java.util.Random;

public class Manager {
    private static final Random randomizer = new Random(System.nanoTime());

    private void evaluate() {
        Projectile[] projectiles = new Projectile[]{
                new Hare("HARE",
                        randomizer.nextInt(50) + 70,
                        randomizer.nextInt(90),
                        randomizer.nextInt(600) + 400
                ),
                new Hound("HOUND",
                        11.3f,
                        randomizer.nextInt(90),
                        600
                )
        };

        for (int i = 0; i < 2; i++) {
            System.out.println("\n\nProjectile name: "+projectiles[i].getName());

            System.out.println("----------------------------------------------------------\n");
            System.out.println("| INITIAL VELOCITY |   INITIAL ANGLE  |  INITIAL HEIGHT  |");
            System.out.printf("\n| %10.2f m/s   |  %10d    |  %10d   |", projectiles[i].getVelocity(), projectiles[i].getAngle(),projectiles[i].getHeight());
            System.out.println("\n----------------------------------------------------------\n");

            System.out.println("|\tX      |\tY\t|\tTIME\t|");
            do {
                if (i == 1 && projectiles[0].distance(projectiles[1]) >= 7 && projectiles[0].distanceToTheGround() <=50 && projectiles[0].getHitPoint() < Projectile.getMaxW())
                    ((Hare) projectiles[0]).burnFuel();
                System.out.printf("\n| %10.2f   |  %10d    |  %10.2f   |", projectiles[i].getX(),projectiles[i].getHeight(),projectiles[i].getCurrentTime());
            } while (!projectiles[i].moveUntilHit(i==0));


        }
        System.out.println("\nDistance between projectiles: "+projectiles[0].distance(projectiles[1]));
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
        m.evaluate();
    }

}
