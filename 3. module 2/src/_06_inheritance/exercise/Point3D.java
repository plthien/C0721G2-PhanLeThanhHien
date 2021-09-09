package _06_inheritance.exercise;

public class Point3D extends Point2D {
    private float z = 0.0f;
    private float[] arr = new float[3];

    public Point3D(){

    }

    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;

    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;
    }

    public float[] getXYZ(){
        return this.arr;
    }

    @Override
    public String toString() {
        return "Point3D " + "(" + super.getX() + "," +super.getY() + "," +this.getZ() + ")" ;
    }
}
