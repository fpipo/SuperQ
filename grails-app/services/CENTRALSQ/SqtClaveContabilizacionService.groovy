package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtClaveContabilizacion)
interface SqtClaveContabilizacionService {

    SqtClaveContabilizacion get(Serializable id)

    List<SqtClaveContabilizacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtClaveContabilizacion save(SqtClaveContabilizacion sqtClaveContabilizacion)

}