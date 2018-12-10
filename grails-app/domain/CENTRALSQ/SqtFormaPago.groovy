package CENTRALSQ

class SqtFormaPago {
    String clave
    String descripcion
    String tipo
    String cuentaContable
    int validaCantidad
    int enviado
    int orden

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50
        tipo maxSize: 2, nullable: true
        cuentaContable maxSize: 30, nullable: true
    }
}
