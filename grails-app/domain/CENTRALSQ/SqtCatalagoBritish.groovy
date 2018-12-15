package CENTRALSQ

class SqtCatalagoBritish {
    String descripcion
    String codigoActivo
    String statusCambioCodigo
    int cosigoAds

    SqtProducto producto
    SqtEstatus estatus

    static constraints = {
        descripcion maxSize: 200
        codigoActivo maxSize: 30
        statusCambioCodigo maxSize: 100


    }
}
