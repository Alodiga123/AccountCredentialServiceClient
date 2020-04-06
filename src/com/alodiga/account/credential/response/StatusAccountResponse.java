/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alodiga.account.credential.response;

import java.io.Serializable;

/**
 *
 * @author ltoro
 */
public class StatusAccountResponse implements Serializable {

    private String codigo;
    private String descripcion;  
    
    private String numero;
    
    private String codigoEstado;
    private String descripcionEstado;
    
    private String codigoEntidad;
    private String descripcionEntidad;
    
    private String sucursal;
    
    private String codigoProducto;
    private String descripcionProducto;
    
    private String codigoPais;
    private String descripcionPais;
    
    private String codigoMoneda;
    private String descripcionMoneda;
    
    private String VIP;
    private String HCC;
    private String ULC;
    private String MCC;
        
    private String MomentoRenewal;
    private String MomentoUltimaActualizacion;
    private String MomentoUltimaOperacionAprobada;
    private String MomentoUltimaOperacionDenegada;    
    private String MomentoUltimoBloqueo;    
    private String MomentoUltimoDesbloqueo;
    
    private String ComprasDisponibles;    
    private String CuotasDisponibles;    
    private String AdelantosDisponibles;    
    private String PrestamosDisponibles;
    
    private String ComprasLimites;
    private String CuotasLimites;
    private String AdelantosLimites;
    private String PrestamosLimites;
    
    private String FechaVencimiento;
    private String Saldo;
    private String PagoMinimo;
    private String SaldoDolar;

    public StatusAccountResponse() {
    }

    public StatusAccountResponse(String codigo, String descripcion, String numero, String codigoEstado, String descripcionEstado, String codigoEntidad, String descripcionEntidad, String sucursal, String codigoProducto, String descripcionProducto, String codigoPais, String descripcionPais, String codigoMoneda, String descripcionMoneda, String VIP, String HCC, String ULC, String MCC, String MomentoRenewal, String MomentoUltimaActualizacion, String MomentoUltimaOperacionAprobada, String MomentoUltimaOperacionDenegada, String MomentoUltimoBloqueo, String MomentoUltimoDesbloqueo, String ComprasDisponibles, String CuotasDisponibles, String AdelantosDisponibles, String PrestamosDisponibles, String ComprasLimites, String CuotasLimites, String AdelantosLimites, String PrestamosLimites, String FechaVencimiento, String Saldo, String PagoMinimo, String SaldoDolar) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.numero = numero;
        this.codigoEstado = codigoEstado;
        this.descripcionEstado = descripcionEstado;
        this.codigoEntidad = codigoEntidad;
        this.descripcionEntidad = descripcionEntidad;
        this.sucursal = sucursal;
        this.codigoProducto = codigoProducto;
        this.descripcionProducto = descripcionProducto;
        this.codigoPais = codigoPais;
        this.descripcionPais = descripcionPais;
        this.codigoMoneda = codigoMoneda;
        this.descripcionMoneda = descripcionMoneda;
        this.VIP = VIP;
        this.HCC = HCC;
        this.ULC = ULC;
        this.MCC = MCC;
        this.MomentoRenewal = MomentoRenewal;
        this.MomentoUltimaActualizacion = MomentoUltimaActualizacion;
        this.MomentoUltimaOperacionAprobada = MomentoUltimaOperacionAprobada;
        this.MomentoUltimaOperacionDenegada = MomentoUltimaOperacionDenegada;
        this.MomentoUltimoBloqueo = MomentoUltimoBloqueo;
        this.MomentoUltimoDesbloqueo = MomentoUltimoDesbloqueo;
        this.ComprasDisponibles = ComprasDisponibles;
        this.CuotasDisponibles = CuotasDisponibles;
        this.AdelantosDisponibles = AdelantosDisponibles;
        this.PrestamosDisponibles = PrestamosDisponibles;
        this.ComprasLimites = ComprasLimites;
        this.CuotasLimites = CuotasLimites;
        this.AdelantosLimites = AdelantosLimites;
        this.PrestamosLimites = PrestamosLimites;
        this.FechaVencimiento = FechaVencimiento;
        this.Saldo = Saldo;
        this.PagoMinimo = PagoMinimo;
        this.SaldoDolar = SaldoDolar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getDescripcionEntidad() {
        return descripcionEntidad;
    }

    public void setDescripcionEntidad(String descripcionEntidad) {
        this.descripcionEntidad = descripcionEntidad;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDescripcionPais() {
        return descripcionPais;
    }

    public void setDescripcionPais(String descripcionPais) {
        this.descripcionPais = descripcionPais;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public String getDescripcionMoneda() {
        return descripcionMoneda;
    }

    public void setDescripcionMoneda(String descripcionMoneda) {
        this.descripcionMoneda = descripcionMoneda;
    }

    public String getVIP() {
        return VIP;
    }

    public void setVIP(String VIP) {
        this.VIP = VIP;
    }

    public String getHCC() {
        return HCC;
    }

    public void setHCC(String HCC) {
        this.HCC = HCC;
    }

    public String getULC() {
        return ULC;
    }

    public void setULC(String ULC) {
        this.ULC = ULC;
    }

    public String getMCC() {
        return MCC;
    }

    public void setMCC(String MCC) {
        this.MCC = MCC;
    }

    public String getMomentoRenewal() {
        return MomentoRenewal;
    }

    public void setMomentoRenewal(String MomentoRenewal) {
        this.MomentoRenewal = MomentoRenewal;
    }

    public String getMomentoUltimaActualizacion() {
        return MomentoUltimaActualizacion;
    }

    public void setMomentoUltimaActualizacion(String MomentoUltimaActualizacion) {
        this.MomentoUltimaActualizacion = MomentoUltimaActualizacion;
    }

    public String getMomentoUltimaOperacionAprobada() {
        return MomentoUltimaOperacionAprobada;
    }

    public void setMomentoUltimaOperacionAprobada(String MomentoUltimaOperacionAprobada) {
        this.MomentoUltimaOperacionAprobada = MomentoUltimaOperacionAprobada;
    }

    public String getMomentoUltimaOperacionDenegada() {
        return MomentoUltimaOperacionDenegada;
    }

    public void setMomentoUltimaOperacionDenegada(String MomentoUltimaOperacionDenegada) {
        this.MomentoUltimaOperacionDenegada = MomentoUltimaOperacionDenegada;
    }

    public String getMomentoUltimoBloqueo() {
        return MomentoUltimoBloqueo;
    }

    public void setMomentoUltimoBloqueo(String MomentoUltimoBloqueo) {
        this.MomentoUltimoBloqueo = MomentoUltimoBloqueo;
    }

    public String getMomentoUltimoDesbloqueo() {
        return MomentoUltimoDesbloqueo;
    }

    public void setMomentoUltimoDesbloqueo(String MomentoUltimoDesbloqueo) {
        this.MomentoUltimoDesbloqueo = MomentoUltimoDesbloqueo;
    }

    public String getComprasDisponibles() {
        return ComprasDisponibles;
    }

    public void setComprasDisponibles(String ComprasDisponibles) {
        this.ComprasDisponibles = ComprasDisponibles;
    }

    public String getCuotasDisponibles() {
        return CuotasDisponibles;
    }

    public void setCuotasDisponibles(String CuotasDisponibles) {
        this.CuotasDisponibles = CuotasDisponibles;
    }

    public String getAdelantosDisponibles() {
        return AdelantosDisponibles;
    }

    public void setAdelantosDisponibles(String AdelantosDisponibles) {
        this.AdelantosDisponibles = AdelantosDisponibles;
    }

    public String getPrestamosDisponibles() {
        return PrestamosDisponibles;
    }

    public void setPrestamosDisponibles(String PrestamosDisponibles) {
        this.PrestamosDisponibles = PrestamosDisponibles;
    }

    public String getComprasLimites() {
        return ComprasLimites;
    }

    public void setComprasLimites(String ComprasLimites) {
        this.ComprasLimites = ComprasLimites;
    }

    public String getCuotasLimites() {
        return CuotasLimites;
    }

    public void setCuotasLimites(String CuotasLimites) {
        this.CuotasLimites = CuotasLimites;
    }

    public String getAdelantosLimites() {
        return AdelantosLimites;
    }

    public void setAdelantosLimites(String AdelantosLimites) {
        this.AdelantosLimites = AdelantosLimites;
    }

    public String getPrestamosLimites() {
        return PrestamosLimites;
    }

    public void setPrestamosLimites(String PrestamosLimites) {
        this.PrestamosLimites = PrestamosLimites;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public String getSaldo() {
        return Saldo;
    }

    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }

    public String getPagoMinimo() {
        return PagoMinimo;
    }

    public void setPagoMinimo(String PagoMinimo) {
        this.PagoMinimo = PagoMinimo;
    }

    public String getSaldoDolar() {
        return SaldoDolar;
    }

    public void setSaldoDolar(String SaldoDolar) {
        this.SaldoDolar = SaldoDolar;
    }
    
    

    
}
