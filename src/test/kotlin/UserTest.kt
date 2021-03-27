import org.junit.Test

import org.junit.Assert.*

class UserTest {

    @Test
    fun add() {
        //arrange
        val user = User(1, "john")
        //act
        user.add("note 1", "text 1")
    }

    @Test
    fun createComment() {
        //arrange
        val user = User(1, "Adam")
        user.add("note 1", "text 1")
        //act
        user.createComment(1, "comment 1")
    }

    @Test
    fun delete() {
        //arrange
        val user = User(1, "Joshua")
        user.add("note 1", "text 1")
        //act
        user.delete(1)
    }

    @Test
    fun deleteComment() {
        //arrange
        val user = User(1, "Andrew")
        user.add("note 1", "text 1")
        user.createComment(1, "comment 1")
        //act
        user.deleteComment(1,1)
    }

    @Test
    fun edit() {
        //arrange
        val user = User(1, "Ben")
        user.add("note 1", "text 1")
        user.createComment(1, "comment 1")
        //act
        user.edit(1, "note 1.1", "text 1.1")
    }

    @Test
    fun editComment() {
        //arrange
        val user = User(1, "Ben")
        user.add("note 1", "text 1")
        user.createComment(1, "comment 1")
        //act
        user.editComment(1, 1, "new text")
        //assert
    }

    @Test
    fun get() {
        //arrange
        val user = User(1, "Ben")
        user.add("note 1", "text 1")
        val notes = arrayListOf<Notes>(Notes(1, 1, "note 1", "text 1"))
        //act
        val result = user.get()
        //assert
        assertEquals(result, notes)
    }

    @Test
    fun getById() {
        //arrange
        val user = User(1, "Sasha")
        user.add("note 1", "text 1")
        val note: Notes = Notes(1, 1, "note 1", "text 1")
        //act
        val result = user.getById(1)
        //assert
        assertEquals(result, note)
    }
    @Test(expected = NoteNotFoundException::class)
    fun getById_shouldThrowException() {
        //arrange
        val user = User(1, "Pavel")
        user.add("note 1", "text 1")
        //act
        val note = user.getById(2)
    }

    @Test
    fun getComments() {
        //arrange
        val user = User(1, "Kirill")
        user.add("note 1", "text 1")
        user.createComment(1, "comment 1")
        val comments = arrayListOf<Comments>(Comments(1, 1, "comment 1"))
        //act
        val result = user.getComments(1)
        //assert
        assertEquals(result, comments)
    }

    @Test
    fun restoreComment() {
        //arrange
        val user = User(1, "Alex")
        user.add("note 1", "text 1")
        user.createComment(1, "comment 1")
        user.deleteComment(1, 1)
        val isRestored = true
        //act
        val result = user.restoreComment(1, 1)
        //assert
        assertEquals(result, isRestored)
    }
}