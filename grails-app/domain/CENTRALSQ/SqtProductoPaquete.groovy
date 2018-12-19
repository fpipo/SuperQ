package CENTRALSQ

class SqtProductoPaquete {


    Double cantidad
    Double margenUtilidad
    Double precioVentaViva
    Double cantidadPaquete
    Double pctDescuento
    Double montoDescuento
    int sugerido
    Double precioSugerido
    Double margenUtilidadSugerido
    Double precioVentaSiva
    Double montoIva
    Double montoFs
    Double precioCompraSiva
    Double precioCompraCiva
    int enviado
    Double montoIsb

    SqtListaPrecios listaPrecios
    SqtImpuesto impuesto


    static constraints = {
        pctDescuento nullable: true
        sugerido nullable: true
        precioSugerido nullable: true
        margenUtilidadSugerido nullable: true
        montoFs nullable: true
        precioCompraSiva nullable: true
        precioCompraCiva nullable: true
        montoIsb nullable: true
        enviado nullable:true

    }
}
