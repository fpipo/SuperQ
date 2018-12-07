package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtReporte)
interface SqtReporteService {

    SqtReporte get(Serializable id)

    List<SqtReporte> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtReporte save(SqtReporte sqtReporte)

}