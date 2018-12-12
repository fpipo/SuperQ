package CENTRALSQ

class SqtProveedor {
    String nombre
    String razonSocial
    int base
    String rfc
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
    Date fechamod
    String usuariomod
    int enviado
    int criterioAgrupacion

    SqtEstado estado
    SqtPais pais
    SqtTelefono telefono
    SqtCondicionPago condicionPago
    SqtEstatus estatus


    static constraints = {
        nombre maxSize: 70
        razonSocial maxSize: 70
        rfc maxSize: 16
        calle maxSize: 50
        colonia maxSize: 50
        municipio maxSize: 50
        cp maxSize: 5
        cuidad maxSize: 50
        paginaweb maxSize: 50
        email maxSize: 50
        resposable maxSize: 15
        responsableTel maxSize: 30
        responsableEmail email:true
        enviado nullable:true





    }
}
