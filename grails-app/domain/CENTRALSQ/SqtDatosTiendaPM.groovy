package CENTRALSQ

class SqtDatosTiendaPM {
    String territorio
    String gerencia
    String noTienda
    String colocacion
    String pop
    String operacion
    String an

    SqtTienda tienda

    static constraints = {
        territorio maxSize: 30, nullable: true
        gerencia maxSize: 30, nullable: true
        noTienda maxSize: 30 , nullable: true
        colocacion maxSize: 30, nullable: true
        pop maxSize: 100, nullable: true
        operacion maxSize: 100, nullable: true
        an maxSize: 100, nullable: true
    }
}

/* Solo para CENTRALSQ*/