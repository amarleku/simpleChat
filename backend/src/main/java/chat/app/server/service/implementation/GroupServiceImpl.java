package chat.app.server.service.implementation;

import chat.app.server.mapper.Mapper;
import chat.app.server.model.GroupDto;
import chat.app.server.repository.GroupRepository;
import chat.app.server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    public GroupDto addGroup(GroupDto groupDto){
        return Mapper.convertToGroupDisplay(groupRepository.save(Mapper.convertToGroup(groupDto)));
    }

}
