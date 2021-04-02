fun main() {
    val user1 = 1
    val user2 = 2

    val note1 = NotesAndCommentsManager.addNote(user1, "Note 1", "text 1")
    val note2 = NotesAndCommentsManager.addNote(user1, "Note 2", "text 2")

    val note3 = NotesAndCommentsManager.addNote(user2, "Note 3", "text 3")
    val note4 = NotesAndCommentsManager.addNote(user2, "Note 4", "text 4")

    NotesAndCommentsManager.addComment(user1, note1, "comment 1", "text 1")
    NotesAndCommentsManager.addComment(user1, note2, "comment 2", "text 2")

    //println(NotesAndCommentsManager.getNotes(user1))

    NotesAndCommentsManager.deleteNote(user1, note2)
    //println(NotesAndCommentsManager.getNotes(user1))

    //println(NotesAndCommentsManager.getComments(user1))
    //NotesAndCommentsManager.deleteComment(user1, note1)

    //println(NotesAndCommentsManager.getComments(user1))

    NotesAndCommentsManager.editNote(user1, "new title", "new text", note1)
    //println(NotesAndCommentsManager.getNotes(user1))

    //println(NotesAndCommentsManager.getComments(user1))
    NotesAndCommentsManager.editComment(user1, "new comment title", "new comment text", note1)
    //println(NotesAndCommentsManager.getComments(user1))

    val note = NotesAndCommentsManager.getNoteById(user1, note1)
    //println(note)

    val comment = NotesAndCommentsManager.getCommentById(user1, note1)
    //println(comment)

    NotesAndCommentsManager.deleteComment(user1, note2)
    println(NotesAndCommentsManager.getComments(user1))
    NotesAndCommentsManager.restoreComment(user1, note2)
    println(NotesAndCommentsManager.getComments(user1))


}