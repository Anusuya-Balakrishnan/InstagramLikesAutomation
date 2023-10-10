 class CustomPoint3D {
    private double x;
    private double y;
    private double z;

    public CustomPoint3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}

public class CubeRotation3DProgram {
    public static void main(String[] args) {
        // Define the cube's vertices in 3D space using CustomPoint3D
        CustomPoint3D[] cubeVertices = new CustomPoint3D[]{
            new CustomPoint3D(0, 0, 0),
            new CustomPoint3D(1, 0, 0),
            new CustomPoint3D(1, 1, 0),
            new CustomPoint3D(0, 1, 0),
            new CustomPoint3D(0, 0, 1),
            new CustomPoint3D(1, 0, 1),
            new CustomPoint3D(1, 1, 1),
            new CustomPoint3D(0, 1, 1)
        };

        // Arbitrary point for rotation
        CustomPoint3D rotationPoint = new CustomPoint3D(0.5, 0.5, 0.5);

        // Rotation angle in radians (e.g., 45 degrees)
        double angleInRadians = Math.toRadians(45);

        // Display rotation information
        System.out.println("Rotation Angle: " + Math.toDegrees(angleInRadians) + " degrees");
        System.out.println("Principal Axis of Rotation: Z-axis");
        System.out.println("Arbitrary Point for Rotation: " + rotationPoint);

        // Perform 3D rotation
        for (int i = 0; i < cubeVertices.length; i++) {
            double x = cubeVertices[i].getX() - rotationPoint.getX();
            double y = cubeVertices[i].getY() - rotationPoint.getY();
            double xNew = x * Math.cos(angleInRadians) - y * Math.sin(angleInRadians);
            double yNew = x * Math.sin(angleInRadians) + y * Math.cos(angleInRadians);
            cubeVertices[i].setX(xNew + rotationPoint.getX());
            cubeVertices[i].setY(yNew + rotationPoint.getY());
        }

        // Display the coordinates of the cube's vertices before and after rotation
        System.out.println("Coordinates of Cube's Vertices Before Rotation:");
        displayVertices(cubeVertices);

        // Display the result after rotation
        System.out.println("Coordinates of Cube's Vertices After Rotation:");
        displayVertices(cubeVertices);
    }

    private static void displayVertices(CustomPoint3D[] vertices) {
        for (int i = 0; i < vertices.length; i++) {
            System.out.println("Vertex " + (i + 1) + ": (" + vertices[i].getX() + ", " + vertices[i].getY() + ", " + vertices[i].getZ() + ")");
        }
    }
}
