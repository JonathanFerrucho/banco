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
public class Body {

    private ReferenciaFactura referenciaFactura;
    private PagoResource pagoResource;

    @XmlElement(name="ReferenciaFactura", namespace = "http://www.servicios.co/pagos/schemas")
    public ReferenciaFactura getReferenciaFactura() {
        return referenciaFactura;
    }
    
    public void setReferenciaFactura(ReferenciaFactura referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
    }
    
    @XmlElement(name="PagoResource", namespace = "http://www.servicios.co/pagos/schemas")
    public PagoResource getPagoResource() {
        return pagoResource;
    }

    public void setPagoResource(PagoResource pagoResource) {
        this.pagoResource = pagoResource;
    }
    
    
}
