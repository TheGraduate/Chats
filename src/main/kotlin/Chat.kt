data class Chat(val chatId: Int) {
    val users = mutableListOf<Int>()
    val messages = mutableListOf<Message>()
}


