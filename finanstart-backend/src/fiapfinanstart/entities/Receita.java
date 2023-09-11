package fiapfinanstart.entities;

import java.time.LocalDate;

public class Receita extends Transacao{
    public Receita(String descricao, Double vlTransacao, LocalDate dtTransacao) {
        super(descricao, vlTransacao, dtTransacao);

        }
    }
