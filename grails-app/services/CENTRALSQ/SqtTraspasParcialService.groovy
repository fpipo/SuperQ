package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTraspasParcial)
interface SqtTraspasParcialService {

    SqtTraspasParcial get(Serializable id)

    List<SqtTraspasParcial> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTraspasParcial save(SqtTraspasParcial sqtTraspasParcial)

}