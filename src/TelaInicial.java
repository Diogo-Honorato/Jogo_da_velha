import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

   private JButton jButtonJogar = new JButton("Novo Jogo");
   private JButton jButtonSair = new JButton("Sair");

   private Font fonteBotaoPadrao = new Font("Serif", Font.BOLD, 40);


    public TelaInicial(){

        setTitle("Jogo da Velha");
        setSize(800,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botoesTelaInicial();
    }

    public void botoesTelaInicial() {

        //Especificaçoes do botao de jogar
        jButtonJogar.setBounds(265, 175, 270, 100);
        jButtonJogar.setBackground(Color.BLUE);
        jButtonJogar.setForeground(new Color(255,209,0));
        jButtonJogar.setFont(fonteBotaoPadrao);
        jButtonJogar.setToolTipText("Iniciar registro.");

        //Especificaçoes do botao de saida
        jButtonSair.setBounds(265, 285, 270, 100);
        jButtonSair.setBackground(Color.BLUE);
        jButtonSair.setForeground(new Color(255,209,0));
        jButtonSair.setFont(fonteBotaoPadrao);
        jButtonSair.setToolTipText("Sair do jogo.");

        add(jButtonJogar);
        add(jButtonSair);
    }

    public JButton getjButtonJogar() {
        return jButtonJogar;
    }


    public JButton getjButtonSair() {
        return jButtonSair;
    }
}
