package Polygon;

public class Polygon {
    public int count;

    public double[] xs;

    public double[] ys;

    public Polygon(double[]... pts) {
        xs = new double[pts.length];
        ys = new double[pts.length];
        for (int i = 0; i < pts.length; i++) {
            xs[i] = pts[i][0];
            ys[i] = pts[i][1];
        }
        count = pts.length;
    }

    public Polygon(Point... pts) {
        xs = new double[pts.length];
        ys = new double[pts.length];
        for (int i = 0; i < pts.length; i++) {
            xs[i] = pts[i].getX();
            ys[i] = pts[i].getY();
        }
        count = pts.length;
    }

    public Polygon(double[] xs, double[] ys, int count) {
        this.xs = xs;
        this.ys = ys;
        this.count = count;
    }

    public Polygon(double[] xs, double[] ys) {
        this.xs = xs;
        this.ys = ys;
        this.count = xs.length;
    }

    public boolean inside(double x, double y) {
        int i, j = count - 1;
        boolean odd = false;
        for (i = 0; i < count; i++) {
            if ((ys[i] < y && ys[j] >= y || ys[j] < y && ys[i] >= y) && (xs[i] <= x || xs[j] <= x)) {
                if (xs[i] + (y - ys[i]) / (ys[j] - ys[i]) * (xs[j] - xs[i]) < x) {
                    odd = !odd;
                }
            }
            j = i;
        }
        return odd;
    }
}
