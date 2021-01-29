package prueba;

public class MasHilos {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");

        MiHilo miHilo1 = MiHilo.crearYComenzar("#1");
        MiHilo miHilo2 = MiHilo.crearYComenzar("#2");
        MiHilo miHilo3 = MiHilo.crearYComenzar("#3");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Hilo principal interrumpido.");
            }
        }
        System.out.println("Hilo principal finalizado");
    }
}