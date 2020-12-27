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
public class Resultado {

    private ReferenciaFactura referenciaFactura;
    private String mensaje;

    @XmlElement(name = "referenciaFactura", namespace = "http://www.servicios.co/pagos/schemas")
    public ReferenciaFactura getReferenciaFactura() {
        return referenciaFactura;
    }

    public void setReferenciaFactura(ReferenciaFactura referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
    }

    @XmlElement(name = "mensaje", namespace = "http://www.servicios.co/pagos/schemas")
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
