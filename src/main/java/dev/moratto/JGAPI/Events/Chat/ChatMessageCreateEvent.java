package dev.moratto.JGAPI.Events.Chat;

import dev.moratto.JGAPI.Entities.Chat.ChatMessage;

public class ChatMessageCreateEvent extends GenericMessageEvent {
    public ChatMessageCreateEvent(ChatMessage message) {
        super(message);
    }
    public ChatMessage getMessage() {
        return super.getMessage();
    }
    public String getServerId() {
        return super.getServerId();
    }
}
