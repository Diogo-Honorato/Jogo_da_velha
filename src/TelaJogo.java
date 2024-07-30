import javax.swing.*;
import java.awt.*;

public class TelaJogo extends JFrame {

    private Jogo jogo;
    private JButton[][] botoesTabuleiro;
    private JLabel statusPartida;
    private int turno;
    private int turnoAtual;

    public TelaJogo(Player[] players, Tabuleiro tabuleiro) {

        jogo = new Jogo(players, tabuleiro);
        botoesTabuleiro = new JButton[tabuleiro.getTamanhoX()][tabuleiro.getTamanhoY()];
        turno = 0;
        turnoAtual = 0;

        statusPartida = new JLabel("Vez do jogador: " + jogo.getPlayer()[turno].getNome()+ " (" + jogo.getPlayer()[turno].getSinal() + ")");
        statusPartida.setHorizontalAlignment(SwingConstants.CENTER);
        statusPartida.setFont(new Font("Serif",Font.PLAIN,20));

        setTitle("Jogo da Velha");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelTabuleiro = new JPanel();
        painelTabuleiro.setLayout(new GridLayout(tabuleiro.getTamanhoX(), tabuleiro.getTamanhoY()));
        add(painelTabuleiro, BorderLayout.CENTER);
        add(statusPartida, BorderLayout.NORTH);

        iniciarTabuleiro(painelTabuleiro, tabuleiro.getTamanhoX(), tabuleiro.getTamanhoY());
    }

    public void clickButton(int linha, int coluna) {

        if (botoesTabuleiro[linha][coluna].getText().equals("")) {

            botoesTabuleiro[linha][coluna].setText(String.valueOf(jogo.getPlayer()[turno].getSinal()));
            jogo.getTabuleiro().inserirTabuleiro(linha, coluna, jogo.getPlayer()[turno].getSinal());

            Posicao vitoria = jogo.condicaoVitoria(jogo.getTabuleiro(), jogo.getTabuleiro().getTamanhoX());

            System.out.println(vitoria);

            if (vitoria != Posicao.NULL) {
                statusPartida.setText("Vitória do player: " + jogo.getPlayer()[turno].getNome());
                encerrarJogo();
            } else if (jogo.condicaoEmpate(turnoAtual, jogo.getTotalTurnos()) == 1) {
                statusPartida.setText("Empate");
                encerrarJogo();
            } else {
                turno = (turno + 1) % jogo.getPlayer().length;
                statusPartida.setText("Vez do jogador: " + jogo.getPlayer()[turno].getNome() + " (" + jogo.getPlayer()[turno].getSinal() + ")");
                turnoAtual = turnoAtual + 1;
            }
        }
    }

    public void iniciarTabuleiro(JPanel painelTabuleiro, int linhas, int colunas) {

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                botoesTabuleiro[i][j] = new JButton("");
                botoesTabuleiro[i][j].setFont(new Font("Serif", Font.PLAIN, 20));
                botoesTabuleiro[i][j].setFocusPainted(false);

                int finalI = i;
                int finalJ = j;

                botoesTabuleiro[i][j].addActionListener(e -> clickButton(finalI, finalJ));
                painelTabuleiro.add(botoesTabuleiro[i][j]);
            }
        }
    }

    public void encerrarJogo() {
        for (int i = 0; i < botoesTabuleiro.length; i++) {
            for (int j = 0; j < botoesTabuleiro[i].length; j++) {
                botoesTabuleiro[i][j].setEnabled(false);
            }
        }
    }

}
