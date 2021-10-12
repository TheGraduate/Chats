
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ChatTest {

    @Test
    fun addUser() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)

        val result = chat1.addUser(100)

        assertTrue(result)
    }
/*
    @Test
    fun deleteMessage() {
        val chat1 = Chat(49)
        val service = ChatService
        service.addChat(chat1)
        chat1.addUser(100)
        val message1 = Message(1,100,"a")
        val message2 = Message(2,101,"b")
        service.sendMessage(49,message1)
        service.sendMessage(50,message2)

        val result = chat1.deleteMessage(message2,101)

        assertTrue(result)
    }

 */
/*
    @Test
    fun getMessagesForBeginningWith() {
        val chat2 = Chat(50)
        val service = ChatService
        service.addChat(chat2)
        val message1 = Message(1,100,"a")
        val message2 = Message(2,101,"b")
        service.sendMessage(50,message1)
        service.sendMessage(50,message2)

        val result = chat2.getMessagesForBeginningWith(1)

       assertFalse(result.isEmpty())
    }

 */

    @Test
    fun getAllMessages() {
        val chat2 = Chat(50)
        val service = ChatService
        service.addChat(chat2)
        val message2 = Message(2,101,"b")
        service.sendMessage(50,message2)

        val result2 = chat2.getAllMessages()

        assertFalse(result2.isEmpty())
    }

}