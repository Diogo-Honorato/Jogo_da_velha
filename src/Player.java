public class Player {

    private String nome;
    private int pontos; 
    private char sinal;

    Player(String nome, int pontos, char sinal){

        this.nome = nome;
        this.pontos = pontos;
        this.sinal = sinal;
    }


    public String getNome() {
        return nome;
    }
    public int getPontos() {
        return pontos;
    }
    public char getSinal() {
        return sinal;
    }
    
}
