package chat.app.server.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDisplayDto {
    public String sender;
    public String content;
    public String timeStamp;
}
