package CENRALSQ

class SqtAlmacen {
    String descripcion
    String tipo
    int inventariable
    int enviado

    static constraints = {
        descripcion maxSize: 50
        tipo maxSize: 2
    }
}
