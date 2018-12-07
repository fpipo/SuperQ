package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtComisionUsuario)
interface SqtComisionUsuarioService {

    SqtComisionUsuario get(Serializable id)

    List<SqtComisionUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtComisionUsuario save(SqtComisionUsuario sqtComisionUsuario)

}