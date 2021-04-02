import model.Comment
import model.Note
import service.CommentService
import service.NoteService

object NotesAndCommentsManager {
    private val noteService = NoteService()
    private val commentService = CommentService()

    fun addNote(userId: Int, title: String, text: String): Int {
        val uniqueId = uniqueId()
        val someNote = Note(uniqueId, title, text)
        noteService.add(userId, someNote)
        return uniqueId
    }

    fun addComment(userId: Int, noteId: Int, title: String, text: String) {
        val comment = Comment(noteId, title, text)
        commentService.add(userId, comment)
    }

    fun deleteNote(userId: Int, noteId: Int) {
        noteService.delete(userId, noteId)
    }

    fun deleteComment(userId: Int, noteId: Int) {
        commentService.delete(userId, noteId)
    }

    fun editNote(userId: Int, title: String, text: String, noteId: Int) {
        noteService.edit(userId,title,text,noteId)
    }

    fun editComment(userId: Int, title: String, text: String, noteId: Int) {
        commentService.edit(userId, title, text, noteId)
    }

    fun getNotes(userId: Int): MutableList<Note> {
        return noteService.get(userId)
    }

    fun getComments(noteId: Int): MutableList<Comment> {
        return commentService.get(noteId)
    }

    fun getNoteById(userId: Int, noteId: Int): Note? {
        return noteService.getById(userId, noteId)
    }

    fun getCommentById(userId: Int, noteId: Int): Comment? {
        return commentService.getById(userId, noteId)
    }

    fun restoreComment(userId: Int, noteId: Int) {
        commentService.restoreComment(userId, noteId)
    }
}