package CENTRALSQ

class SqtFuncion {
    String descripcionCorta
    String descripcionLarga
    int bitacora
    String forma
    String tipo
    String imagen
    String tipomenu
    int orden
    int submenu
    int nivel
    int ti
    int bg
    int ce
    int enviado

    /*

    *
    * Sqt_______ funcionpadre
    *
    *
    *   Buscar de donde viene id_funcionpadre
    * */



    static constraints = {
        descripcionCorta maxSize: 50, nullable: false
        descripcionLarga maxSize: 250
        forma maxSize: 50
        tipo maxSize: 2
        enviado nullable:true
    }
}
