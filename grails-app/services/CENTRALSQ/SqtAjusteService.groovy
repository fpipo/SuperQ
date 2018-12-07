package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtAjuste)
interface SqtAjusteService {

    SqtAjuste get(Serializable id)

    List<SqtAjuste> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtAjuste save(SqtAjuste sqtAjuste)

}