package com.team7.spliito_server.controller;

import com.team7.spliito_server.dto.CreateGroupRequest;
import com.team7.spliito_server.dto.GroupResponse;
import com.team7.spliito_server.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * 그룹 생성 API 엔드포인트
     *
     * @param request CreateGroupRequest 요청 DTO
     * @return 생성된 그룹의 URL을 포함하는 JSON 응답
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> createGroup(@Valid @RequestBody CreateGroupRequest request) {
        String groupUrl = groupService.createOrUpdateGroup(request);

        Map<String, String> response = new HashMap<>();
        response.put("groupUrl", groupUrl);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public List<GroupResponse> getAllGroups() {
        return groupService.getAllGroups();
    }
}

