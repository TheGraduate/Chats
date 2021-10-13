
fun main() {

    val chat1 = Chat(49)
    val chat2 = Chat(50)

    val service = ChatService
    println(service.addChat(chat1))
    println(service.addChat(chat2))

    val message1 = Message(1,100,"a")
    val message2 = Message(2,99,"b")
    val message3 = Message(3,101,"c")

    println(service.sendMessage(49,message1))
    println(service.sendMessage(49,message2))
    println(service.sendMessage(49,message3))
    println(service.getAllMessages(49))
    println(service.addUser(49, 101))
    println(service.getMessagesForBeginningWith(49, 1))

}