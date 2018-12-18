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
    String referenciaTransaccion
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
    SqtKardex kardex

    static constraints = {
        idCorresponsal maxSize: 20, nullable: true
        corresponsal maxSize: 100, nullable: true
        idTerminal nullable: true
        idOficina nullable: true
        oficina maxSize: 300, nullable: true
        mac maxSize: 20, nullable: true
        usuario maxSize:200, nullable: true
        nombreOperador maxSize: 100, nullable: true
        maternoOperador maxSize: 50, nullable: true
        paternoOperador maxSize: 50, nullable: true
        nombreOperacion maxSize: 200, nullable: true
        fechaTransaccion maxSize: 200, nullable: true
        horaTransaccion maxSize: 15, nullable: true
        iduOperacion maxSize: 100, nullable: true
        folio maxSize: 100, nullable: true
        referenciaTransaccion maxSize: 100, nullable: true
        importe nullable: true
        comision nullable: true
        iva nullable: true
        total nullable: true
        importeRecibido nullable: true
        cambio nullable: true
        numeroAutorizacion maxSize: 100, nullable: true
        letra maxSize: 1000, nullable: true
        enviado nullable:true
    }
}
