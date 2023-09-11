package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;
import java.time.LocalDate;
import java.util.UUID;

public class Transacao {
    private UUID idTransacao;
    private String descricao;
    private Double vlTransacao;
    private LocalDate dtTransacao;

    public Transacao(String descricao, Double vlTransacao, LocalDate dtTransacao) {
        this.idTransacao = RandomUuidCreator.getRandomUuid();
        this.descricao = descricao;
        this.vlTransacao = vlTransacao;
        this.dtTransacao = dtTransacao;
    }

    public Transacao() {}
    public UUID getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(UUID idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getVlTransacao() {
        return vlTransacao;
    }

    public void setVlTransacao(double vlTransacao) {
        this.vlTransacao = vlTransacao;
    }

    public LocalDate getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(LocalDate dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

}