package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPosionCodigo)
interface SqtPosionCodigoService {

    SqtPosionCodigo get(Serializable id)

    List<SqtPosionCodigo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPosionCodigo save(SqtPosionCodigo sqtPosionCodigo)

}