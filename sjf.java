public class sjf {
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
            new Proceso("A", 0, 3),
            new Proceso("C", 1, 3),
            new Proceso("B", 2, 1),
            new Proceso("D", 3, 2)
        };
        int n = ps.length;
        boolean[] hecho = new boolean[n];
        int t = 0, terminados = 0;
        double sumaEspera = 0, sumaRetorno = 0;

        while (terminados < n) {
            int elegido = -1;
            for (int i = 0; i < n; i++) {
                if (!hecho[i] && ps[i].llegada <= t) {
                    if (elegido == -1 || ps[i].rafaga < ps[elegido].rafaga) {
                        elegido = i;
                    }
                }
            }
            if (elegido == -1) { // CPU ociosa hasta que llegue alguien
                t++;
                continue;
            }
            Proceso p = ps[elegido];
            int espera = t - p.llegada;
            t += p.rafaga;
            int retorno = t - p.llegada;
            hecho[elegido] = true;
            terminados++;
            sumaEspera += espera;
            sumaRetorno += retorno;
            System.out.println(p.nombre + " espera=" + espera + " retorno=" + retorno);
        }
        System.out.printf("Espera media=%.2f Retorno medio=%.2f%n",
            sumaEspera / n, sumaRetorno / n);
    }
}