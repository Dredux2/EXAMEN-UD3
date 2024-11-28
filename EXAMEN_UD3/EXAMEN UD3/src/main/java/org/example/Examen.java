package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Examen {
    public static void Ejercicio1() {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        String carton;
        int score = 0;
        int[] bolasExtraidas;
        int bolas;
        do {
            bolas = rm.nextInt(10, 41);
            bolasExtraidas = new int[bolas];
            for (int i = 0; i < bolas; i++) {
                bolasExtraidas[i] = rm.nextInt(1, 91);
            }
            bolasExtraidas = Arrays.stream(bolasExtraidas).distinct().toArray();
        } while (bolasExtraidas.length < bolas);

        System.out.println(bolasExtraidas.length + " Bolas Extraidas: " + Arrays.toString(bolasExtraidas));

        do {
            System.out.print("Intoduce los datos de tu carton {N-N-N}: ");
            carton = sc.nextLine();

            if (!carton.matches("\\d{1,90}-\\d{1,90}-\\d{1,90}")){
                System.out.println("ERROR: Introduce los valores en un formato valido.");
                continue;
            }
            score++;
        } while (!carton.matches("\\d{1,90}-\\d{1,90}-\\d{1,90}") || score < 3);

        String[] cartonBingo = carton.split("[-,|_\\s/]+");
        int[][] cartonUsuario = new int[3][3];
        for (int i = 0; i < cartonUsuario.length; i++) {
            cartonUsuario[0][i] = Integer.parseInt(cartonBingo[i]);
        }
        System.out.println("Su carton es: " + Arrays.toString(cartonUsuario));
    }
}
