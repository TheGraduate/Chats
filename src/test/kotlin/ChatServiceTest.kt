
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
}