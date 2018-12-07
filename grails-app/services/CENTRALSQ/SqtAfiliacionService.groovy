package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAfiliacion)
interface SqtAfiliacionService {

    SqtAfiliacion get(Serializable id)

    List<SqtAfiliacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAfiliacion save(SqtAfiliacion sqtAfiliacion)

}