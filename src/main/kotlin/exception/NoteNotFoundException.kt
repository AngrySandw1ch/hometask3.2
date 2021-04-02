package exception

class NoteNotFoundException(message: String = "Заметки по указанному id не существует") : Exception(message) {
}