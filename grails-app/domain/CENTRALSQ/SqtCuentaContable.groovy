package CENTRALSQ

class SqtCuentaContable {

    String cuentaContable
    String descripcion
    int enviado

    static constraints = {
        cuentaContable maxSize: 10
        descripcion maxSize: 50
        enviado nullable:true
    }
}
