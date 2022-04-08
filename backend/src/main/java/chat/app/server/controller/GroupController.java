package chat.app.server.controller;

import chat.app.server.mapper.Mapper;
import chat.app.server.model.*;
import chat.app.server.repository.GroupRepository;
import chat.app.server.repository.MessageRepository;
import chat.app.server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    MessageRepository messageRepository;

    @PostMapping(value = "/addGroup")
    public ResponseEntity sendReadReceipt(@RequestBody GroupDto groupDto) {
        groupService.addGroup(groupDto);
        return ResponseEntity.ok("Done");
    }

    @GetMapping(value = "/getGroups")
    public List<GroupDisplay> getAll() {

        return Mapper.convertListToGroup2(groupRepository.findAll());
    }


}