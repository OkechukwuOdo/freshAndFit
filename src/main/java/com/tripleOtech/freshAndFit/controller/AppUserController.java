package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PaginationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;
    @Operation(
            description = "Edith a user"
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "Ok"
    )
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<AppUser>> editUser(
            @PathVariable Long userId,
            @RequestBody AppUserRequestDto request) {
        return ResponseEntity.ok(appUserService.editUser(userId, request));
    }
    @Operation(
            description = "Get a user by Id"
    )
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<AppUser>> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(appUserService.getUserById(userId));
    }

    @Operation(
            description = "Get All Users a users"
    )
    @GetMapping("/getAllUsers")
    public ResponseEntity<PaginationResponse> getAllUsers(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                          @RequestParam(value = "limit", defaultValue = "5") int limit) {
        return ResponseEntity.ok(appUserService.getAllUsers(offset,limit));
    }
    @Operation(
            description = "DeleteUser a user by Id"
    )
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<AppUser>> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok(appUserService.deleteUser(userId));
    }
}
