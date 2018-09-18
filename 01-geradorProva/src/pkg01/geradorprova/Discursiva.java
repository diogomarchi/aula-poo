/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author Diogo
 */
final class Discursiva extends Questao{ 
    private String criteriosCorrecao;

    /**
     * @return the criteriosCorrecao
     */
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    /**
     * @param criteriosCorrecao the criteriosCorrecao to set
     */
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }

    public String seImprime() {
        String retorno = "";
        retorno = retorno + "(" + this.getPeso() + ") ";
        retorno = retorno + this.getPergunta() + "\r\n";
        retorno += "-------------------------------------------\r\n";
        retorno += "-------------------------------------------\r\n";
        retorno += "--------------------------------------------\r\n";
        retorno = retorno + "Criterio de avaliacao: " + this.getCriteriosCorrecao() + "\r\n";
        retorno += "###################################\r\n";
        return retorno;
    }
}