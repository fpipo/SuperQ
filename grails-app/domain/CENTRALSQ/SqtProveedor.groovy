package CENTRALSQ

class SqtProveedor {
    String nombre
    String razonSocial
    int base
    String rfc
    String idTipoProveedor
    String calle
    String colonia
    String municipio
    String cp
    String ciudad
    String paginaweb
    String email
    String tipo
    String responsable
    String responsableTel
    String responsableEmail
    Date fechaMod
    String usuarioMod
    int enviado
    int criterioAgrupacion

    SqtEstado estado
    SqtPais pais
    SqtTelefono telefono
    SqtCondicionPago condicionPago
    SqtEstatus estatus

    String idCondicionPago
    String idCondicionDefault

    static constraints = {
        nombre maxSize: 70
        razonSocial maxSize: 70
        base nullable: true
        idTipoProveedor nullable: true
        rfc maxSize: 13
        calle maxSize: 50 , nullable: true
        colonia maxSize: 50, nullable: true
        municipio maxSize: 50, nullable: true
        cp maxSize: 5, nullable: true
        ciudad maxSize: 50, nullable: true
        estado nullable: true
        pais nullable: true
        telefono nullable: true
        paginaweb maxSize: 50, nullable: true
        email email: true, maxSize: 50, nullable: true
        estatus nullable: true
        tipo nullable: true
        responsable maxSize: 15, nullable: true
        responsableTel maxSize: 30, nullable: true
        responsableEmail email:true,nullable: true
        enviado nullable:true
        idCondicionDefault nullable: true
        idCondicionPago nullable: true
        criterioAgrupacion nullable: true
        condicionPago nullable: true
    }
}
