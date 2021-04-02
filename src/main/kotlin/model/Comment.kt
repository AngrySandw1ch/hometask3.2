package model

data class Comment(
    val id: Int,
    val commentTitle: String,
    val message: String,
    var isDeleted: Boolean = false
) {
}