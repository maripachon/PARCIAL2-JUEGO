public class Robot {
    private Bateria bateria;
    private boolean dormido;

    public Robot() {
        this.bateria = new Bateria(1000); // Carga inicial de la batería
        this.dormido = false;
    }

    public void avanzar(int pasos) {
        if (bateriaVacia()) {
            System.out.println("La batería está vacía. No se puede avanzar.");
            return;
        }
        if (dormido) {
            System.out.println("No puedes avanzar, el robot está dormido.");
            return;
        }
        // Cada 100 pasos consume 10 unidades de energía
        int energiaGastada = (pasos / 100) * 10;
        bateria.setCarga(bateria.getCarga() - energiaGastada);

        if (bateria.getCarga() < 0) {
            bateria.setCarga(0); // Evita que la carga sea negativa
        }

        System.out.println("El robot avanzó " + pasos + " pasos. ");
    }

    public void retroceder(int pasos) {
        if (bateriaVacia()) {
            System.out.println("La batería está vacía. No se puede retroceder.");
            return;
        }
        if (dormido) {
            System.out.println("No puedes retroceder, el robot está dormido.");
            return;
        }
        // Cada 100 pasos retrocedidos consume 10 unidades de energía
        int energiaGastada = (pasos / 100) * 10;
        bateria.setCarga(bateria.getCarga() - energiaGastada);

        if (bateria.getCarga() < 0) {
            bateria.setCarga(0); // Evita que la carga sea negativa
        }

        System.out.println("El robot retrocedió " + pasos + " pasos. ");
    }

    public void dormir() {
        dormido = true;
        System.out.println("El robot ha sido dormido.");
    }

    public void despertar() {
        dormido = false;
        System.out.println("El robot ha sido despertado.");
    }

    public void recargar() {
        bateria.setCarga(1000);
        System.out.println("La batería ha sido recargada.");
    }

    public boolean bateriaLlena() {
        return bateria.getCarga() == 1000;
    }

    public boolean bateriaVacia() {
        return bateria.getCarga() == 0;
    }

    public int energiaActual() {
        return bateria.getCarga();
    }

    public boolean estaDormido() {
        return dormido;
    }
}
