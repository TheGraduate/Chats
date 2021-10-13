
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatTest {

    @Test
    fun addUser() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)

        val result = service.addUser(49,100)

        assertTrue(result)
    }

    @Test
    fun deleteMessage() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)
        service.addUser(49,100)
        val message1 = Message(1,100,"a")
        val message2 = Message(2,101,"b")
        service.sendMessage(49,message1)
        service.sendMessage(50,message2)

        val result = service.deleteMessage(50,message2,101)

        assertTrue(result)
    }

    @Test
    fun getMessagesForBeginningWith() {
        val chat2 = Chat(50)
        val service = ChatService
        service.addChat(chat2)
        val message1 = Message(1,100,"a")
        val message2 = Message(2,101,"b")
        service.sendMessage(50,message1)
        service.sendMessage(50,message2)

        val result = service.getMessagesForBeginningWith(50,1)

       assertTrue(result?.isEmpty() == false)
    }

    @Test
    fun getAllMessages() {
        val chat2 = Chat(50)
        val service = ChatService
        service.addChat(chat2)
        val message2 = Message(2,101,"b")
        service.sendMessage(50,message2)

        val result2 = service.getAllMessages(50)

        assertTrue(result2?.isEmpty() == false)
    }

}