public class Jogo {

    private Player[] player = new Player[2];
    private Tabuleiro tabuleiro;
    private int totalTurnos;

    Jogo(Player[] player, Tabuleiro tabuleiro) {

        this.tabuleiro = tabuleiro;
        this.player = player;
        totalTurnos = ((tabuleiro.getTamanhoX() * tabuleiro.getTamanhoY()) - 1);
    }

    public int getTotalTurnos(){

        return totalTurnos;
    }

    public Posicao condicaoVitoria(Tabuleiro tabuleiro, int quantidadeElementos) {

        int contadorLinha_X = 0;
        int contadorLinha_O = 0;
        int contadorColuna_X = 0;
        int contadorColuna_O = 0;
        int contadorDiagonalPrincipal_X = 0;
        int contadorDiagonalPrincipal_O = 0;
        int contadorDiagonalSecundaria_X = 0;
        int contadorDiagonalSecundaria_O = 0;

        for (int i = 0; i < tabuleiro.getTamanhoX(); i++) {

            for (int j = 0; j < tabuleiro.getTamanhoY(); j++) {

                // Linha
                if (tabuleiro.getTabuleiroJogo()[i][j] == 'X') {

                    contadorLinha_X++;

                } else if (tabuleiro.getTabuleiroJogo()[i][j] == 'O') {

                    contadorLinha_O = contadorLinha_O + 2;
                }

                // Coluna
                if (tabuleiro.getTabuleiroJogo()[j][i] == 'X') {

                    contadorColuna_X++;

                } else if (tabuleiro.getTabuleiroJogo()[j][i] == 'O') {

                    contadorColuna_O = contadorColuna_O + 2;
                }

                // Diagonal
                if (i == j && tabuleiro.getTabuleiroJogo()[i][j] == 'X') {

                    contadorDiagonalPrincipal_X++;

                } else if (i == j && tabuleiro.getTabuleiroJogo()[i][j] == 'O') {

                    contadorDiagonalPrincipal_O = contadorDiagonalPrincipal_O + 2;
                }

                //Diagonal secundaria
                if (tabuleiro.getTabuleiroJogo()[j][quantidadeElementos - j - 1] == 'X') {

                   contadorDiagonalSecundaria_X++;

                }else if (tabuleiro.getTabuleiroJogo()[j][quantidadeElementos - j - 1] == 'O') {

                    contadorDiagonalSecundaria_O = (contadorDiagonalSecundaria_O + 2);
                }

            }
            
            //quem ganhou
            if (contadorLinha_X == quantidadeElementos) {

                return Posicao.LINHA_X;

            } 
            else if (contadorLinha_O == (quantidadeElementos * 2))
            {

                return Posicao.LINHA_O;
            } 
            else if (contadorColuna_X == quantidadeElementos)
            {

                return Posicao.COLUNA_X;
            } 
            else if (contadorColuna_O == (quantidadeElementos * 2))
            {

                return Posicao.COLUNA_O;
            }
            else if(contadorDiagonalPrincipal_X == quantidadeElementos)
            {

                return Posicao.DIAGONAL_PRINCIPAL_X;
            }
            else if(contadorDiagonalPrincipal_O == (quantidadeElementos * 2))
            {

                return Posicao.DIAGONAL_PRINCIPAL_O;
            }
            else if(contadorDiagonalSecundaria_X == quantidadeElementos)
            {

                return Posicao.DIAGONAL_SECUNDARIA_X;
            }
            else if(contadorDiagonalSecundaria_O == (quantidadeElementos * 2))
            {

                return Posicao.DIAGONAL_SECUNDARIA_O;
            }
            else{

                contadorLinha_X = 0;
                contadorLinha_O = 0;

                contadorColuna_X = 0;
                contadorColuna_O = 0;

                contadorDiagonalSecundaria_X = 0;
                contadorDiagonalSecundaria_O = 0;
            }
        }

        return  Posicao.NULL;
    }

    public int condicaoEmpate(int turno, int totalTurnos){

        if(turno == totalTurnos){

            return 1;
        }

        return 0;
    }


    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public Player[] getPlayer() {
        return player;
    }
}
