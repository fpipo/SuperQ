package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtTipoRetiro)
interface SqtTipoRetiroService {

    SqtTipoRetiro get(Serializable id)

    List<SqtTipoRetiro> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtTipoRetiro save(SqtTipoRetiro sqtTipoRetiro)

}