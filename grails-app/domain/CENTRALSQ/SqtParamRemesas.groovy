package CENTRALSQ

class SqtParamRemesas {
    int comercio
    String sucursal
    int corresponsal
    String codigo
    String operador
    int entreMode
    SqtTienda tienda
    Double maximo
    Double minimo
    Date horaMin
    Date horaMax



    static constraints = {
        tienda  nullable: true
        maximo nullable: true
        minimo nullable: true
        horaMax nullable: true
        horaMin nullable: true
    }
}
