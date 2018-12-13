package CENTRALSQ

class SqtTienda {
    String id
    String descripcion
    String tipo
    String centroCostos
    Date fechaApertura
    String serie
    String usuarioMod
    Date fechaMod
    int enviado
    String cc
    SqtDireccion direccion


    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        descripcion maxSize: 80, nullable: false
        tipo maxSize: 2, nullable: false
        centroCostos maxSize: 30, nullable: false
        serie maxSize: 5, nullable: false
        cc maxSize: 3, nullable: false
        usuarioMod maxSize: 15
    }
}
