import static java.lang.Math.abs;
import static java.util.stream.IntStream.rangeClosed;
import java.util.Scanner;

public class Main {

    public static int analizadorDeAlertas(String[] sensores, int x, int y) {
        int total = 0;

            for (int x1 = x - 1; x1 <= x + 1; x1++) {
            for (int y1 = y - 1; y1 <= y + 1; y1++) {
                for (String sensor : sensores) {
                    String[] coordenadas = sensor.split(",");
                    int sensor_x = Integer.parseInt(coordenadas[0]);
                    int sensor_y = Integer.parseInt(coordenadas[1]);

                    if (sensor_x == x1 && sensor_y == y1) {
                        total++;
                    }
                }
            }
        }
        return total;
    }
    public static String defensaBatcueva(String[] sensores) {
        int maxima_alerta = 0;
        int[] coor_maxima_alerta = {0, 0};
        for (int x = 1; x <= 19; x++) {
            for (int y = 1; y <= 19; y++) {
                int alertas = analizadorDeAlertas(sensores, x, y);
                if (alertas > maxima_alerta) {
                    maxima_alerta = alertas;
                    coor_maxima_alerta[0] = x;
                    coor_maxima_alerta[1] = y;
                }
            }
        }
        int distancia = abs(coor_maxima_alerta[0]) + abs(coor_maxima_alerta[1]);
        boolean activar_protocolo = maxima_alerta > 20;
        return String.format("%d,%d,%d,%b", coor_maxima_alerta[0], coor_maxima_alerta[1], maxima_alerta, activar_protocolo, distancia);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos sensores deseas configurar?");
        int numSensors = scanner.nextInt();
        scanner.nextLine();

        String[] sensores = new String[numSensors];

        for (int i = 0; i < numSensors; i++) {
            System.out.println("Ingresa las coordenadas del sensor " + (i+1) + " (formato: x,y):");
            sensores[i] = scanner.nextLine();
        }

        String resultado = defensaBatcueva(sensores);
        String[] partes = resultado.split(",");
        System.out.printf("Centro cuadrícula más amenazada: (%s,%s).%n", partes[0], partes[1]);
        System.out.printf("Máximo nivel de alerta: %s.%n", partes[2]);
        System.out.printf("Distancia a la Batcueva: %d.%n",
                Math.abs(Integer.parseInt(partes[0])) + Math.abs(Integer.parseInt(partes[1])));
        System.out.printf("Activar protocolo de seguridad: %s.%n",
                Boolean.parseBoolean(partes[3]) ? "Sí" : "No");
    }
}
