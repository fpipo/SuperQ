package CENTRALSQ

class SqtConciliacion {
        String indicadorFila
        String contador
        Date fecha
        String numAutorizacion
        String telefono
        String carrier
        Double monto
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
        numAutorizacion maxSize: 6, nullable: true
        telefono maxSize: 10, nullable: true
        carrier maxSize: 4, nullable: true
        canal maxSize: 2, nullable: true
        terminaliId maxSize: 50, nullable: true
        anio maxSize: 4, nullable: true
        mes maxSize: 2, nullable: true
        dia maxSize: 2, nullable: true
        nombreArchivo maxSize: 17, nullable: true
        fecha nullable: true
        montoTotal nullable: true ,maxSize: 12
    }
}
