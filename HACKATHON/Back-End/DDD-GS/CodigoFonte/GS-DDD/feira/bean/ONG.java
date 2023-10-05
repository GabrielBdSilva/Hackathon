package feira.bean;
public class ONG {
    private String nome;
    private String endereco;
    private String contatoResponsavel;
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String areaAtuacao;

    public ONG(String nome, String endereco, String contatoResponsavel, String nomeResponsavel, String cpfResponsavel,
            String areaAtuacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.contatoResponsavel = contatoResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.areaAtuacao = areaAtuacao;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(String contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    //realiza a sobrescrita do método toString() da classe Object.
    public String toString() {
        return "ONG - ( Nome da ONG: " + nome + " | Endereco da ONG: " + endereco + " | Contato do Responsavel: " + contatoResponsavel
                + " | Nome do Responsavel: " + nomeResponsavel + " | CPF do Responsavel: " + cpfResponsavel + " | Area de Atuacao da ONG: "
                + areaAtuacao + " )";
    }
}
