package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtEmisoresRemesa)
interface SqtEmisoresRemesaService {

    SqtEmisoresRemesa get(Serializable id)

    List<SqtEmisoresRemesa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtEmisoresRemesa save(SqtEmisoresRemesa sqtEmisoresRemesa)

}