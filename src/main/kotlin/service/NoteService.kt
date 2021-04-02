package service

import exception.NoteNotFoundException
import model.Comment
import model.Note

class NoteService : CrudService<Note> {
    private val notes = mutableMapOf<Int, MutableList<Note>>()

    override fun add(id: Int, entity: Note) {
        notes[id]?.let {
            it.add(entity)
        } ?: kotlin.run {
            val newNotesList = mutableListOf<Note>()
            newNotesList.add(entity)
            notes[id] = newNotesList
        }
    }

    override fun delete(id: Int, entityId: Int) {
        if (notes.get(id)?.get(entityId)?.isDeleted == true) return
        notes.get(id)?.get(entityId)?.isDeleted = true
    }

    override fun edit(id: Int, title: String, text: String, entityId: Int) {
        if (notes.get(id)?.get(entityId)?.isDeleted == true) {
            return
        }
        val note = notes.get(id)?.get(entityId)
        note?.copy(title = title, text = text)?.let { notes.get(id)?.set(entityId, it) }
    }

    override fun get(id: Int): MutableList<Note> {
        val sortedList = ArrayList<Note>()
        for (note in notes.get(id)!!) {
            if (note.isDeleted) {
                continue
            }
            sortedList.add(note)
        }

        return sortedList
    }

    override fun getById(id: Int, entityId: Int): Note? {
        if (notes.get(id)?.get(entityId)?.isDeleted == true) {
            throw NoteNotFoundException()
        }
        return notes.get(id)?.get(entityId)
    }

}