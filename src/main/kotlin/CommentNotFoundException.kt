class CommentNotFoundException(message: String = "Комментария по указанному id не существует"): Exception(message) {
}