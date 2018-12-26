package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtEtiquetaIdioma)
interface SqtEtiquetaIdiomaService {

    SqtEtiquetaIdioma get(Serializable id)

    List<SqtEtiquetaIdioma> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtEtiquetaIdioma save(SqtEtiquetaIdioma sqtEtiquetaIdioma)

}