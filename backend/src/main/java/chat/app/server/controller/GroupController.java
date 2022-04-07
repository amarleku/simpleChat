package chat.app.server.controller;

import chat.app.server.model.GroupDto;
import chat.app.server.model.ReadReceiptRequest;
import chat.app.server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping(value = "/addGroup")
    public ResponseEntity sendReadReceipt(@RequestBody GroupDto groupDto) {
        groupService.addGroup(groupDto);
        return ResponseEntity.ok("Done");
    }


}
