package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioCartegoria)
interface SqtInventarioCartegoriaService {

    SqtInventarioCartegoria get(Serializable id)

    List<SqtInventarioCartegoria> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioCartegoria save(SqtInventarioCartegoria sqtInventarioCartegoria)

}