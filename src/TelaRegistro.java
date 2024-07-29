import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TelaRegistro extends JFrame {

    private Player[] playerRegistro = new Player[2];
    private Tabuleiro tabuleiroRegistro;
    //Label player
    private JLabel jLabelPlayer_1 = new JLabel("Player 1");
    private JLabel jLabelPlayer_2 = new JLabel("Player 2");

    //Label Comprimento e largura
    private JLabel jLabelTabuleiro = new JLabel("Tabuleiro");
    private JLabel jLabelTextoX = new JLabel("X");


    //Texto player
    private JTextField jtfPlayer_1 = new JTextField();
    private JTextField jtfPlayer_2 = new JTextField();

    //Texto comprimento e largura
    private JTextField jtfLinhas = new JTextField();
    private JTextField jtfColunas = new JTextField();

    //Botao iniciar
    private JButton jButtonIniciar = new JButton("INICIAR");

    public TelaRegistro(){

        setTitle("Jogo da Velha");
        setSize(800,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelTexto();
        areaTexto();
        botaoIniciar();
    }

    public void labelTexto(){

        jLabelPlayer_1.setBounds(355,100,170,70);
        jLabelPlayer_1.setFont(new Font("Serif", Font.BOLD, 20));
        add(jLabelPlayer_1);

        jLabelPlayer_2.setBounds(355,190,170,70);
        jLabelPlayer_2.setFont(new Font("Serif", Font.BOLD, 20));
        add(jLabelPlayer_2);

        jLabelTabuleiro.setBounds(350,280,170,70);
        jLabelTabuleiro.setFont(new Font("Serif", Font.BOLD, 20));
        add(jLabelTabuleiro);

        jLabelTextoX.setBounds(395,320,100,70);
        jLabelTextoX.setFont(new Font("Serif", Font.BOLD, 20));
        add(jLabelTextoX);
    }



    public void areaTexto(){

        jtfPlayer_1.setBounds(320,150,170,30);
        jtfPlayer_1.setFont(new Font("Serif", Font.BOLD, 20));
        jtfPlayer_1.setHorizontalAlignment(JTextField.CENTER);
        jtfPlayer_1.setToolTipText("Insira o nome do player 1.");
        add(jtfPlayer_1);

        jtfPlayer_2.setBounds(320,240,170,30);
        jtfPlayer_2.setFont(new Font("Serif", Font.BOLD, 20));
        jtfPlayer_2.setHorizontalAlignment(JTextField.CENTER);
        jtfPlayer_2.setToolTipText("Insira o nome do player 2.");
        add(jtfPlayer_2);

        jtfLinhas.setBounds(340,335,50,40);
        jtfLinhas.setFont(new Font("Serif", Font.BOLD, 20));
        jtfLinhas.setHorizontalAlignment(JTextField.CENTER);
        jtfLinhas.setToolTipText("Insira a quantidade de linhas.");
        add(jtfLinhas);

        jtfColunas.setBounds(415,335,50,40);
        jtfColunas.setFont(new Font("Serif", Font.BOLD, 20));
        jtfColunas.setHorizontalAlignment(JTextField.CENTER);
        jtfColunas.setToolTipText("Insira a quantidade de colunas.");
        add(jtfColunas);

    }

    public void botaoIniciar(){

        jButtonIniciar.setBounds(275, 470, 270, 70);
        jButtonIniciar.setBackground(Color.BLUE);
        jButtonIniciar.setForeground(new Color(255,209,0));
        jButtonIniciar.setFont(new Font("Serif", Font.BOLD, 40));
        jButtonIniciar.setToolTipText("Iniciar Jogo da velha.");
        jButtonIniciar.addActionListener(e -> trasferirArgumentos());
        add(jButtonIniciar);
    }

    public char randomXO(){

        Random rand = new Random();
        return rand.nextBoolean() ? 'X' : 'O';
    }

    public void inserirDadosPlayer(){

        char primeiroSinal = randomXO();
        char segundoSinal = (primeiroSinal == 'X') ? 'O' : 'X';

        playerRegistro[0] = new Player(jtfPlayer_1.getText(),primeiroSinal);
        playerRegistro[1] = new Player(jtfPlayer_2.getText(),segundoSinal);

    }

    public void inserirDadosTabuleiro(int linhas, int colunas){

        tabuleiroRegistro = new Tabuleiro(linhas,colunas);

    }

    private void trasferirArgumentos() {
        int linhas = 0;
        int colunas = 0;

        try {
            linhas = Integer.parseInt(jtfLinhas.getText());
            colunas = Integer.parseInt(jtfColunas.getText());
            tabuleiroRegistro = new Tabuleiro(linhas, colunas);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para linhas e colunas.");
        }

        inserirDadosPlayer();
        inserirDadosTabuleiro(linhas,colunas);

        /*
        System.out.println(playerRegistro[0].getNome() + "," + playerRegistro[0].getSinal());
        System.out.println(playerRegistro[1].getNome() + "," + playerRegistro[1].getSinal());
        System.out.println(tabuleiroRegistro.getTamanhoX());
        System.out.println(tabuleiroRegistro.getTamanhoY());
        */
    }

    public Player[] getPlayerRegistro() {
        return playerRegistro;
    }

    public Tabuleiro getTabuleiroRegistro() {
        return tabuleiroRegistro;
    }
}
