package chat.app.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long groupId;

    @Column(name = "username", unique = true)
    private String name;

    //@ManyToMany(mappedBy = "groups")
   // List<User> users;
}
