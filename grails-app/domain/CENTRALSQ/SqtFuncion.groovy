package CENTRALSQ

class SqtFuncion {
    String descripcioncorta
    String descripcionlarga
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
        descripcioncorta maxSize: 50, nullable: false
        descripcionlarga maxSize: 250
        forma maxSize: 50
        tipo maxSize: 2
        enviado nullable:true

    }
}
