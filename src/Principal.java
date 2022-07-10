public class Principal {

    public static void main(String[] args) {
        int[] estados = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int iteracoes = 10;

        int[][] matrizPassos = new int[11][iteracoes];

        Ansiogenico.ansiogenico(iteracoes, estados, matrizPassos);

        imprimirMatriz(matrizPassos);
        tempoMedioPrimeiraVisita(matrizPassos, estados);
    }

    public static void imprimirMatriz(int[][] matrizPassos) {
        for (int linha = 0; linha < matrizPassos.length; linha++) {
            for (int coluna = 0; coluna < matrizPassos[linha].length; coluna++) {
                System.out.print(matrizPassos[linha][coluna] + "\t\t");
            }
            System.out.println();
        }
    }

    public static void tempoMedioPrimeiraVisita(int[][] matrizPassos, int[] estados) {
        double[] somas = new double[11];
        double[] medias = new double[11];

        for (int linha = 0; linha < matrizPassos.length; linha++) {
            double soma = 0;
            for (int coluna = 0; coluna < matrizPassos[linha].length; coluna++) {
                soma += matrizPassos[linha][coluna];
                somas[linha] = soma;
            }
        }

        for (int i = 0; i < somas.length; i++) {
            if (i != 5) {
                medias[i] = somas[i] / estados.length;
            } else {
                continue;
            }
            System.out.printf("Linha %d: soma %s, média %.2f\n",i+1, somas[i], medias[i]);
        }
    }


}
