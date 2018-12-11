package br.univali.marchiedu.diogo.a05_controleabastecimento;

public class Abastecimento {
    private long id;
    private Float quilometragem;
    private Float litro;
    private String nomePosto;
    private String data;
    private double latitude;
    private  double longitude;




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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
