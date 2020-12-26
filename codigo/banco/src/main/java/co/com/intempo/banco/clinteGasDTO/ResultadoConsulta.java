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
public class ResultadoConsulta {

    private ReferenciaFactura referenciaFactura;
    private Double totalPagar;

    @XmlElement(name = "ReferenciaFactura", namespace = "http://www.servicios.co/pagos/schemas")
    public ReferenciaFactura getReferenciaFactura() {
        return referenciaFactura;
    }

    public void setReferenciaFactura(ReferenciaFactura referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
    }
    
    @XmlElement(name = "totalPagar", namespace = "http://www.w3.org/2001/XMLSchema")
    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
