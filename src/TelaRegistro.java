import javax.swing.*;
import javax.swing.text.*;
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
    private JButton jButtonIniciar = new JButton("Iniciar");

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
        setMaxLength(jtfPlayer_1,12);
        add(jtfPlayer_1);

        jtfPlayer_2.setBounds(320,240,170,30);
        jtfPlayer_2.setFont(new Font("Serif", Font.BOLD, 20));
        jtfPlayer_2.setHorizontalAlignment(JTextField.CENTER);
        jtfPlayer_2.setToolTipText("Insira o nome do player 2.");
        setMaxLength(jtfPlayer_2,12);
        add(jtfPlayer_2);

        jtfLinhas.setBounds(340,335,50,40);
        jtfLinhas.setFont(new Font("Serif", Font.BOLD, 20));
        jtfLinhas.setHorizontalAlignment(JTextField.CENTER);
        jtfLinhas.setToolTipText("Insira a quantidade de linhas.");
        setMaxLength(jtfLinhas,2);
        add(jtfLinhas);

        jtfColunas.setBounds(415,335,50,40);
        jtfColunas.setFont(new Font("Serif", Font.BOLD, 20));
        jtfColunas.setHorizontalAlignment(JTextField.CENTER);
        jtfColunas.setToolTipText("Insira a quantidade de colunas.");
        setMaxLength(jtfColunas,2);
        add(jtfColunas);

    }

    public void botaoIniciar(){

        jButtonIniciar.setBounds(275, 470, 270, 70);
        jButtonIniciar.setBackground(Color.BLUE);
        jButtonIniciar.setForeground(new Color(255,209,0));
        jButtonIniciar.setFont(new Font("Serif", Font.BOLD, 40));
        jButtonIniciar.setToolTipText("Iniciar Jogo da velha.");
        add(jButtonIniciar);
    }


    private void setMaxLength(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null || (fb.getDocument().getLength() + string.length()) <= maxLength) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null || (fb.getDocument().getLength() - length + text.length()) <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
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



    public void trasferirArgumentos() {
        int linhas = 0;
        int colunas = 0;

        try {
            linhas = Integer.parseInt(jtfLinhas.getText());
            colunas = Integer.parseInt(jtfColunas.getText());

            // Verificar se as linhas e colunas são iguais e se o valor é menor ou igual a 10
            if (linhas != colunas) {
                JOptionPane.showMessageDialog(this, "O número de linhas e colunas deve ser igual.");
                return;
            }

            if (linhas < 3 || linhas > 10) {
                JOptionPane.showMessageDialog(this, "O valor deve ser entre 3 e 10.");
                return;
            }

            // Inicializar o tabuleiro com o número de linhas e colunas
            tabuleiroRegistro = new Tabuleiro(linhas, colunas);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números para linhas e colunas.");
        }

        inserirDadosPlayer();
    }

    public Player[] getPlayerRegistro() {
        return playerRegistro;
    }

    public Tabuleiro getTabuleiroRegistro() {
        return tabuleiroRegistro;
    }

    public JButton getJButtonIniciar() {
        return jButtonIniciar;
    }
}
