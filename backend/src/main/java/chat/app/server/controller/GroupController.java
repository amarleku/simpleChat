package chat.app.server.controller;

import chat.app.server.mapper.Mapper;
import chat.app.server.model.Group;
import chat.app.server.model.GroupDisplay;
import chat.app.server.model.GroupDto;
import chat.app.server.model.ReadReceiptRequest;
import chat.app.server.repository.GroupRepository;
import chat.app.server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    GroupRepository groupRepository;

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
