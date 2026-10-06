# Parte A: cálculo manual

## 1) Round Robin con P1=15, P2=4, P3=3 usando Q=2 y Q=1. Comparar con Q=4 y FCFS

Se asume que los 3 procesos llegan en t=0.

### a) Round Robin Q = 2

**T_f:** P1=23, P2=10, P3=12  
**TAT:** P1=23, P2=10, P3=12  
**WT:** P1=8, P2=6, P3=9  
**WT medio = 7,67 | TAT medio = 15,00**

### b) Round Robin Q = 1

**Gantt Q=1:**
`	ext
|P1|P2|P3|P1|P2|P3|P1|P2|P3|P1|P2|P1|P1|P1|P1|P1|P1|P1|P1|P1|P1|P1|
0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22
`

**T_f:** P1=22, P2=11, P3=9  
**TAT:** P1=22, P2=11, P3=9  
**WT:** P1=7, P2=7, P3=6  
**WT medio = 6,67 | TAT medio = 14,00**

### c) Comparación

| Algoritmo | WT medio | TAT medio |
|---|---|---|
| FCFS | 11,33 | 18,67 |
| RR Q=2 | 7,67 | 15,00 |
| RR Q=1 | 6,67 | 14,00 |
| RR Q=4 | 6,33 | 13,67 |

**Conclusión:** RR reduce mucho la espera frente a FCFS. Q=4 da mejores promedios. Q muy pequeño aumenta equidad pero con mayor overhead.

## 2) FCFS, SJF y SRTF

Procesos: P1(0,7), P2(2,4), P3(4,1), P4(5,4)

### a) FCFS

**Gantt:**
`	ext
|    P1    |    P2    | P3 |    P4    |
0          7         11   12         16
`

| Proceso | Llegada | Burst | Fin | TAT | WT |
|---|---|---|---|---|---|
| P1 | 0 | 7 | 7 | 7 | 0 |
| P2 | 2 | 4 | 11 | 9 | 5 |
| P3 | 4 | 1 | 12 | 8 | 7 |
| P4 | 5 | 4 | 16 | 11 | 7 |

**WT medio = 4,75 | TAT medio = 8,75**

### b) SJF (No preventivo)

**Gantt:**
`	ext
|    P1    | P3 |    P2    |    P4    |
0          7   8         12         16
`

| Proceso | Llegada | Burst | Fin | TAT | WT |
|---|---|---|---|---|---|
| P1 | 0 | 7 | 7 | 7 | 0 |
| P2 | 2 | 4 | 12 | 10 | 6 |
| P3 | 4 | 1 | 8 | 4 | 3 |
| P4 | 5 | 4 | 16 | 11 | 7 |

**WT medio = 4,00 | TAT medio = 8,00**

### c) SRTF (Preventivo) – verificando con el código dado

**Gantt (según ejecución):**
`	ext
| P1 | P2 | P2 | P3 | P2 | P4 | P4 | P4 | P4 | P1 | P1 | P1 | P1 | P1 |
0    1    2    4    5    6    7    8    9   10   11   12   13   14   15
`

**Resultados del código:**
- P1 espera=8 retorno=15
- P2 espera=0 retorno=4
- P3 espera=0 retorno=1
- P4 espera=1 retorno=5

**WT medio = 2,25 | TAT medio = 6,25**

### d) ¿Qué algoritmo minimiza la espera media?

**SRTF** minimiza la espera media (2,25), seguido de SJF (4,00) y FCFS (4,75).

SRTF es preventivo: al llegar P3 (BT=1) en t=4 expulsa a P2, y vuelve a P2 cuando P3 termina (restante 2 < 4 de P4). Esto aprovecha mejor los procesos cortos.