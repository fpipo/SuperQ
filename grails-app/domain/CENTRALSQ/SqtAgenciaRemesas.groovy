package CENTRALSQ

class SqtAgenciaRemesas {
    String nombre
    int comercio
    int agencia

    SqtTienda tienda

    static constraints = {
        nombre maxSize: 100
    }
}
