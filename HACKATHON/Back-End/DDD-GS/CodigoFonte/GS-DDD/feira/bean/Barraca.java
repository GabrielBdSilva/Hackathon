package feira.bean;

import java.util.ArrayList;
import java.util.List;

public class Barraca {
    private String nome;
    private String endereco;
    private String posicao;
    private String responsavel;
    private String fruta;
    private List<String> fotos;

    public Barraca(String nome, String endereco,String posicao, String responsavel, String fruta) {
        this.nome = nome;
        this.endereco = endereco;
        this.posicao = posicao;
        this.responsavel = responsavel;
        this.fruta = fruta;
        this.fotos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPosicao(){
        return posicao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    
    public String getFruta() {
        return fruta;
    }
    
    //recebe uma foto como parâmetro e adiciona à lista de fotos da barraca.
    public void adicionarFoto(String foto) {
        fotos.add(foto);
    }

    @Override
    //realiza a sobrescrita do método toString() da classe Object.
    public String toString() {
        return "Barraca "+ posicao + " - ( Nome da Barraca: " + nome + " | Endereco da Barraca: " + endereco + " | Nome do Responsavel: " + responsavel + " | Fruta(s): " + fruta + " | Foto(s) da barraca: " + fotos
                + " )";
    }
}

