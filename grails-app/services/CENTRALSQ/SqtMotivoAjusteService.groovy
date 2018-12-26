package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtMotivoAjuste)
interface SqtMotivoAjusteService {

    SqtMotivoAjuste get(Serializable id)

    List<SqtMotivoAjuste> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtMotivoAjuste save(SqtMotivoAjuste sqtMotivoAjuste)

}