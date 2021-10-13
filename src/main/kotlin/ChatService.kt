object ChatService {

    val chats = mutableListOf<Chat>()

    fun sendMessage(chatId: Int, message: Message): Boolean {
        if (chats.find { it.chatId == chatId }?.messages?.add(message) == true) {
            return true
        }
        return false
    }

    fun addChat(chat: Chat): Boolean {
        if (chats.add(chat)) {
            return true
        }
        return false
    }

    fun addUser(chatId: Int, userId: Int): Boolean {
        if (chats.find { it.chatId == chatId }?.users?.add(userId) == true) {
            return true
        }
        return false
    }

    fun deleteChat(chat: Chat): Boolean {
        if (chats.remove(chat)) {
            return true
        }
        return false
    }

    fun deleteMessage(chatId: Int, message: Message, userId: Int): Boolean {
        if (chats.find { it.chatId == chatId }?.messages?.remove(message) == true && userId == message.senderId) {
            val emptyChat = chats.find { it.messages.isEmpty() }
            chats.remove(emptyChat)
            return true
        }
        return false
    }

    /*fun getMessagesForBeginningWith(chatId: Int, messageId: Int): List<Message>? {
        val listMessages = chats.find { it.chatId == chatId }?.messages?.filter { it.messageId >= messageId }
        listMessages?.forEach { it.readable = true }
        return listMessages
    }*/

    fun getMessagesForBeginningWith(chatId: Int, offset: Int , startFrom: Int): List<Message> =
        chats.singleOrNull { it.chatId == chatId }
            .let { it?.messages?: throw ChatNotFoundError("ChatNotFound") }
            .drop(startFrom)
            .take(offset)
            .ifEmpty { throw MessagesNotFoundError("MessagesNotFound") }

    fun getAllMessages(chatId: Int): MutableList<Message>? {
        val listMessages = chats.find { it.chatId == chatId }?.messages
        listMessages?.forEach { it.readable = true }
        return listMessages
    }

    fun getAllUnreadedChats(): List<Chat> {
        return chats.filter { it.messages.find { !it.readable } != null }
    }
}