package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtNuevaCategorizacion)
interface SqtNuevaCategorizacionService {

    SqtNuevaCategorizacion get(Serializable id)

    List<SqtNuevaCategorizacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtNuevaCategorizacion save(SqtNuevaCategorizacion sqtNuevaCategorizacion)

}