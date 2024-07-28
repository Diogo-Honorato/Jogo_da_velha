public class Tabuleiro {

    private char[][] tabuleiroJogo;
    private int tamanhoX; 
    private int tamanhoY;

    Tabuleiro(int dimensaoX, int dimensaoY){

        tamanhoX = dimensaoX;
        tamanhoY = dimensaoY;

        tabuleiroJogo = new char[tamanhoX][tamanhoY];
    }

    public void printTabuleiro(char[][] mapa){

        for(int i = 0; i < tamanhoX; i++){

            for(int j = 0; j < tamanhoY; j++){

                System.out.print(mapa[i][j] + "       ");
            }

            System.out.println("\n\n");
        }
    }

    public char[][] inserirTabuleiro(int posicaoX, int posicaoY, char sinal){

        tabuleiroJogo[posicaoX][posicaoY] = sinal;

        return getTabuleiroJogo();
    }

    public char[][] iniciarTabuleiro(){

        for(int i = 0; i < tamanhoX; i++){

            for(int j = 0; j < tamanhoY; j++){

                tabuleiroJogo[i][j] = '.';
            }
        }
        
        return getTabuleiroJogo();
    }

    public char[][] getTabuleiroJogo() {
        return tabuleiroJogo;
    }

    public int getTamanhoX() {
        return tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }
}
