package feira.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import feira.bean.Barraca;
import feira.bean.ONG;
import feira.bean.Pessoa;
import feira.bean.Contato;


public class CadastroFeira {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Barraca> barracas = new ArrayList<>();
    private static List<Pessoa> pessoas = new ArrayList<>();
    private static List<ONG> ongs = new ArrayList<>();
    private static List<Contato> contatos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de gerenciamento da feira!");
        while (true) {
            exibirMenuPrincipal();
            try {
                int opcao = lerOpcao();
                realizarAcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite apenas números.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1 - Cadastrar Barraca");
        System.out.println("2 - Cadastrar Pessoa");
        System.out.println("3 - Cadastrar ONG");
        System.out.println("4 - Remover Barraca");
        System.out.println("5 - Buscar Barraca por Nome");
        System.out.println("6 - Adicionar Foto a Barraca");
        System.out.println("7 - Listar Barracas");
        System.out.println("8 - Listar Pessoas");
        System.out.println("9 - Listar ONGs");
        System.out.println("10 - Associar Contato a Pessoa");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        return Integer.parseInt(scanner.nextLine());
    }

    //recebe a opção escolhida pelo usuário como parâmetro e realiza a ação correspondente.
    private static void realizarAcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarBarraca();
                break;
            case 2:
                cadastrarPessoa();
                break;
            case 3:
                cadastrarONG();
                break;
            case 4:
                removerBarraca();
                break;
            case 5:
                buscarBarracaPorNome();
                break;
            case 6:
                adicionarFotoABarraca();
                break;
            case 7:
                listarBarracas();
                break;
            case 8:
                listarPessoas();
                break;
            case 9:
                listarONGs();
                break;
            case 10:
                cadastrarContato();
                break;
            case 0:
                System.out.println("Obrigado por utilizar o sistema. Até mais!");
                System.exit(0);
            default:
                System.out.println("Opção inválida. Digite um número válido.");
        }
    }

    // permite cadastrar uma nova barraca através de interação com o usuário.
    private static void cadastrarBarraca() {
        System.out.println("==== CADASTRO DE BARRACA ====");
        System.out.print("Nome da barraca: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço da barraca: ");
        String endereco = scanner.nextLine();
        System.out.print("Posicao de onde está a barraca(ex:A1): ");
        String posicao = scanner.nextLine();
        System.out.print("Responsável pela barraca: ");
        String responsavel = scanner.nextLine();
        System.out.print("Fruta(s) da barraca: ");
        String fruta = scanner.nextLine();

        Barraca barraca = new Barraca(nome, endereco, posicao, responsavel, fruta);

        while (true) {
            System.out.print("Digite o nome do arquivo da foto(url) (ou 'sair' para finalizar): ");
            String nomeFoto = scanner.nextLine();

            if (nomeFoto.equalsIgnoreCase("sair")) {
                break;
            }

            barraca.adicionarFoto(nomeFoto);
            System.out.println("Foto adicionada com sucesso!");
        }

        barracas.add(barraca);
        System.out.println("Barraca cadastrada com sucesso!");
    }
    //permite cadastrar uma nova pessoa através de interação com o usuário.
    private static void cadastrarPessoa() {
        System.out.println("==== CADASTRO DE PESSOA ====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Quantidade de Residentes na Casa: ");
        int quantResidente = Integer.parseInt(scanner.nextLine());
        System.out.print("Foto do Comprovante de Desemprego (url): ");
        String comprovanteDesemprego = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, cpf, quantResidente, comprovanteDesemprego);
        pessoas.add(pessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    //permite cadastrar uma nova ONG através de interação com o usuário.
    private static void cadastrarONG() {
        System.out.println("==== CADASTRO DE ONG ====");
        System.out.print("Nome da ONG: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço da ONG: ");
        String endereco = scanner.nextLine();
        System.out.print("Contato do responsável: ");
        String contatoResponsavel = scanner.nextLine();
        System.out.print("Nome do responsável: ");
        String nomeResponsavel = scanner.nextLine();
        System.out.print("CPF do responsável: ");
        String cpfResponsavel = scanner.nextLine();
        System.out.print("Área de atuação da ONG: ");
        String areaAtuacao = scanner.nextLine();

        ONG ong = new ONG(nome, endereco, contatoResponsavel, nomeResponsavel, cpfResponsavel, areaAtuacao);
        ongs.add(ong);
        System.out.println("ONG cadastrada com sucesso!");
    }

    //permite remover uma barraca através de interação com o usuário
    private static void removerBarraca() {
        System.out.println("==== REMOVER BARRACA ====");
        System.out.print("Digite o nome da barraca a ser removida: ");
        String nomeBarraca = scanner.nextLine();

        boolean encontrada = false;
        for (Barraca barraca : barracas) {
            if (barraca.getNome().equalsIgnoreCase(nomeBarraca)) {
                barracas.remove(barraca);
                encontrada = true;
                System.out.println("Barraca removida com sucesso!");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Barraca não encontrada.");
        }
    }

    //permite buscar uma barraca por nome através de interação com o usuário
    private static void buscarBarracaPorNome() {
        System.out.println("==== BUSCAR BARRACA POR NOME ====");
        System.out.print("Digite o nome da barraca a ser buscada: ");
        String nomeBarraca = scanner.nextLine();

        boolean encontrada = false;
        for (Barraca barraca : barracas) {
            if (barraca.getNome().equalsIgnoreCase(nomeBarraca)) {
                System.out.println(barraca);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Barraca não encontrada.");
        }
    }

    //permite adicionar uma foto a uma barraca através de interação com o usuário
    private static void adicionarFotoABarraca() {
        System.out.println("==== ADICIONAR FOTO A BARRACA ====");
        System.out.print("Digite o nome da barraca: ");
        String nomeBarraca = scanner.nextLine();

        boolean encontrada = false;
        for (Barraca barraca : barracas) {
            if (barraca.getNome().equalsIgnoreCase(nomeBarraca)) {
                System.out.print("Digite o nome do arquivo da foto(url): ");
                String nomeFoto = scanner.nextLine();
                barraca.adicionarFoto(nomeFoto);
                System.out.println("Foto adicionada com sucesso!");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Barraca não encontrada.");
        }
    }
    //lista todas as barracas cadastradas.
    private static void listarBarracas() {
        System.out.println("==== LISTAR BARRACAS ====");
        if (barracas.isEmpty()) {
            System.out.println("Não há barracas cadastradas.");
        } else {
            for (Barraca barraca : barracas) {
                System.out.println(barraca);
            }
        }
    }
    
    //lista todas as pessoas cadastradas.
    private static void listarPessoas() {
        System.out.println("==== LISTAR PESSOAS ====");
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }

    private static void listarONGs() {
        System.out.println("==== LISTAR ONGs ====");
        if (ongs.isEmpty()) {
            System.out.println("Não há ONGs cadastradas.");
        } else {
            for (ONG ong : ongs) {
                System.out.println(ong);
            }
        }
    }
    private static Pessoa buscarPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equalsIgnoreCase(cpf)) {
                return pessoa;
            }
        }
        return null;
    }

    private static void cadastrarContato() {
        System.out.println("==== CADASTRO DE CONTATO ====");
        System.out.print("Digite o tipo de contato (1 - Telefone/Email, 2 - Endereço/Cidade/Estado): ");
        int tipoContato = Integer.parseInt(scanner.nextLine());

        if (tipoContato == 1) {
            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Digite o email: ");
            String email = scanner.nextLine();

            Contato contato = new Contato(telefone, email);
            contatos.add(contato);
        
            System.out.print("Digite o CPF da Pessoa para associar o contato: ");
            String cpf = scanner.nextLine();
            Pessoa pessoa = buscarPessoa(cpf);
            if (pessoa != null) {
                pessoa.setContato(contato);
                System.out.println("Contato associado com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada. O contato não foi associado.");
        }
        } else if (tipoContato == 2) {
            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Digite a cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Digite o estado: ");
            String estado = scanner.nextLine();

            Contato contato = new Contato(endereco, cidade, estado);
            contatos.add(contato);

            System.out.print("Digite o CPF da Pessoa para associar o contato: ");
            String cpf = scanner.nextLine();
            Pessoa pessoa = buscarPessoa(cpf);
            if (pessoa != null) {
                pessoa.setContato(contato);
                System.out.println("Contato associado com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada. O contato não foi associado.");
        }
    } else {
        System.out.println("Opção inválida. Digite um número válido.");
    }
}


}