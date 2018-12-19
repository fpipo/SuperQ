package CENTRALSQ

class SqtArchivo implements Serializable {
    static final int DESCRIPCION_MIN = 3
    static final int DESCRIPCION_MAX = 100

    String descripcion
    String nombreOriginal
    String extension
    Long tamanio
    String contentType
    SqtUsuario creadoPor

    static constraints = {
        descripcion(size:DESCRIPCION_MIN..DESCRIPCION_MAX)
        nombreOriginal()
        extension()
        tamanio(min:0L)
        contentType()
        creadoPor(nullable: true)
    }
    def getNombreArchivo() {
        extension ? "${id}.${extension}" : id
    }

    def getTipoArchivo() {
        def result

        switch(extension) {
            case ['jpg', 'jpeg', 'png', 'gif', 'bmp']:
                result = 'Imagen'
                break
            case ['mp4', 'webm', 'ogv', 'mpg', 'mpeg', 'avi', '3gp', 'flv']:
                result = 'Video'
                break
            case ['mp3', 'ogg', 'wav']:
                result = 'Audio'
                break
            case ['doc', 'docx']:
                result = 'Word'
                break
            case ['xls', 'xlsx']:
                result = 'Excel'
                break
            case ['ppt', 'pptx']:
                result = 'PowerPoint'
                break
            case ['pdf']:
                result = 'PDF'
                break
            default:
                result = 'Otro'
        }
        result
    }
    def esImagen() {
        tipoArchivo == "Imagen"
    }

    def esVideo() {
        tipoArchivo == "Video"
    }

    def esAudio() {
        tipoArchivo == "Audio"
    }

    def esVideoHTML5() {
        ['mp4', 'webm', 'ogv', '3gp'].contains(extension)
    }

    def esAudioHTML5() {
        ['mp3', 'ogg', 'wav'].contains(extension)
    }
}


