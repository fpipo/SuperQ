package CENTRALSQ

class SqtReembolsoFormaPago {
    int aplica
    int enviado
    SqtReembolso reembolso
    SqtFormaPago formaPago

    static constraints = {
        aplica nullable: true
        enviado nullable:true
    }
}
