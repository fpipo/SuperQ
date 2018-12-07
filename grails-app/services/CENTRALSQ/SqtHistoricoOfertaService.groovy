package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtHistoricoOferta)
interface SqtHistoricoOfertaService {

    SqtHistoricoOferta get(Serializable id)

    List<SqtHistoricoOferta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtHistoricoOferta save(SqtHistoricoOferta sqtHistoricoOferta)

}