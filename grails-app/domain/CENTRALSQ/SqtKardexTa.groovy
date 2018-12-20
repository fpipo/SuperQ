package CENTRALSQ

class SqtKardexTa {
    String autcod
    String telefono
    Date fecha
    int enviado
    String transaccion
    String legal
    String ticket

    SqtVenta venta
    SqtTienda tienda
    SqtProducto producto
    SqtMovimiento movimiento

    static constraints = {
        autcod maxSize: 50
        telefono maxSize: 20, nullable: true
        fecha nullable: true
        transaccion maxSize: 200, nullable: true
        enviado nullable:true
        legal maxSize: 255, nullable: true
        ticket maxSize: 1, nullable: true
    }
}
