public class Jogo {

    private Player player;
    private Tabuleiro tabuleiro;
    private Posicao posicao;
    private int totalTurnos;

    Jogo(Player player, Tabuleiro tabuleiro) {

        this.tabuleiro = tabuleiro;
        this.player = player;
        totalTurnos = ((tabuleiro.getTamanhoX() * tabuleiro.getTamanhoY()) + 1);
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public int getTotalTurnos(){

        return totalTurnos;
    }

    public Posicao condicaoVitoria(Tabuleiro tabuleiro, int quantidadeElementos) {

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

                //Diagonal secundaria
                if (tabuleiro.getTabuleiroJogo()[j][quantidadeElementos - j - 1] == 'X') {

                   contadorDiagonalSecundaria++;

                }else if (tabuleiro.getTabuleiroJogo()[j][quantidadeElementos - j - 1] == 'O') {

                    contadorDiagonalSecundaria = (contadorDiagonalSecundaria + 2);
                }

            }
            
            //quem ganhou
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
            else if(contadorDiagonalSecundaria == (quantidadeElementos * 2))
            {

                return getPosicao().DIAGONAL_SECUNDARIA_O;
            }
            else{

                contadorLinha = 0;
                contadorColuna = 0;
            }
        }

        return posicao;
    }

    public int condicaoEmpate(int turno, int totalTurnos){

        if(turno == totalTurnos){

            return 1;
        }

        return 0;
    }




}
