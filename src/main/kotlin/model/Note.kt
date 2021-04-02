package model

data class Note(
    val id: Int,
    val title: String,
    val text: String,
    var isDeleted: Boolean = false
) {
}