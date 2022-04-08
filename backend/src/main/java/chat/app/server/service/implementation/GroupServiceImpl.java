package chat.app.server.service.implementation;

import chat.app.server.mapper.Mapper;
import chat.app.server.model.Group;
import chat.app.server.model.GroupDto;
import chat.app.server.model.User;
import chat.app.server.model.UserDto;
import chat.app.server.repository.GroupRepository;
import chat.app.server.repository.UserRepository;
import chat.app.server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public GroupDto addGroup(GroupDto groupDto){

        Group currentGroup = Mapper.convertToGroup(groupDto);

        for (UserDto userDto:groupDto.getUsers()
        ) {
            User user = userRepository.findByUsername(userDto.getName());
            currentGroup.addUser(user);
            //System.err.println(currentGroup);

        }
        groupRepository.save(currentGroup);
        //return Mapper.convertToGroupDisplay(groupRepository.save(Mapper.convertToGroup(groupDto)));
        return null;
    }

}