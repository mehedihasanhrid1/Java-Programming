import java.util.Scanner;

public class VolumeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape to calculate its volume:");
        System.out.println("1. Cube");
        System.out.println("2. Sphere");
        System.out.println("3. Cylinder");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: 
                System.out.print("Enter the side length of the cube: ");
                double side = scanner.nextDouble();
                double cubeVolume = calculateCubeVolume(side);
                System.out.println("The volume of the cube is: " + cubeVolume);
                break;

            case 2: 
                System.out.print("Enter the radius of the sphere: ");
                double radius = scanner.nextDouble();
                double sphereVolume = calculateSphereVolume(radius);
                System.out.println("The volume of the sphere is: " + sphereVolume);
                break;

            case 3:
                System.out.print("Enter the radius of the cylinder: ");
                double baseRadius = scanner.nextDouble();
                System.out.print("Enter the height of the cylinder: ");
                double height = scanner.nextDouble();
                double cylinderVolume = calculateCylinderVolume(baseRadius, height);
                System.out.println("The volume of the cylinder is: " + cylinderVolume);
                break;

            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
        }
    }

    public static double calculateCubeVolume(double side) {
        return Math.pow(side, 3);
    }

    public static double calculateSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public static double calculateCylinderVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
