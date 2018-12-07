package CENRALSQ

class SqtCuentaContable {
    String cuentaContable
    String descripcion
    int enviado

    static constraints = {
        cuentaContable maxSize: 10, nullable: false
        descripcion maxSize: 50, nullable: false
    }
}
