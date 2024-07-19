public class Jogo {

    private Player player;
    private Tabuleiro tabuleiro;
    private Posicao posicao;

    Jogo(Player player, Tabuleiro tabuleiro) {

        this.tabuleiro = tabuleiro;
        this.player = player;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public Posicao vitoria(Tabuleiro tabuleiro, int quantidadeElementos) {

        int contadorLinha = 0;
        int contadorColuna = 0;
        int contadorDiagonalPrincipal = 0;
        int contadorDiagonalSecundaria = 0;

        for (int i = 0; i < tabuleiro.getTamanhoX(); i++) {

            for (int j = 0; j < tabuleiro.getTamanhoY(); j++) {

                // Linha
                if (tabuleiro.getTabuleiroJogo()[i][j] == 'X') {

                    contadorLinha++;

                } else if (tabuleiro.getTabuleiroJogo()[i][j] == 'O') {

                    contadorLinha = contadorLinha + 2;
                }

                // Coluna
                if (tabuleiro.getTabuleiroJogo()[j][i] == 'X') {

                    contadorColuna++;

                } else if (tabuleiro.getTabuleiroJogo()[j][i] == 'O') {

                    contadorColuna = contadorColuna + 2;
                }

                // Diagonal
                if (i == j && tabuleiro.getTabuleiroJogo()[i][j] == 'X') {

                    contadorDiagonalPrincipal++;

                } else if (i == j && tabuleiro.getTabuleiroJogo()[i][j] == 'O') {

                    contadorDiagonalPrincipal = contadorDiagonalPrincipal + 2;
                }

            }

            if (contadorLinha == quantidadeElementos) {

                return getPosicao().LINHA_X;

            } 
            else if (contadorLinha == (quantidadeElementos * 2)) 
            {

                return getPosicao().LINHA_O;
            } 
            else if (contadorColuna == quantidadeElementos) 
            {

                return getPosicao().COLUNA_X;
            } 
            else if (contadorColuna == (quantidadeElementos * 2))
            {

                return getPosicao().COLUNA_O;
            }
            else if(contadorDiagonalPrincipal == quantidadeElementos)
            {

                return getPosicao().DIAGONAL_PRINCIPAL_X;
            }
            else if(contadorDiagonalPrincipal == (quantidadeElementos * 2))
            {

                return getPosicao().DIAGONAL_PRINCIPAL_O;
            }
            else if(contadorDiagonalSecundaria == quantidadeElementos)
            {

                return getPosicao().DIAGONAL_SECUNDARIA_X;
            }
            else if(contadorDiagonalSecundaria == quantidadeElementos)
            {

                return getPosicao().DIAGONAL_SECUNDARIA_O;
            }
        }

        return posicao;
    }

}
