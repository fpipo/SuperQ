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
    String usuarioMod
    int enviado


    SqtTienda tienda
    SqtProducto producto

    static constraints = {
        inicial maxSize: 10
        usuarioMod maxSize: 15
        enviado nullable:true

    }
}
