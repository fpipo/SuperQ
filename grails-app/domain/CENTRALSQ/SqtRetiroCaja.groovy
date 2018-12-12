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
    int	enviado

    SqtTienda tienda
    SqtFormaPago formaPago
    SqtAsignacion asignacion
    SqtTipoRetiro tipoRetiro
    SqtVenta venta

    static constraints = {

        caja maxSize: 2
        comentarios maxSize: 500
        enviado nullable:true

    }
}
