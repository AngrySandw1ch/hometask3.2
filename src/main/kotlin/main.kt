fun main() {
    val user1 = User(1, "John")
    user1.add("note 1", "text 1")
    user1.add("note 2", "text 2")

    user1.createComment(1, "comment 1")
    user1.createComment(1, "comment 2")
    user1.createComment(1, "comment 3")

    user1.delete(2)
    //println(user1.notes.get(0).isDeleted)

    user1.deleteComment(1, 3)
    //println(user1.notes.get(0).comments.get(2).isDeleted)

    user1.edit(1, "note 1.1", "text 1.1")
    //println(user1.notes.get(0))

    user1.editComment(1,1,"comment 1.1")
    //println(user1.notes.get(0))

    val notes = user1.get()
    //println(notes)

    val note = user1.getById(1)
    //println(note)

    val comments = user1.getComments(1)
    //println(comments)

    val isRestored = user1.restoreComment(1, 3)
    //println(isRestored)



}