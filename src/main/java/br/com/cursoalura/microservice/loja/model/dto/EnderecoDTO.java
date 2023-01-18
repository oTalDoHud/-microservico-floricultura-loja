package br.com.cursoalura.microservice.loja.model.dto;

public class EnderecoDTO {

    private String rua;
    private int numero;
    private String estado;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EnderecoDTO{");
        sb.append("rua='").append(rua).append('\'');
        sb.append(", numero=").append(numero);
        sb.append(", estado='").append(estado).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
