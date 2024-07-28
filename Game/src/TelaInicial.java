import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    JButton jButtonJogar = new JButton("JOGAR");
    JButton jButtonSair = new JButton("SAIR");

    Font fonteBotaoPadrao = new Font("Arial", Font.BOLD, 40);


    public TelaInicial(){

        setTitle("Jogo da Velha");
        setSize(800,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botoesTelaInicial();
    }

    public void botoesTelaInicial() {

        //Especificaçoes do botao de jogar
        jButtonJogar.setBounds(265, 175, 270, 70);
        jButtonJogar.setBackground(Color.BLUE);
        jButtonJogar.setForeground(new Color(255,209,0));
        jButtonJogar.setFont(fonteBotaoPadrao);
        jButtonJogar.setToolTipText("iniciar jogatina.");

        //Especificaçoes do botao de saida
        jButtonSair.setBounds(265, 265, 270, 70);
        jButtonSair.setBackground(Color.BLUE);
        jButtonSair.setForeground(new Color(255,209,0));
        jButtonSair.setFont(fonteBotaoPadrao);
        jButtonSair.setToolTipText("Sair do jogo.");

        add(jButtonJogar);
        add(jButtonSair);
    }
}