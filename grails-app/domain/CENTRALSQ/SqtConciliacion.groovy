package CENTRALSQ

class SqtConciliacion {
        String indicadorFila
        String contador
        String fecha
        String hora
        String numAutorizacion
        String telefono
        String carrier
        String monto
        String canal
        String terminaliId
        String anio
        String mes
        String dia
        String nombreArchivo
        String montoTotal
    static constraints = {
        indicadorFila maxSize: 3, nullable: true
        contador maxSize: 6, nullable: true
        fecha maxSize: 8, nullable: true
        hora maxSize: 6, nullable: 6
        numAutorizacion maxSize: 6, nullable: true
        telefono maxSize: 10, nullable: true
        carrier maxSize: 4, nullable: true
        monto maxSize: 6, nullable: true
        canal maxSize: 2, nullable: true
        terminaliId maxSize: 50, nullable: true
        anio maxSize: 4, nullable: true
        mes maxSize: 2, nullable: true
        dia maxSize: 2, nullable: true
        nombreArchivo maxSize: 17, nullable: true
        montoTotal maxSize: 12, nullable: true
    }
}
