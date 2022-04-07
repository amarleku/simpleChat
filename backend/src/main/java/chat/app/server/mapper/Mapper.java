package chat.app.server.mapper;


import chat.app.server.model.Message;
import chat.app.server.model.MessageDisplayDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Mapper {

    public List<MessageDisplayDto> convertListToMessageDisplay(List<Message> messages){
        List<MessageDisplayDto> messageDisplayDtos = new ArrayList<>();
        for (Message message:messages
             ) {
            messageDisplayDtos.add(convertToMessageDisplay(message));
        }
        return messageDisplayDtos;
    }

    public MessageDisplayDto convertToMessageDisplay(Message message){
        MessageDisplayDto messageDisplayDto = new MessageDisplayDto();
        messageDisplayDto.setSender(message.getSender());
        messageDisplayDto.setContent(message.getContent());
        messageDisplayDto.setTimeStamp(String.valueOf(message.getTimestamp()));
        return messageDisplayDto;
    }
}
