package CENTRALSQ

class SqtClasificacionTiendas {

    SqtTienda tienda
    String clasificacion


    static constraints = {

        clasificacion maxSize: 10
    }
}
