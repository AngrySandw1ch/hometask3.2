package service

interface CrudService<E> {
    fun add(id: Int, entity: E)
    fun delete(id: Int, entityId: Int)
    fun edit(id: Int, title: String, text: String, entityId: Int)
    fun get(id: Int): MutableList<E>
    fun getById(id: Int, entityId: Int) : E?

}