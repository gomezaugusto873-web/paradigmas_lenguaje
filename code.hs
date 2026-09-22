factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n - 1)

factorialLista :: Integer -> Integer
factorialLista n = product [1..n]

main :: IO ()
main = do
    putStrLn("Factorial de 5 = " ++ show (factorial 5))
    putStrLn("Con lista = " ++ show (factorialLista 5))