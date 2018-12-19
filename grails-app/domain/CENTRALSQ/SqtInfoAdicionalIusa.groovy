package CENTRALSQ

class SqtInfoAdicionalIusa {
    String info
    Double valor
    int enviado

    SqtVenta venta

    static constraints = {
        info maxSize: 50, nullable: true
        valor nullable: true
        enviado nullable: true
    }
}
