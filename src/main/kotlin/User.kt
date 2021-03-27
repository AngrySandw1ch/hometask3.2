class User(val id: Int, val name: String) {
    var notes: ArrayList<Notes> = ArrayList()

    fun add(title: String, text: String) {
        val noteId = if (notes.isEmpty()) 1 else notes.last().id + 1
        val note = Notes(noteId, this.id, title, text)
        notes.add(note)
    }

    fun createComment(noteId: Int, message: String) {
        val commentId = if (notes.get(noteId - 1).comments.isEmpty()) 1 else notes.get(noteId - 1).comments.last().id + 1
        val msg = Comments(commentId, this.id, message)
        for (note: Notes in notes) {
            if (note.id == noteId) {
                note.comments.add(msg)
            }
        }
    }

    fun delete(noteId: Int) {
        for (note: Notes in notes) {
            if (note.id == noteId) {
                if (!note.isDeleted) {
                    note.isDeleted = true
                } else return
            }
        }
    }

    fun deleteComment(noteId: Int, commentId: Int) {
        for (note: Notes in notes) {
            if (note.id == noteId) {
                if (!note.comments.get(commentId - 1).isDeleted) {
                    note.comments.get(commentId - 1).isDeleted = true
                } else return
            }
        }
    }

    fun edit(noteId: Int, newTitle: String, newText: String) {
        for ((index, note) in notes.withIndex()) {
            if (note.id == noteId) {
                if (note.isDeleted) {
                    return
                }
                val editedNote = note.copy(title = newTitle, text = newText)
                notes[index] = editedNote
            }
        }
    }

    fun editComment(noteId: Int, commentId: Int, newMessage: String) {
        for (note: Notes in notes) {
            if (note.id == noteId) {
                if (note.isDeleted) {
                    return
                }
                for ((index, comment) in note.comments.withIndex()) {
                    if (comment.id == commentId) {
                        if (comment.isDeleted) {
                            return
                        }
                        val editedComment = comment.copy(message = newMessage)
                        note.comments[index] = editedComment
                    }
                }
            }
        }
    }

    fun get(): ArrayList<Notes> {
        val notesList = ArrayList<Notes>()
        for (note: Notes in notes) {
            if (note.isDeleted){
                continue
            }
            notesList.add(note)
        }
        return notesList
    }

    fun getById(noteId: Int): Notes {
        for (note: Notes in notes) {
            if (note.id == noteId) {
                if (note.isDeleted){
                    return throw NoteNotFoundException()
                }
                return note
            }
        }
        return throw NoteNotFoundException()
    }

    fun getComments(noteId: Int): ArrayList<Comments> {
        val commentsList = ArrayList<Comments>()
        for (note: Notes in notes){
            for (comment: Comments in note.comments) {
                if (comment.isDeleted) {
                    continue
                }
                commentsList.add(comment)
            }
        }
        return commentsList
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        var result: Boolean = false
        for (note: Notes in notes) {
            if (note.id == noteId) {
                if (!note.comments.get(commentId - 1).isDeleted) {
                    break
                }
                note.comments.get(commentId - 1).isDeleted = false
                result = true
            }
        }
        return result
    }

}