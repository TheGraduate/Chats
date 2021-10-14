
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatServiceTest {

    @Test
    fun sendMessage() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)
        val message1 = Message(1,100,"a")

        val result = service.sendMessage(49,message1)

        assertTrue(result)
    }

    @Test
    fun addChat() {
        val chat1 = Chat(49)
        val service = ChatService

        val resultt = service.addChat(chat1)

        assertTrue(resultt)
    }

    @Test
    fun deleteChat() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)

        val result = service.deleteChat(chat1)

        assertTrue(result)
    }

    @Test
    fun getAllUnreadedChats() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)
        val message1 = Message(1,100,"a")
        service.sendMessage(49,message1)

        val result = service.getAllUnreadedChats()

        assertFalse(result.isEmpty())
    }

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

    /*@Test
    fun getMessagesForBeginningWith() {
        val chat2 = Chat(50)
        val service = ChatService
        service.addChat(chat2)
        val message1 = Message(1,100,"a")
        val message2 = Message(2,101,"b")
        service.sendMessage(50,message1)
        service.sendMessage(50,message2)

        val result = service.getMessagesForBeginningWith(50,1,1)

        assertNotNull(result)
    }*/

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