import javax.swing.*;
import java.awt.*;

public class TelaJogo extends JFrame {

    private Jogo jogo;
    private JButton[][] botoesTabuleiro;
    private JLabel statusPartida;
    private int turno;

    public TelaJogo(Player[] players, Tabuleiro tabuleiro ){

        jogo = new Jogo(players,tabuleiro);
        statusPartida = new JLabel();
        statusPartida.setHorizontalAlignment(SwingConstants.CENTER);
        turno = 0;

        setTitle("Jogo da Velha");
        setSize(800,600);
        setLayout(new GridLayout(tabuleiro.getTamanhoX(), tabuleiro.getTamanhoY()));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void clickButton(){

        if(botoesTabuleiro[linha][coluna].getText().equals("")){

            botoesTabuleiro[linha][coluna].setText(String.valueOf(jogo.getPlayer()[turno].getSinal()));

            jogo.getTabuleiro().inserirTabuleiro(linha,coluna, jogo.getPlayer()[turno].getSinal());

            Posicao vitoria = jogo.condicaoVitoria(jogo.getTabuleiro(),jogo.getTabuleiro().getTamanhoX());

            if(vitoria != Posicao.NULL){

                statusPartida.setText("Vitoria do player: " + jogo.getPlayer()[turno].getNome());
                encerrarJogo();
            }
            else if (jogo.condicaoEmpate(++turno,jogo.getTotalTurnos()) == 1) {

                statusPartida.setText("Empate");
            }
            else
            {
                turno = (turno + 1) % 2;
                statusPartida.setText("Vez do jogador: " + jogo.getPlayer()[turno].getNome());
            }
        }
    }

    public void iniciarTabuleiro(int linhas, int colunas){

        for(int i = 0; i < linhas; i++){

            for(int j = 0; j < colunas; j++){

                botoesTabuleiro[i][j] = new JButton("");
                botoesTabuleiro[i][j].setFont(new Font("Serif", Font.PLAIN, 20));
                botoesTabuleiro[i][j].setFocusPainted(false);
                botoesTabuleiro[i][j].addActionListener(e->clickButton());
                add(botoesTabuleiro[i][j]);
            }
        }
    }

    public void encerrarJogo(){

        for(int i = 0; i < botoesTabuleiro.length; i++){

            for(int j = 0;j < botoesTabuleiro[i].length; j++){

                botoesTabuleiro[i][j].setEnabled(false);
            }
        }
    }

}
