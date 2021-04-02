import exception.CommentNotFoundException
import exception.NoteNotFoundException
import org.junit.Test

import org.junit.Assert.*

class NotesAndCommentsManagerTest {

    @Test
    fun addNote() {
        //arrange
        val user = 1
        //act
        val noteId = NotesAndCommentsManager.addNote(user, "title 1", "text 1")
        //assert
        assertEquals(noteId, 0)
    }

    @Test
    fun addComment() {
        //arrange
        val user = 1
        val noteId = 1
        //act
        NotesAndCommentsManager.addComment(user, noteId, "comment 1", "message 1")
    }

    @Test
    fun deleteNote() {
        //arrange
        val user = 1
        val noteId = NotesAndCommentsManager.addNote(user, "title 1", "text 1")
        //act
        NotesAndCommentsManager.deleteNote(user, noteId)
    }

    @Test
    fun deleteComment() {
        //arrange
        val user = 0
        val noteId = 0
        NotesAndCommentsManager.addComment(user, noteId, "comment 1", "message 1")
        //act
        NotesAndCommentsManager.deleteComment(user, noteId)
    }

    @Test
    fun editNote() {
        //arrange
        val user = 1
        val noteId = NotesAndCommentsManager.addNote(user, "title 1", "text 1")
        //act
        NotesAndCommentsManager.editNote(user, "new title", "new text", noteId)


    }

    @Test
    fun editComment() {
        //arrange
        val noteId = 0
        val commentId = 0
        NotesAndCommentsManager.addComment(noteId, commentId, "title 1", "text 1")
        //act
        NotesAndCommentsManager.editComment(noteId, "new title", "new text1", commentId)
    }

    @Test
    fun getNotes() {
        //arrange
        val user = 1
        val note1 = NotesAndCommentsManager.addNote(user, "title 1", "text 1")
        val note2 = NotesAndCommentsManager.addNote(user, "title 2", "text 2")
        val notesList = NotesAndCommentsManager.getNotes(user)
        //act
        val result = NotesAndCommentsManager.getNotes(user)
        //assert
        assertEquals(result, notesList)

    }

    @Test
    fun getComments() {
        //arrange
        val noteId = 1
        val comment1 = 1
        val comment2 = 2
        val comment3 = 3
        NotesAndCommentsManager.addComment(noteId, comment1, "comment 1", "message 1")
        NotesAndCommentsManager.addComment(noteId, comment2, "comment 2", "message 2")
        NotesAndCommentsManager.addComment(noteId, comment3, "comment 3", "message 3")
        val commentsList = NotesAndCommentsManager.getComments(noteId)
        //act
        val result = NotesAndCommentsManager.getComments(noteId)
        //assert
        assertEquals(result, commentsList)

    }

    @Test
    fun getNoteById() {
        //arrange
        val user = 1
        val noteId = NotesAndCommentsManager.addNote(user, "title 1", "text 1")
        val note = NotesAndCommentsManager.getNoteById(user, noteId)
        //act
        val result = NotesAndCommentsManager.getNoteById(user, noteId)
        //assert
        assertEquals(result, note)

    }

    @Test(expected = NoteNotFoundException::class)
    fun getNoteById_shouldThrowException() {
        //arrange
        val user = 1
        val noteId = NotesAndCommentsManager.addNote(user, "title 1", "text 1")
        NotesAndCommentsManager.deleteNote(user, noteId)
        //act
        val result = NotesAndCommentsManager.getNoteById(user, noteId)
    }

    @Test
    fun getCommentById() {
        //arrange
        val noteId = 1
        val commentId1 = 1
        NotesAndCommentsManager.addComment(noteId, commentId1, "comment 1", "message 1")
        val comment = NotesAndCommentsManager.getCommentById(noteId, commentId1)
        //act
        val result = NotesAndCommentsManager.getCommentById(noteId, commentId1)
        //assert
        assertEquals(result, comment)
    }

    @Test(expected = CommentNotFoundException::class)
    fun getCommentById_shouldThrowException() {
        //arrange
        val noteId = 0
        val commentId1 = 0
        NotesAndCommentsManager.addComment(noteId, commentId1, "comment 1", "message 1")
        NotesAndCommentsManager.deleteComment(noteId, commentId1)
        //act
        val result = NotesAndCommentsManager.getCommentById(noteId, commentId1)
    }

    @Test
    fun restoreComment() {
        //arrange
        val noteId = 0
        val commentId1 = 0
        NotesAndCommentsManager.addComment(noteId, commentId1, "comment 1", "message 1")
        NotesAndCommentsManager.deleteComment(noteId, commentId1)
        //act
        NotesAndCommentsManager.restoreComment(noteId, commentId1)
    }
}