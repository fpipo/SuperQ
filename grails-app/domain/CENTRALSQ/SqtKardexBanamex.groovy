package CENTRALSQ

class SqtKardexBanamex {
    String idCorresponsal
    String corresponsal
    int idOficina
    String oficina
    int idTerminal
    String mac
    SqtUsuario usuario
    String nombreOperador
    String maternoOperador
    String paternoOperador
    String nombreOperacion
    String fechaTransaccion
    String horaTransaccion
    String iduOperacion
    String folio
    String referenciaTransacion
    Double importe
    Double comision
    Double iva
    Double total
    Double importeRecibido
    Double cambio
    String numeroAutorizacion
    String letra
    int enviado

    SqtTienda tienda


    static constraints = {

        idCorresponsal maxSize: 20
        corresponsal maxSize: 100
        oficina maxSize: 300
        mac maxSize: 20
        usuario maxSize:200
        nombreOperador maxSize: 100
        maternoOperador maxSize: 50
        paternoOperador maxSize: 50
        nombreOperacion maxSize: 200
        fechaTransaccion maxSize: 200
        horaTransaccion maxSize: 15
        iduOperacion maxSize: 100
        folio maxSize: 100
        referenciaTransacion maxSize: 100
        numeroAutorizacion maxSize: 100
        letra maxSize: 1000
        enviado nullable:true




    }
}
