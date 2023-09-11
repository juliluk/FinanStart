package fiapfinanstart.repository;

import fiapfinanstart.entities.CartaoCredito;

public interface ICartaoCredito {

    Boolean validar(Double valorCartao, CartaoCredito cartaoCredito);
    CartaoCredito atualizar(Double valorCartao,  CartaoCredito cartaoCredito);
}
