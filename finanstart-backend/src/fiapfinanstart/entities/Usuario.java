package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;
import java.util.UUID;

public class Usuario {

    private UUID idUsuario;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String ddd;
    private String telefone;
    private boolean logado = false;



    public Usuario(String nome, String cpf, String email, String senha, String ddd, String telefone ) {
        this.idUsuario = RandomUuidCreator.getRandomUuid();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public Usuario(String usuario, String senha) {
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean doLogin(String senha, String loginSenha) {
        if (this.senha.equals(senha)) {
            logado = true;
            return true;
        }
        return false;
    }

    public void doLogout() {
        logado = false;
    }

    public boolean estaLogado() {
        return logado;
    }
}
