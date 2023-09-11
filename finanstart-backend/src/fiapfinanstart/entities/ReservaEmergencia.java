package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;

import java.time.LocalDate;
import java.util.UUID;

public class ReservaEmergencia {

    private UUID idReserva;
    private double totalDespesas;
    private double vlTotal;
    private double vlAtual;
    private LocalDate dtAtualizacao;

    public UUID getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(UUID idReserva) {
        this.idReserva = idReserva;
    }

    public double getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(double totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public double getVlAtual() {
        return vlAtual;
    }

    public void setVlAtual(double vlAtual) {
        this.vlAtual = vlAtual;
    }

    public LocalDate getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(LocalDate dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public ReservaEmergencia(double totalDespesas, double vlTotal, double vlAtual, LocalDate dtAtualizacao) {
        this.idReserva = RandomUuidCreator.getRandomUuid();;
        this.totalDespesas = totalDespesas;
        this.vlTotal = vlTotal;
        this.vlAtual = vlAtual;
        this.dtAtualizacao = dtAtualizacao;
    }
}
