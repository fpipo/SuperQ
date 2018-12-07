package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAplicativos)
interface SqtAplicativosService {

    SqtAplicativos get(Serializable id)

    List<SqtAplicativos> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAplicativos save(SqtAplicativos sqtAplicativos)

}