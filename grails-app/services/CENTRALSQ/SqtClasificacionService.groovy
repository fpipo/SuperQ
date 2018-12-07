package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtClasificacion)
interface SqtClasificacionService {

    SqtClasificacion get(Serializable id)

    List<SqtClasificacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtClasificacion save(SqtClasificacion sqtClasificacion)

}