import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

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
