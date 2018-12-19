package CENTRALSQ

class SqtHistorialPagoIusa {
    Date fecha
    String clase
    String kwh
    Double importe
    int enviado

    SqtVenta venta

    static constraints = {
        fecha nullable: true
        clase maxSize: 10, nullable: true
        kwh maxSize: 10, nullable: true
        importe nullable: true
        enviado nullable: true
    }
}
