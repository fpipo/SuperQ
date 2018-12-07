package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtResposableTienda)
interface SqtResposableTiendaService {

    SqtResposableTienda get(Serializable id)

    List<SqtResposableTienda> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtResposableTienda save(SqtResposableTienda sqtResposableTienda)

}