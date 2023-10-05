package feira.bean;

public class Contato {
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;

    //essa Sobrecarga permite escolher entre 2 opções de contato pois elas tem atributos diferentes
    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(String endereco, String cidade, String estado) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String geTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    
    public String getEstado() {
        return estado;
    }

    public String toString() {
        if (telefone != null && email != null) {
            return "Telefone: " + telefone + " | Email: " + email;
        } else if (endereco != null && cidade != null && estado != null) {
            return "Endereço: " + endereco + " | Cidade: " + cidade + " | Estado: " + estado;
        } else {
            return "Contato não especificado";
        }
    }
}