import java.util.Scanner;

public class Hombre {
    private String nombre;

    public Hombre(String nombre) {
        this.nombre = nombre;
    }

    public void jugarConRobot(Robot robot) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int pasosAvanzar;
        int pasosRetroceder;

        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Avanzar una cantidad de pasos");
            System.out.println("2. Retroceder una cantidad de pasos");
            System.out.println("3. Ver energía actual");
            System.out.println("4. Dormir al robot (finaliza sesión)");
            System.out.println("5. Despertar al robot");
            System.out.println("6. Recargar batería");
            System.out.println("7. Ver estado del robot (dormido o despierto)");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos pasos quieres avanzar?: ");
                    pasosAvanzar = scanner.nextInt();
                    robot.avanzar(pasosAvanzar);
                    break;
                case 2:
                    System.out.print("¿Cuántos pasos quieres retroceder?: ");
                    pasosRetroceder = scanner.nextInt();
                    robot.retroceder(pasosRetroceder);
                    break;
                case 3:
                    System.out.println("Energía actual del robot: " + robot.energiaActual() + " unidades.");
                    break;
                case 4:
                    if (robot.estaDormido()) {
                        System.out.println("¡El robot ya está dormido!");
                    } else {
                        robot.dormir();
                    }
                    break;
                case 5:
                    if (!robot.estaDormido()) {
                        System.out.println("¡El robot ya está despierto!");
                    } else {
                        robot.despertar();
                    }
                    break;
                case 6:
                    robot.recargar();
                    break;
                case 7:
                    if (robot.estaDormido()) {
                        System.out.println("El robot está DORMIDO.");
                    } else {
                        System.out.println("El robot está DESPIERTO.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (!robot.estaDormido() || opcion == 7); // Si elige opción 7 (ver estado), sigue en el menú
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
