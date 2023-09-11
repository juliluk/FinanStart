package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;

import java.time.LocalDate;
import java.util.UUID;

public class CartaoCredito extends Transacao{
    private UUID idCredito;
    private String nomeCartao;
    public double limite;
    private int diaFechamento;
    private int diaVencimento;

    public CartaoCredito (String nomeCartao, double limite, int diaFechamento, int diaVencimento){
        this.idCredito = RandomUuidCreator.getRandomUuid();
        this.nomeCartao = nomeCartao;
        this.limite = limite;
        this.diaFechamento = diaFechamento;
        this.diaVencimento = diaVencimento;

    }
    public CartaoCredito(String descricao, Double vlTransacao, LocalDate dtTransacao){
        super(descricao, vlTransacao, dtTransacao);
    }

    public UUID getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(UUID idCredito) {
        this.idCredito = idCredito;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getDiaFechamento() {
        return diaFechamento;
    }

    public void setDiaFechamento(int diaFechamento) {
        this.diaFechamento = diaFechamento;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public void subtrairDespesaCartao(double valor) {
        limite -= valor;
    }


}
