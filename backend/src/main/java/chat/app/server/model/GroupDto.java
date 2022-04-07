package chat.app.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupDto {
    Long id;
    String name;
    List<UserDto> users = new ArrayList<>();
}
