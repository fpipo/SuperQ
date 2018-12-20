package CENTRALSQ

class SqtPagoIusa {
    int resultado
    int folioIusa
    String contrato
    String nombreCliente
    String modalidadPago
    Date fechaPago
    Double subtotal
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
        resultado  nullable: true
        folioIusa  nullable: true
        contrato maxSize: 150, nullable: true
        nombreCliente maxSize: 150, nullable: true
        modalidadPago maxSize: 100, nullable: true
        fechaPago  nullable: true
        subtotal  nullable: true
        iva  nullable: true
        comision nullable: true
        total  nullable: true
        equipo maxSize: 50, nullable: true
        operador maxSize: 20, nullable: true
        servicioIusa  nullable: true
        desError maxSize: 150, nullable: true
        medidor maxSize: 150, nullable: true
        dependenciaNombre maxSize: 100, nullable: true
        dependenciaRfc maxSize: 13, nullable: true
        dependenciaDir maxSize: 500, nullable: true
        domicilio maxSize: 50, nullable: true
        poblacion maxSize: 50, nullable: true
        cuenta maxSize: 50, nullable: true
        tarifa maxSize: 20, nullable: true
        enviado nullable:true
        venta  nullable: true
        fechaAlta nullable: true
    }
}
