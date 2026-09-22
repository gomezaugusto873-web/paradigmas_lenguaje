% factorial.pl
factorial(0, 1).
factorial(N, F) :-
    N > 0,
    N1 is N - 1,
    factorial(N1, F1),
    F is N * F1.

% Hechos
padre(carlos, juan).
padre(juan, pedro).
padre(juan, ana).

% Regla
abuelo(X, Z) :- padre(X, Y), padre(Y, Z).

% Consultas que se ejecutan al iniciar
main :-
    factorial(5, F),
    write('Factorial de 5 = '), write(F), nl,
    findall(N, abuelo(carlos, N), Nietos),
    write('Nietos de carlos: '), write(Nietos), nl,
    halt.

:- initialization(main).