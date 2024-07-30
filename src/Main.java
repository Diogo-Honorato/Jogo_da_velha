public class Main {

    public static void main(String[] args) {

        Player jogador1 = new Player("Jogador 1", 'X');
        Player jogador2 = new Player("Jogador 2", 'O');
        Player[] jogadores = {jogador1, jogador2};
        Tabuleiro tabuleiro = new Tabuleiro(3, 3);

        TelaJogo tela = new TelaJogo(jogadores,tabuleiro);

        tela.setVisible(true);
        
    }
}