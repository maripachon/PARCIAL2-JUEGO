import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Hombre hombre1 = new Hombre("Carlos");

        // Hombre 1 juega con el robot
        hombre1.jugarConRobot(robot);

        // Hombre 2 (Luis) toma el control del robot
        if (robot.estaDormido()) {
            System.out.println("\n" + "Luis toma el control del robot");
            robot.estaDormido();
        }

        hombre1.jugarConRobot(robot);

        System.out.println("\nFin del programa.");
    }
}
