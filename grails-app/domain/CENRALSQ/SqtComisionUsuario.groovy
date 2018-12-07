package CENRALSQ

class SqtComisionUsuario {
    Date fechaInicio
    String mes
    String anio
    Double pctComision
    Date fechaMod
    int enviado
    Double bono
    SqtTienda tienda
    SqtUsuario usuario

    static constraints = {
        mes maxSize: 2, nullable: false
        anio maxSize: 4, nullable: false
    }
}
