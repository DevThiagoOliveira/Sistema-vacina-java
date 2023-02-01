package SistemaVacina;

import java.math.BigInteger;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String data1;
    protected String data2;
    protected String data3;
    protected String data4;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf.toString(0);
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }
}