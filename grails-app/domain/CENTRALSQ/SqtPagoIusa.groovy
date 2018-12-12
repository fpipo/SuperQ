package CENTRALSQ

class SqtPagoIusa {
    int resultado
    int folioIusa
    String contrato
    String nombreCliente
    String modalidadPago
    Date fechaPago
    Double subTotal
    Double iva
    Double comision
    Double total
    String equipo
    String operador
    String desError
    int servicioIusa
    String medidor
    int enviado
    String dependenciaNombre
    String dependenciaRfc
    String dependenciaDir
    String domicilio
    String poblacion
    String cuenta
    Date fechaAlta

    String tarifa
    SqtTienda tienda
    SqtVenta venta
    SqtCaja caja

    static constraints = {
        contrato maxSize: 150
        nombreCliente maxSize: 150
        modalidadPago maxSize: 100
        equipo maxSize: 50
        operador maxSize: 20
        desError maxSize: 150
        medidor maxSize: 150
        dependenciaNombre maxSize: 100
        dependenciaRfc maxSize: 20
        dependenciaDir maxSize: 500
        domicilio maxSize: 50
        poblacion maxSize: 50
        cuenta maxSize: 50
        tarifa maxSize: 20
        enviado nullable:true
    }
}
