package CENTRALSQ

class SqtTienda {
    String id
    String descripcion
    String tipo
    String centroCostos
    Date fechaApertura
    String serie
    Date fechaMod
    int enviado
    String cc
    SqtDireccion direccion
    SqtUsuario usuarioMod

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        descripcion maxSize: 80
        tipo maxSize: 2
        centroCostos maxSize: 30
        serie maxSize: 5
        cc maxSize: 3
    }
}
