package chat.app.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GroupDisplay {
    Long id;
    String name;
    List<String> users = new ArrayList<>();
}
