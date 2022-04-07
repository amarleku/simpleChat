package chat.app.server.mapper;


import chat.app.server.model.*;
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

    public List<GroupDto> convertListToGroupDisplay(List<Group> groups){
        List<GroupDto> groupDtoList = new ArrayList<>();
        for (Group group:groups
        ) {
            groupDtoList.add(convertToGroupDisplay(group));
        }
        return groupDtoList;
    }

    public GroupDto convertToGroupDisplay(Group group){
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getGroupId());
        groupDto.setName(group.getName());
        //groupDto.setUsers(convertListToGroupDisplay(group.));
        return groupDto;
    }
    public List<Group> convertListToGroup(List<GroupDto> groups){
        List<Group> groupDtoList = new ArrayList<>();
        for (GroupDto groupDto:groups
        ) {
            groupDtoList.add(convertToGroup(groupDto));
        }
        return groupDtoList;
    }

    public Group convertToGroup(GroupDto groupDto){
        Group group = new Group();
        group.setGroupId(groupDto.getId());
        group.setName(groupDto.getName());
        group.setUsers(convertListToUserDisplay(groupDto.getUsers()));
        return group;
    }

    public UserDto convertToUserDisplay(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getUsername());
        userDto.setConnected(user.getConnected());
        return userDto;
    }

    public List<UserDto> convertListToUserDisplay(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user1:users
        ) {
            userDtos.add(convertToUserDisplay(user1));
        }
        return userDtos;
    }

    public User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getName());
        user.setConnected(userDto.getConnected());
        return user;
    }

    public List<User> convertUserDisplayToUsers(List<UserDto> userDtos) {
        List<User> users= new ArrayList<>();

        for(UserDto u: userDtos) {
            users.add(convertToUser(u));
        }

        return users;
    }

}
