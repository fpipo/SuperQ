package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtImpuesto)
interface SqtImpuestoService {

    SqtImpuesto get(Serializable id)

    List<SqtImpuesto> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtImpuesto save(SqtImpuesto sqtImpuesto)

}