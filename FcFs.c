#include <stdio.h>

typedef struct {
    char nombre[4];
    int llegada;
    int rafaga;
} Proceso;

int main(void) {
    Proceso ps[] = {
        {"P1", 0, 9},
        {"P2", 0, 4},
        {"P3", 0, 2}
    };
    int n = sizeof(ps) / sizeof(ps[0]);

    /* ordenar por llegada (burbuja estable) */
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            if (ps[j].llegada > ps[j + 1].llegada) {
                Proceso aux = ps[j];
                ps[j] = ps[j + 1];
                ps[j + 1] = aux;
            }
        }
    }

    int t = 0;
    double sumaEspera = 0, sumaRetorno = 0;
    for (int i = 0; i < n; i++) {
        if (t < ps[i].llegada) t = ps[i].llegada;
        int espera = t - ps[i].llegada;
        t += ps[i].rafaga;
        int retorno = t - ps[i].llegada;
        sumaEspera += espera;
        sumaRetorno += retorno;
        printf("%s espera=%d retorno=%d\n", ps[i].nombre, espera, retorno);
    }
    printf("Espera media=%.2f Retorno medio=%.2f\n", sumaEspera / n, sumaRetorno / n);
    return 0;
}
