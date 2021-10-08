public record Curve(Point... points) {
    public Point get(double t) {
        int n = points.length - 1;
        double x = 0, y = 0;
        for (int i = 0; i < points.length; i++) {
            double factor = bin(n, i) * Math.pow(1 - t, n - i) * Math.pow(t, i);
            x += factor * points[i].x();
            y += factor * points[i].y();
        }

        return new Point(x, y);
    }

    private long bin(int n, int i) {
        if ((n == i) || (i == 0))
            return 1;
        else
            return bin(n - 1, i) + bin(n - 1, i - 1);
    }

}
