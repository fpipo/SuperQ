package CENTRALSQ

class SqtCatalagoCigarros {
    int	enviado
    Double	pzasPaq
    String 	descripcionProv
    String	fa
    Double	minimoVisual
    String	codigoActivo
    String	statusCambioCodigo
    int	codigoADS
    SqtEstatus Estatus
    SqtProducto codigo

    static constraints = {
        descripcionProv maxSize: 50, nullable: false
        fa maxSize: 50, nullable: true
        codigoActivo maxSize: 100, nullable: true
        statusCambioCodigo maxSize: 100, nullable: true
    }
}
