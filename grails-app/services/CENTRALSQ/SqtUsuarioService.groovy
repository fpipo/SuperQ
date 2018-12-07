package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtUsuario)
interface SqtUsuarioService {

    SqtUsuario get(Serializable id)

    List<SqtUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtUsuario save(SqtUsuario sqtUsuario)

}