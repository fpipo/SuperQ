package CENRALSQ

import grails.gorm.services.Service

@Service(SqtConfiguracion)
interface SqtConfiguracionService {

    SqtConfiguracion get(Serializable id)

    List<SqtConfiguracion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtConfiguracion save(SqtConfiguracion sqtConfiguracion)

}