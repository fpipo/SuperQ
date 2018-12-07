package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTraspasoTT)
interface SqtTraspasoTTService {

    SqtTraspasoTT get(Serializable id)

    List<SqtTraspasoTT> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTraspasoTT save(SqtTraspasoTT sqtTraspasoTT)

}