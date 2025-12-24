public class Momas {

    static class Particle {
        double x, y;
        double v;
        boolean detached = false;

        double dirX, dirY;
        public Particle(double startX, double v) {
            this.x = startX;
            this.y = x * x;
            this.v = v;
        }

        public void update() {

            if (!detached) {
                x += v;
                y = x * x;

                if ((v > 0 && x >= 2) || (v < 0 && x <= 2)) {
                    detached = true;

                    if (v > 0) {
                        dirX = 1;
                        dirY = 4;
                    } else {
                        dirX = -1;
                        dirY = -4;
                    }
                }

            } else {
                x += dirX;
                y += dirY;
            }
        }
    }

    public static void main(String[] args) {

        Particle p1 = new Particle(5, -1);
        Particle p2 = new Particle(-3, 1);
        Particle p3 = new Particle(-7, 1);

        int totalTime = 10;

        for (int t = 0; t <= totalTime; t++) {

            System.out.println("t = " + t);

            System.out.printf("P1: (%.2f , %.2f)\n", p1.x, p1.y);
            System.out.printf("P2: (%.2f , %.2f)\n", p2.x, p2.y);
            System.out.printf("P3: (%.2f , %.2f)\n", p3.x, p3.y);

            System.out.println("----------------------");

            p1.update();
            p2.update();
            p3.update();
        }
    }
}
