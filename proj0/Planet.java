public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos,
                  double xxVel, double yyVel,
                  double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet planet) {
        this.xxPos = planet.xxPos;
        this.yyPos = planet.yyPos;
        this.xxVel = planet.xxVel;
        this.yyVel = planet.yyVel;
        this.mass = planet.mass;
        this.imgFileName = planet.imgFileName;
    }

    public double calcDistance(Planet other) {
        return Math.sqrt(Math.pow(xxPos - other.xxPos, 2) + Math.pow(yyPos - other.yyPos, 2));
    }

    public double calcForceExertedBy(Planet other) {
        return G * mass * other.mass / Math.pow(calcDistance(other), 2);
    }

    public double calcForceExertedByX(Planet other) {
        double dx = other.xxPos - xxPos;
        double fx = calcForceExertedBy(other) * dx / calcDistance(other);
        return fx;
    }

    public double calcForceExertedByY(Planet other) {
        double dy = other.yyPos - yyPos;
        double fy = calcForceExertedBy(other) * dy / calcDistance(other);
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceByX = 0;
        for (Planet planet : planets) {
            if (this.equals(planet)) continue;
            netForceByX += calcForceExertedByX(planet);
        }
        return netForceByX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceByY = 0;
        for (Planet planet : planets) {
            if (this.equals(planet)) continue;
            netForceByY += calcForceExertedByY(planet);
        }
        return netForceByY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}