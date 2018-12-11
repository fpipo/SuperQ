package CENTRALSQ

class SqtBitacora {
    String id
    Date fecha
    int enviado

    SqtTienda tienda
    SqtUsuario usuario
    SqtTransaccion transaccion

    static mapping = {
        id generator: 'uuid', name:'id'
    }
    static constraints = {
        enviado nullable:true
    }
}
