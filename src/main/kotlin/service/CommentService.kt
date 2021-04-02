package service

import exception.CommentNotFoundException
import model.Comment
import model.Note

class CommentService : CrudService<Comment> {
    private val comments = mutableMapOf<Int, MutableList<Comment>>()

    override fun add(id: Int, entity: Comment) {
        comments[id]?.let {
            it.add(entity)
        } ?: kotlin.run {
            val newCommentsList = mutableListOf<Comment>()
            newCommentsList.add(entity)
            comments[id] = newCommentsList
        }
    }

    override fun delete(id: Int, entityId: Int) {
        if (comments.get(id)?.get(entityId)?.isDeleted == true) {
            return
        }
        comments.get(id)?.get(entityId)?.isDeleted = true
    }

    override fun edit(id: Int, title: String, text: String, entityId: Int) {
        val comment = comments.get(id)?.get(entityId)
        comment?.copy(commentTitle = title, message = text)?.let { comments.get(id)?.set(entityId, it) }
    }

    override fun get(id: Int): MutableList<Comment> {
        val sortedComments = ArrayList<Comment>()
        for (comment in comments.get(id)!!) {
            if (comment.isDeleted) {
                continue
            }
            sortedComments.add(comment)
        }
        return sortedComments
    }

    override fun getById(id: Int, entityId: Int): Comment? {
        if (comments.get(id)?.get(entityId)?.isDeleted == true) {
            throw CommentNotFoundException()
        }
        return comments.get(id)?.get(entityId)
    }

    fun restoreComment(noteId: Int, commentId: Int) {
        if (comments.get(noteId)?.get(commentId)?.isDeleted == false) {
            return
        }
        val commentToEdit = comments.get(noteId)?.get(commentId)
        commentToEdit?.copy(isDeleted = false)?.let { comments.get(noteId)?.set(commentId, it) }
    }
}