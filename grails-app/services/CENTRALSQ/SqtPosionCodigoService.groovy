package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPosicionCodigo)
interface SqtPosionCodigoService {

    SqtPosicionCodigo get(Serializable id)

    List<SqtPosicionCodigo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPosicionCodigo save(SqtPosicionCodigo sqtPosionCodigo)

}