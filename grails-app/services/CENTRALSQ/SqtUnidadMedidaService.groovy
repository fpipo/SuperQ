package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtUnidadMedida)
interface SqtUnidadMedidaService {

    SqtUnidadMedida get(Serializable id)

    List<SqtUnidadMedida> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtUnidadMedida save(SqtUnidadMedida sqtUnidadMedida)

}