package CENTRALSQ

class SqtRecaudacion {
    String contrato
    Double monto
    Double comision
    Date fechaVencimiento
    Date fechaPago
    String archivo
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado
    String identificador

   SqtTienda tienda
    SqtEstatus estatus


    static constraints = {
        contrato maxSize: 30
        archivo maxSize: 50
        enviado nullable:true
        identificador maxSize: 50
    }
}
