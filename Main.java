public class Main {

    public static void main(String[] args) {
        
        System.out.println("Jogo da velha");

        Tabuleiro tabuleiro = new Tabuleiro(3, 3);

        Player player = new Player("Diogo", 0, 'X');

        Jogo jogoVelha = new Jogo(player, tabuleiro);
        
        tabuleiro.printTabuleiro(tabuleiro.iniciarTabuleiro());

        tabuleiro.printTabuleiro(tabuleiro.inserirTabuleiro(0, 2, 'O'));
        tabuleiro.printTabuleiro(tabuleiro.inserirTabuleiro(1, 1, 'X'));
        tabuleiro.printTabuleiro(tabuleiro.inserirTabuleiro(2, 0, 'O'));

        if(jogoVelha.condicaoVitoria(tabuleiro, 3) == jogoVelha.getPosicao().DIAGONAL_SECUNDARIA_O){

            System.out.println("Vitoria O");
        }else{

            System.out.println("Nao funfou");
        }

        
    }
}