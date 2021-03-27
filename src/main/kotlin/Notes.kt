data class Notes(
    val id: Int,
    val ownerId: Int,
    val title:String,
    val text:String,
    var comments: ArrayList<Comments> = ArrayList(),
    var isDeleted: Boolean = false
) {
}