import fiapfinanstart.entities.*;
import fiapfinanstart.repository.impl.CartaoCreditoImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Transacao> transacoes = new ArrayList<>();

        Map<String, Usuario> usuario = new HashMap<>();
        Map<String, CartaoCredito> cartaoCredito = new HashMap<>();

        CartaoCreditoImpl cartaoCreditoImpl = new CartaoCreditoImpl();

        Usuario novoUsuario = null;
        CartaoCredito novoCartaoCredito = null;

        while (true) {

            if(novoUsuario == null)
                System.out.println("Bem vindo ao FinanStart!");
            else
                System.out.println("Você é usuário novo do FinanStart!");

            System.out.print("Escolha uma opção: \n");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("CPF: ");
                    String cpf = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Senha: ");
                    String senha = scanner.next();
                    System.out.print("DDD: ");
                    String ddd = scanner.next();
                    System.out.print("Telefone: ");
                    String telefone = scanner.next();

                    novoUsuario = new Usuario(nome, cpf, email, senha, ddd, telefone);
                    usuario.put(cpf, novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso!");

                    break;
                case 2:
                    System.out.print("CPF: ");
                    String loginCPF = scanner.next();
                    System.out.print("Senha: ");
                    String loginSenha = scanner.next();

                    Usuario usuarioLogado = usuario.get(loginCPF);
                    if (usuarioLogado != null && usuarioLogado.doLogin(usuarioLogado.getSenha(), loginSenha)) {
                        System.out.println("Login realizado com sucesso.");
                        System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");

                        while (true) {
                            System.out.print("Escolha uma opção: \n");
                            System.out.println("4 - Incluir Despesa");
                            System.out.println("5 - Incluir Receita");
                            System.out.println("6 - Incluir Despesas Cartão de Crédito");
                            System.out.println("7 - Listar Transações");
                            System.out.println("8-  Sair");
                            opcao = scanner.nextInt();

                            String dateInString = null;
                            DateTimeFormatter dtf = null;

                            switch (opcao) {
                                case 4:
                                    System.out.print("Descrição da Despesa: ");
                                    String descricaoDespesa = scanner.next();
                                    System.out.print("Valor da Despesa: ");
                                    double valorDespesa = scanner.nextDouble();

                                    System.out.print("Data de Despesa: ");
                                    dateInString = scanner.next();

                                    dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate dtTransacaoDespesa = null;
                                    try {
                                        dtTransacaoDespesa = LocalDate.parse(dateInString, dtf);

                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println("Data inválida. Tente novamente!");
                                        break;
                                    }
                                    
                                    transacoes.add(new Despesa( descricaoDespesa, valorDespesa, dtTransacaoDespesa));
                                    System.out.println("Despesa incluída com sucesso!");
                                    break;
                                case 5:
                                    System.out.print("Descrição da Receita: ");
                                    String descricaoReceita = scanner.next();
                                    System.out.print("Valor da Receita: ");
                                    double valorReceita = scanner.nextDouble();

                                    System.out.print("Data de Receita: ");
                                    dateInString = scanner.next();

                                    dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate dtTransacaoReceita = null;
                                    try {
                                        dtTransacaoReceita = LocalDate.parse(dateInString, dtf);

                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println("Data inválida. Tente novamente!");
                                        break;
                                    }

                                    transacoes.add(new Receita(descricaoReceita, valorReceita, dtTransacaoReceita));
                                    System.out.println("Receita incluída com sucesso!");
                                    break;

                                case 6:
                                    System.out.print("Escolha uma opção: \n");
                                    System.out.println("1 - Inserir Cartão");
                                    System.out.println("2 - Incluir Despesas Cartão");
                                    System.out.println("3 - Sair");

                                    opcao = scanner.nextInt();

                                    switch (opcao) {
                                        case 1:
                                            /*Cadastrar Cartão*/
                                            System.out.print("Nome do Cartão: ");
                                            String nomeCartao = scanner.next();
                                            System.out.print("Limite: ");
                                            double limiteCartao = scanner.nextDouble();

                                            System.out.print("Dia de Fechamento: ");
                                            int diaFechamento = scanner.nextInt();
                                            System.out.print("Dia de Vencimento: ");
                                            int diaVencimento = scanner.nextInt();

                                            novoCartaoCredito = new CartaoCredito(nomeCartao, limiteCartao,diaFechamento,diaVencimento);
                                            cartaoCredito.put(usuarioLogado.getCpf(), novoCartaoCredito);
                                            System.out.println("Cartão de Creditp cadastrado com sucesso!");

                                            break;
                                        case 2:
                                            /*Cadastrar Cartão*/
                                            System.out.print("Digite o CPF propretário do Cartão: ");
                                            String findCPF = scanner.next();

                                            CartaoCredito cc = cartaoCredito.get(findCPF);
                                            if (cc != null ) {

                                                System.out.print("Descrição da Despesa no Cartão: ");
                                                String descricaoDespesaCartao = scanner.next();

                                                System.out.print("Valor da Despesa no Cartão: ");
                                                double valorDespesaCartao = scanner.nextDouble();

                                                if(cartaoCreditoImpl.validar(valorDespesaCartao, cc)) {

                                                    System.out.print("Data Fechamento dp Cartão de Crédito: ");
                                                    dateInString = scanner.next();

                                                    dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                                    LocalDate dtTransacaoDespesaCartao = null;
                                                    try {
                                                        dtTransacaoDespesaCartao = LocalDate.parse(dateInString, dtf);

                                                    } catch (java.time.format.DateTimeParseException e) {
                                                        System.out.println("Data inválida. Tente novamente!");
                                                        break;
                                                    }

                                                    CartaoCredito t = new CartaoCredito(descricaoDespesaCartao, valorDespesaCartao, dtTransacaoDespesaCartao);

                                                    cc = cartaoCreditoImpl.atualizar(valorDespesaCartao, cc);
                                                    t.setIdCredito(cc.getIdCredito());
                                                    t.setNomeCartao(cc.getNomeCartao());
                                                    t.setDiaFechamento(cc.getDiaFechamento());
                                                    t.setDiaVencimento(cc.getDiaVencimento());
                                                    t.setLimite(cc.getLimite());
                                                    t.setDtTransacao(LocalDate.now());

                                                    transacoes.add(t);

                                                    System.out.println("Despesa no Cartão incluída com sucesso!");
                                                }
                                                else {
                                                    System.out.println("Limte de saldo excedido. Tente novamente!");
                                                }
                                            }
                                            else{
                                                System.out.println("Dados do cartão de crédito não existe. Tente novamente.");
                                            }

                                            break;
                                    }


                                    break;

                                case 7:
                                    new Main().listar(transacoes);
                                    break;
                                case 8:
                                    System.out.println("Encerrando o programa.");
                                    scanner.close();
                                    System.exit(0);
                                    break;
                            }
                        }
                    }
                    else{
                        novoUsuario = null;
                        System.out.println("Email ou senha incorretos. Tente novamente.");
                    }

                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");

                    break;
            }

        }

    }
    private void imprimir(Transacao transacao){
        //System.out.println("Chave Transação: " + transacao.getIdTransacao());
        System.out.println("Chave Transação: ****" );
        System.out.println("Descrição Transação: " + transacao.getDescricao());
        System.out.println("Valor Transação: " + transacao.getVlTransacao());
        System.out.println("Data Transação: " + transacao.getDtTransacao());
    }

    private void imprimircc(CartaoCredito transacao){
        //System.out.println("Chave Transação: " + transacao.getIdTransacao());
        System.out.println("Chave Transação: ****" );
        System.out.println("Descrição Transação: " + transacao.getDescricao());
        System.out.println("Valor Transação: " + transacao.getVlTransacao());
        System.out.println("Data Transação: " + transacao.getDtTransacao());
        System.out.println("Valor Limite Cartão de Crédito: " + transacao.getLimite());
    }
    private void listar(List<Transacao> transacoes ){
        for (Transacao transacao : transacoes) {
            String nomeTransacao = transacao.getClass().getSimpleName();

            if(nomeTransacao == "CartaoCredito") nomeTransacao = "Cartão de Credito";

            System.out.println("Listagem de Transações de " + nomeTransacao);

            if (transacao instanceof Despesa) {
                new Main().imprimir(transacao);
            } else if (transacao instanceof Receita) {
                new Main().imprimir(transacao);
            } else if (transacao instanceof Cartao) {
                new Main().imprimir(transacao);
            } else if (transacao instanceof CartaoCredito) {
                new Main().imprimircc((CartaoCredito)transacao);
            }
        }
    }
}