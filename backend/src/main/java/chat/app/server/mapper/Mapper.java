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
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setUsers(convertListToUserDisplay(group.getUsers()));
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
        //group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        //group.setUsers(convertUserDisplayToUsers(groupDto.getUsers()));
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

    public GroupDisplay convertToGroupDisplay2(Group group){
        GroupDisplay groupDto = new GroupDisplay();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        List<String> userNames = new ArrayList<>();
        for (User user:group.getUsers()
             ) {
            userNames.add(user.getUsername());
        }
        groupDto.setUsers(userNames);
        return groupDto;
    }

    public List<GroupDisplay> convertListToGroup2(List<Group> groups){
        List<GroupDisplay> groupDtoList = new ArrayList<>();
        for (Group group:groups
        ) {
            groupDtoList.add(convertToGroupDisplay2(group));
        }
        return groupDtoList;
    }

    public UserDisplay convertToGroupDisplay2(User user){
        UserDisplay userDisplay = new UserDisplay();
        userDisplay.setId(user.getId());
        userDisplay.setName(user.getUsername());
        List<String> groupNames = new ArrayList<>();
        System.err.println(user.getGroups());
        for (Group group:user.getGroups()
        ) {

            groupNames.add(group.getName());
        }
        userDisplay.setGroups(groupNames);
        return userDisplay;
    }


    public List<UserDisplay> convertListToUser2(List<User> users){
        List<UserDisplay> userDtoList = new ArrayList<>();
        for (User user:users
        ) {
            userDtoList.add(convertToGroupDisplay2(user));
        }
        return userDtoList;
    }
}




