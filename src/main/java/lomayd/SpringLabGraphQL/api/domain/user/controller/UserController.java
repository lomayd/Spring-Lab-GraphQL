package lomayd.SpringLabGraphQL.api.domain.user.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import lomayd.SpringLabGraphQL.api.domain.user.dto.UserRequestDto;
import lomayd.SpringLabGraphQL.api.domain.user.dto.UserResponseDto;
import lomayd.SpringLabGraphQL.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MutationMapping
    public void joinUser(@Argument UserRequestDto.UserJoin userJoin) {
        userService.joinUser(userJoin);
    }

    @QueryMapping
    public UserResponseDto.UserInfo getUser(@Argument String id) {
        return userService.getUser(id);
    }

    @MutationMapping
    public void modifyUser(@Argument String id, @Argument UserRequestDto.UserModify userModify) {
        userService.modifyUser(id, userModify);
    }

    @MutationMapping
    public void removeUser(@Argument String id) {
        userService.removeUser(id);
    }
}