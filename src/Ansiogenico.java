import java.util.ArrayList;

public class Ansiogenico {

    public static int[][] ansiogenico(int iteracoes, int[] estados, int[][] matrizPassos){
        double[] probabilidades = {1.0, 0.36, 0.47, 0.48, 0.45, 0.29, 0.47, 0.48, 0.50, 0.57, 1.0};

        for (int iteracao = 0; iteracao < iteracoes; iteracao++){

            ArrayList<Double> listaNumerosAleatorios = new ArrayList<Double>();
            ArrayList<Integer> trajetoria = new ArrayList<Integer>();

            int numeroPosicao = 5;
            int numeroAleatorio = 0;
            int contadorPassos = 0;

            boolean chegadaExtremidade1 = false;
            boolean chegadaExtremidade11 = false;

            while (chegadaExtremidade1 == false || chegadaExtremidade11 == false) {
                listaNumerosAleatorios.add(Math.random());
                int posicao = estados[numeroPosicao];
                double probabilidade = probabilidades[numeroPosicao];

                boolean parada = false;

                while (parada == false) {

                    contadorPassos += 1;

                    if (numeroPosicao != 0 && numeroPosicao != 10) {
                        if (listaNumerosAleatorios.get(numeroAleatorio) <= probabilidade){
                            posicao = estados[numeroPosicao-1];
                            trajetoria.add(posicao);
                            probabilidade = probabilidades[numeroPosicao-1];
                            parada = true;
                            if (matrizPassos[numeroPosicao-1][iteracao] == 0) {
                                matrizPassos[numeroPosicao-1][iteracao] = contadorPassos;
                            }
                            numeroPosicao -= 1;
                        } else if (listaNumerosAleatorios.get(numeroAleatorio) > probabilidade) {
                            posicao = estados[numeroPosicao+1];
                            trajetoria.add(posicao);
                            probabilidade = probabilidades[numeroPosicao+1];
                            parada = true;
                            if (matrizPassos[numeroPosicao+1][iteracao] == 0){
                                matrizPassos[numeroPosicao+1][iteracao] = contadorPassos;
                            }
                            numeroPosicao += 1;
                        }
                    } else if (numeroPosicao == 0 && listaNumerosAleatorios.get(numeroAleatorio) <= probabilidade) {
                        posicao = estados[numeroPosicao+1];
                        trajetoria.add(posicao);
                        probabilidade = probabilidades[numeroPosicao+1];
                        parada = true;
                        chegadaExtremidade1 = true;
                        if (matrizPassos[numeroPosicao][iteracao] == 0) {
                            matrizPassos[numeroPosicao][iteracao] = contadorPassos;
                        }
                        numeroPosicao += 1;
                    } else if (numeroPosicao == 10 && listaNumerosAleatorios.get(numeroAleatorio) <= probabilidade) {
                        posicao = estados[numeroPosicao-1];
                        trajetoria.add(posicao);
                        probabilidade = probabilidades[numeroPosicao-1];
                        parada = true;
                        chegadaExtremidade11 = true;
                        if (matrizPassos[numeroPosicao][iteracao] == 0) {
                            matrizPassos[numeroPosicao][iteracao] = contadorPassos;
                        }
                        numeroPosicao -= 1;
                    }
                }
                numeroAleatorio += 1;
            }
            System.out.println("trajetória: " + trajetoria);
        }
        return matrizPassos;
    }
}
