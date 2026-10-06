public class Srtf {
    static String[] nombres = {"P1", "P2", "P3", "P4"};
    static int[] llegada = {0, 2, 4, 5};
    static int[] rafaga  = {7, 4, 1, 4};

    static int elegir(int t, int[] restante) {
        int elegido = -1;
        for (int i = 0; i < nombres.length; i++) {
            if (llegada[i] <= t && restante[i] > 0) {
                if (elegido == -1 || restante[i] < restante[elegido]) {
                    elegido = i;
                }
            }
        }
        return elegido;
    }

    public static void main(String[] args) {
        int n = nombres.length;
        int[] restante = rafaga.clone();
        int[] fin = new int[n];
        int t = 0, terminados = 0;

        while (terminados < n) {
            int i = elegir(t, restante);
            if (i == -1) {
                t++;
                continue;
            }
            restante[i]--;
            t++;
            if (restante[i] == 0) {
                fin[i] = t;
                terminados++;
            }
        }

        for (int i = 0; i < n; i++) {
            int retorno = fin[i] - llegada[i];
            int espera = retorno - rafaga[i];
            System.out.println(nombres[i] + " espera=" + espera + " retorno=" + retorno);
        }
    }
}
