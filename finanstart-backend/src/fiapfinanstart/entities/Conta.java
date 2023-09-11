package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;

import java.util.UUID;

public class Conta {

    private UUID idConta;
    private String nomeConta;
    public double saldo;

    public Conta(String nomeConta, double saldo) {
        this.idConta = RandomUuidCreator.getRandomUuid();;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
    }

    public Conta() {}

    public UUID getIdConta() {
        return idConta;
    }

    public void setIdConta(UUID idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void subtrairDespesa(double valor) {
        saldo -= valor;
    }

    public void somarReceita(double valor) {
        saldo += valor;
    }

}
