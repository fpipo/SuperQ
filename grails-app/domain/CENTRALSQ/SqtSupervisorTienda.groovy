package CENTRALSQ

class SqtSupervisorTienda {
    SqtSupervisor supervisor
    SqtTienda tienda
    Date fechaInicio
    Date fechaFin

    static constraints = {
        fechaFin nullable:true
    }
}
