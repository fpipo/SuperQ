package CENTRALSQ

class SqtCatalogoBritish {
    String descripcion
    String codigoActivo
    String statusCambioCodigo
    int codigoAds

    SqtProducto producto
    SqtEstatus estatus

    static constraints = {
        descripcion maxSize: 200, nullable: true
        codigoActivo maxSize: 30 , nullable: true
        statusCambioCodigo maxSize: 100, nullable: true
        codigoAds nullable:true


    }
}
