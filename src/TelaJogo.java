import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogo extends JFrame {

    private Jogo jogo;
    private JButton[][] botoesTabuleiro;
    private JLabel statusPartida;
    private int turno;
    private int turnoAtual;

    public TelaJogo(Player[] players, Tabuleiro tabuleiro) {

        jogo = new Jogo(players, tabuleiro);
        botoesTabuleiro = new JButton[tabuleiro.getTamanhoX()][tabuleiro.getTamanhoY()];
        turnoAtual = 0;

        if(jogo.getPlayer()[0].getSinal() == 'X'){
            turno = 0;
        }else{
            turno = 1;
        }

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

            if (vitoria != Posicao.NULL) {

                String message = "Vitória do jogador: " +  jogo.getPlayer()[turno].getNome();
                statusPartida.setText("Fim de Jogo");
                encerrarJogo(message);

            } else if (jogo.condicaoEmpate(turnoAtual, jogo.getTotalTurnos()) == 1) {
                statusPartida.setText("Fim de Jogo");
                encerrarJogo("Empate");
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

    public boolean encerrarJogo(String message) {
        for (int i = 0; i < botoesTabuleiro.length; i++) {
            for (int j = 0; j < botoesTabuleiro[i].length; j++) {
                botoesTabuleiro[i][j].setEnabled(false);
            }
        }

        int escolha = JOptionPane.showOptionDialog(
                this,
                message,
                "Fim de jogo",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Continuar", "Novo Jogo", "Sair"},
                "Continuar"
        );

        switch (escolha) {
            case JOptionPane.YES_OPTION:
                reiniciarJogo();
                break;
            case JOptionPane.NO_OPTION:
                iniciarNovoJogo();
                break;
            case JOptionPane.CANCEL_OPTION:
                System.exit(0);
                break;
        }

        return true;
    }

    public void reiniciarJogo() {
        dispose();

        char sinal = jogo.getPlayer()[0].getSinal();

        jogo.getPlayer()[0].setSinal(jogo.getPlayer()[1].getSinal());

        jogo.getPlayer()[1].setSinal(sinal);

        new TelaJogo(jogo.getPlayer(), new Tabuleiro(jogo.getTabuleiro().getTamanhoX(),jogo.getTabuleiro().getTamanhoY())).setVisible(true);
    }

    public void iniciarNovoJogo() {
        dispose();
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);

        telaInicial.getjButtonJogar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRegistro telaRegistro = new TelaRegistro();
                telaRegistro.setVisible(true);
                telaInicial.dispose();

                telaRegistro.getJButtonIniciar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        telaRegistro.trasferirArgumentos();
                        TelaJogo telaJogo = new TelaJogo(telaRegistro.getPlayerRegistro(), telaRegistro.getTabuleiroRegistro());
                        telaJogo.setVisible(true);
                        telaRegistro.dispose();
                    }
                });
            }
        });

        telaInicial.getjButtonSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInicial.dispose();
            }
        });
    }
}


