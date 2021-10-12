import ChatService.chats

class Chat (val chatId: Int) {

    val users = mutableListOf<Int>()
    val messages = mutableListOf<Message>()

    fun addUser (userId: Int): Boolean {
        users.add(userId)
        if (users.contains(userId)) {
            return true
        }
        return false
    }

    fun deleteMessage (message: Message, userId: Int): Boolean {
        if (messages.contains(message) && userId == message.senderId) {
            messages.remove(message)
            val emptyChat = chats.find { it.messages.isEmpty() }
            chats.remove(emptyChat)
            return true
        }
        return false
    }

    fun getMessagesForBeginningWith (messageId: Int): List<Message> {
        val listMessages = messages.filter { it.messageId >= messageId }
        listMessages.forEach { it.readable = true }
        return listMessages
    }

    fun getAllMessages (): List<Message> {
        messages.forEach { it.readable = true }
        return messages
    }

    /*
    fun getMessagesForQuantities (quantitiesMessage: Int ): List<Message> {
        val listMessages = messages.filter {  }
        val list = arrayListOf<Message>()
            messages.filter
        return listMessages
    }
     */
}


