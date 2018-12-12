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

        enviado nullable:true

    }
}
