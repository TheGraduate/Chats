
data class Message (
    var messageId: Int,
    val senderId: Int,
    val messageText: String,
    var readable: Boolean = false
)