package MapaSistema2.mapaModel;

import java.math.BigInteger;

public class Infermeira {
    protected String nome;
    protected String cpf;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf.toString(0);
    }
}
