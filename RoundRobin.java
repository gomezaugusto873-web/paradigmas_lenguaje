import java.util.*;

public class RoundRobin {
    public static void main(String[] args) {
        String[] nombres = {"P1", "P2", "P3"};
        int[] rafaga = {15, 4, 3};
        int quantum = 4;

        int n = nombres.length;
        int[] restante = rafaga.clone();
        int[] fin = new int[n];
        Queue<Integer> cola = new ArrayDeque<>();
        for (int i = 0; i < n; i++) cola.add(i);

        int t = 0;
        while (!cola.isEmpty()) {
            int i = cola.poll();
            int uso = Math.min(quantum, restante[i]);
            System.out.println("t=" + t + "-" + (t + uso) + " " + nombres[i]);
            t += uso;
            restante[i] -= uso;
            if (restante[i] > 0) {
                cola.add(i);        // vuelve al final de la cola
            } else {
                fin[i] = t;
            }
        }

        double sumaEspera = 0;
        for (int i = 0; i < n; i++) {
            int retorno = fin[i];          // todos llegan en t=0
            int espera = retorno - rafaga[i];
            sumaEspera += espera;
            System.out.println(nombres[i] + " espera=" + espera + " retorno=" + retorno);
        }
        System.out.printf("Espera media=%.2f%n", sumaEspera / n);
    }
}