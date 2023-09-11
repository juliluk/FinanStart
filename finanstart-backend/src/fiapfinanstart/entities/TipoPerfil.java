package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;
import java.util.UUID;

public class TipoPerfil {

    private UUID idTipoPerfil;
    private String dsTipoCategoria;

    public UUID getIdTipoPerfil() {
        return idTipoPerfil;
    }

    public void setIdTipoPerfil(UUID idTipoPerfil) {
        this.idTipoPerfil = idTipoPerfil;
    }

    public String getDsTipoCategoria() {
        return dsTipoCategoria;
    }

    public void setDsTipoCategoria(String dsTipoCategoria) {
        this.dsTipoCategoria = dsTipoCategoria;
    }

    public TipoPerfil(String dsTipoCategoria) {
        this.idTipoPerfil = RandomUuidCreator.getRandomUuid();;
        this.dsTipoCategoria = dsTipoCategoria;
    }
}
