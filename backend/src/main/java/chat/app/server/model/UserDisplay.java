package chat.app.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDisplay {

    Long id;
    String name;
    List<String> groups = new ArrayList<>();
}
