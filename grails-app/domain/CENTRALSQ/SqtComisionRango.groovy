package CENTRALSQ

class SqtComisionRango {
    Double rangoInicio
    Double rangoFin
    Double pctComision
    int enviado
    Date fecha

    static constraints = {
        enviado nulluable: true
        rangoFin nullable: true
        pctComision nullable: true
        fecha nullable: true
    }
}
