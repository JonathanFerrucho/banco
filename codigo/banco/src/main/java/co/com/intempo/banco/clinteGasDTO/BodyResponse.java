/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.clinteGasDTO;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Dmoviliza
 */
public class BodyResponse {
    
    private ResultadoConsulta resultadoConsulta;
    private Resultado resultado;
    
    @XmlElement(name="ResultadoConsulta", namespace = "http://www.servicios.co/pagos/schemas")
    public ResultadoConsulta getResultadoConsulta() {
        return resultadoConsulta;
    }

    public void setResultadoConsulta(ResultadoConsulta resultadoConsulta) {
        this.resultadoConsulta = resultadoConsulta;
    }
    
    @XmlElement(name="Resultado", namespace = "http://www.servicios.co/pagos/schemas")
    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
