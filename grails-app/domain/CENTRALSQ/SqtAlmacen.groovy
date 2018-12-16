package CENTRALSQ

class SqtAlmacen {
    String descripcion
    String tipo
    int inventariable
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: true
        tipo maxSize: 2, nullable: true
        inventariable nullable: true
        enviado nullable: true
    }
}
