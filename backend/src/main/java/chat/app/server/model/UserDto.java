package chat.app.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private List<Group> groups;

    private Boolean connected;
}
