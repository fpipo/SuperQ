package CENTRALSQ

class SqtCuentaContable {

    String cuentaContable
    String descripcion
    int enviado

    static constraints = {
        cuentaContable maxSize: 30
        descripcion maxSize: 50 , nullable: true
        enviado nullable:true
    }
}
