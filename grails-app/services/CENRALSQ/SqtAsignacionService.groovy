package CENRALSQ

import grails.gorm.services.Service

@Service(SqtAsignacion)
interface SqtAsignacionService {

    SqtAsignacion get(Serializable id)

    List<SqtAsignacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAsignacion save(SqtAsignacion sqtAsignacion)

}