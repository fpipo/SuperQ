package CENTRALSQ

class SqtRetiroCaja {

    String	caja
    Date	diaOperacion
    Double	cantidad
    String	comentarios
    Date	cierrecajero
    Date	cierrecaja
    Date	cierredia
    int	aplica
    int	retiroAlCierre
    Date	fechamod
    SqtUsuario	usuarioMod
    String idTipoRetiro
    int	enviado

    SqtTienda tienda
    SqtFormaPago formaPago
    SqtAsignacion asignacion
    SqtTipoRetiro tipoRetiro
    SqtVenta venta

    static constraints = {

        caja maxSize: 2
        comentarios maxSize: 500, nullable: true
        cierrecajero nullable: true
        cierrecaja nullable: true
        cierredia nullable: true
        aplica nullable: true
        retiroAlCierre nullable: true
        enviado nullable:true
        idTipoRetiro nullable: true
        venta nullable: true

    }
}
