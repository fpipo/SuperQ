package CENTRALSQ

class SqtRetiroCaja {
    String	caja
    Date	diaOperacion
    Double	cantidad
    String	comentarios
    Date	cierreCajero
    Date	cierreCaja
    Date	cierreDia
    int	aplica
    int	retiroAlCierre
    Date	fechaMod
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
        cierreCajero nullable: true
        cierreCaja nullable: true
        cierreDia nullable: true
        aplica nullable: true
        retiroAlCierre nullable: true
        enviado nullable:true
        tipoRetiro nullable: true
        venta nullable: true
    }
}
