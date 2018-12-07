package CENRALSQ

class SqtDetalleFactura {
    int partida
    Double cantidad
    String descripcion
    Double precioUnitario
    Double subTotal
    Double montoIva
    Double montoFs
    int unidadesFs
    int imprimir
    int enviado
    Double montoIsb
    String catSat

    static belongsTo = [ajuste:SqtFactura]

    static constraints = {
        descripcion maxSize: 50
        catSat maxSize: 50
    }
}
