package marchi.diogo.a05_controleabastecimento;

/**
 * Created by 6427626 on 23/10/2018.
 */

public class Abastecimento {
    private Float quilometragem;
    private Float litro;
    private String nomePosto;
    private String data;




    public String getNomePosto() {

        return nomePosto;
    }

    public void setNomePosto(String nomePosto)
    {
        this.nomePosto = nomePosto;
    }

    public String getData() {

        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Float getLitro() {
        return litro;
    }

    public void setLitro(Float litro) {
        this.litro = litro;
    }
}
