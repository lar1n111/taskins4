package org.example;


import java.util.Scanner;

public class Main {

    // Умножение двух матриц 2×2
    public static long[][] multiply(long[][] A, long[][] B) {
        return new long[][] {
                { A[0][0]*B[0][0] + A[0][1]*B[1][0],  A[0][0]*B[0][1] + A[0][1]*B[1][1] },
                { A[1][0]*B[0][0] + A[1][1]*B[1][0],  A[1][0]*B[0][1] + A[1][1]*B[1][1] }
        };
    }

    // Быстрое возведение матрицы в степень
    public static long[][] power(long[][] M, long n) {
        if (n == 1) return M;
        if (n % 2 == 0) {
            long[][] half = power(M, n / 2); // т.е если n = 6, то возведение в 6 степень
            //будет как (Q)**3**2, что дает скорость O(logn)
            return multiply(half, half);
        } else {
            return multiply(M, power(M, n - 1));
        }
    }

    // Вычисление n-го числа Фибоначчи через матрицу
    public static long fib(long n) {
        if (n == 0) return 0;
        long[][] Q = { {1, 1}, {1, 0} };
        long[][] R = power(Q, n);
        return R[0][1]; // элемент F(n)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        long n = scanner.nextLong();
        System.out.println("F(" + n + ") = " + fib(n));
    }
}