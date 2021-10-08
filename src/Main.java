import java.awt.*;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) throws Exception {
        Curve curve = randomCurve(new Point(0, 1000), new Point(2000, 1000), 10);
        Robot robot = new Robot();

        //Wohoo wohoo = new Wohoo();

        for (double t = 0.01; t <= 1; t += 0.001) {
            Point point = curve.get(t);
            //wohoo.draw((int) point.x() + random.nextInt() % 2, (int) point.y() + random.nextInt() % 2);
            robot.mouseMove((int) point.x() + random.nextInt() % 2, (int) point.y() + random.nextInt() % 2);
            Thread.sleep((int) (2 * (1 - random.nextFloat())));
        }
    }

    private static Curve randomCurve(Point start, Point end, int n) {
        Point[] points = new Point[n];

        Point step = new Point((end.x() - start.x()) / n, (end.y() - start.y()) / n);

        points[0] = start;

        for (int i = 1; i < n - 1; i++) {
            points[i] = new Point(start.x() + step.x() * i + random.nextInt() % 200, start.y() + step.y() * i + random.nextInt() % 200);
        }

        points[points.length - 1] = end;

        return new Curve(points);
    }
}
