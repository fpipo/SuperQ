package CENTRALSQ

class SqtInventarioGeneral {


    String descripcion
    Date fecha
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus




    static constraints = {
        enviado nullable:true
    }
}
