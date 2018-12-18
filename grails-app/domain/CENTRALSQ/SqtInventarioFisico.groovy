package CENTRALSQ

class SqtInventarioFisico {
    int	partida
    Date fecha
    String inicial
    Double existencia
    Double entradas
    Double salidas
    int ajustado
    Date fechaMod
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtProducto producto
    SqtUsuario usuarioMod

    static constraints = {
        entradas nullable:true
        salidas nullable:true
        ajustado nullable:true
        inicial maxSize: 10
        enviado nullable:true
    }
}
