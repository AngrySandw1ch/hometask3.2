data class Comments(
    val id: Int,
    val ownerId: Int,
    val message: String,
    var isDeleted: Boolean = false
) {
}