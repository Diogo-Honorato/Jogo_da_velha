public class Player {

    private String nome;
    private char sinal;

    Player(String nome, char sinal){

        this.nome = nome;
        this.sinal = sinal;
    }


    public String getNome() {
        return nome;
    }
    public char getSinal() {
        return sinal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSinal(char sinal) {
        this.sinal = sinal;
    }
}
