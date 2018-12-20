package CENTRALSQ

class SqtCuotaServicio {
    int enviado

    SqtProducto productoRef
    SqtEstatus estatus
    SqtServicio servicio
    
    static constraints = {
        enviado nulleable: true
        servicio nullable: true
        productoRef nullable:true
        estatus nullable: true
    }
}
