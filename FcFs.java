import java.util.*;

public class FcFs {
    static class Proceso {
        String nombre;
        int llegada, rafaga;
        Proceso(String nombre, int llegada, int rafaga) {
            this.nombre = nombre;
            this.llegada = llegada;
            this.rafaga = rafaga;
        }
    }

    public static void main(String[] args) {
        Proceso[] ps = {
            new Proceso("P1", 0, 9),
            new Proceso("P2", 0, 4),
            new Proceso("P3", 0, 2)
        };
        Arrays.sort(ps, Comparator.comparingInt(p -> p.llegada));

        int t = 0;
        double sumaEspera = 0, sumaRetorno = 0;
        for (Proceso p : ps) {
            if (t < p.llegada) t = p.llegada;
            int espera = t - p.llegada;
            t += p.rafaga;
            int retorno = t - p.llegada;
            sumaEspera += espera;
            sumaRetorno += retorno;
            System.out.println(p.nombre + " espera=" + espera + " retorno=" + retorno);
        }
        System.out.printf("Espera media=%.2f Retorno medio=%.2f%n",
            sumaEspera / ps.length, sumaRetorno / ps.length);
    }
}


