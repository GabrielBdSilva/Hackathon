package feira.bean;
public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private int quantResidente;
    private String comprovanteDesemprego;
    private Contato contato;

    public Pessoa(String nome, int idade, String cpf, int quantResidente, String comprovanteDesemprego) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.quantResidente = quantResidente;
        this.comprovanteDesemprego = comprovanteDesemprego;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public String getCpf(){
        return cpf;
    }

    public int getQuantResidente(){
        return quantResidente;
    }

    public String getComprovanteDesemprego(){
        return comprovanteDesemprego;
    }


    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    //realiza a sobrescrita do método toString() da classe Object.
    public String toString() {
        return "Pessoa - ( Nome: " + nome + " | Idade: " + idade +" anos | CPF: " + cpf + " | Quantidade de Residentes: " + quantResidente + " Pessoas | Comprovante de Desemprego(url): " + comprovanteDesemprego + " )\n informações de Contato do(a) "+ nome +": "+contato;
    }
}
