package org.sdu.mikni23.objects;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

/*
 * Base entity
 */
public class EntityObject implements Serializable {
    
    /*
     * Entity unique id
     */
    private final UUID id = UUID.randomUUID();

    /*
     * Polygon to draw
     */
    private double[] polygonCoordinates;


    /*
     * Position and rotation
     */
    private double x;
    private double y;
    private double r;


    /*
     * hitbox radius
     */
    private float radius;


    public EntityObject() {}

    public EntityObject(double[] polygonCoordinates, double x, double y, double r, float radius) {
        this.polygonCoordinates = polygonCoordinates;
        this.x = x;
        this.y = y;
        this.r = r;
        this.radius = radius;
    }


    public UUID getId() {
        return id;
    }


    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }


    public void setPolygonCoordinates(double[] polygonCoordinates) {
        this.polygonCoordinates = polygonCoordinates;
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }


    public double getR() {
        return r;
    }


    public void setR(double r) {
        this.r = r;
    }


    public float getRadius() {
        return radius;
    }


    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", polygonCoordinates=" + Arrays.toString(polygonCoordinates) + ", x=" + x + ", y="
                + y + ", r=" + r + ", radius=" + radius + "]";
    }

}
