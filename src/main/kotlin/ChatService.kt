object ChatService {

    val chats = mutableListOf<Chat>()
    var uniqId = 0

    fun sendMessage (chatId: Int, message: Message): Boolean {
        message.messageId = uniqId++
        val flag = chats.find { it.chatId == chatId }?.messages?.add(message)
        if (flag == true) {
            return true
        }
        return false
    }

    fun addChat (chat: Chat): Boolean {
        chats.add(chat)
        if (chats.contains(chat)) {
            return true
        }
        return false
    }

    fun deleteChat (chat: Chat): Boolean {
        if (chats.contains(chat)) {
            chats.remove(chat)
            return true
        }
        return false
    }

    fun getAllUnreadedChats(): List<Chat> {
        val chatFounded = chats.filter { it.messages.find { !it.readable } != null }
        return chatFounded
    }
}