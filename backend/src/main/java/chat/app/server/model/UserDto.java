package chat.app.server.model;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;

    private List<Group> groups;

    private Boolean connected;
}
