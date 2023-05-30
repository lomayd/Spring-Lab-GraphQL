package lomayd.SpringLabGraphQL.api.domain.user.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import lomayd.SpringLabGraphQL.api.domain.user.User;
import lomayd.SpringLabGraphQL.api.domain.user.dto.UserRequestDto;
import lomayd.SpringLabGraphQL.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MutationMapping
    public User joinUser(@Argument UserRequestDto.UserJoin userInput) {
        return userService.joinUser(userInput);
    }

    @QueryMapping
    public User getUser(@Argument String id) {
        return userService.getUser(id);
    }

    @MutationMapping
    public User modifyUser(@Argument String id, @Argument UserRequestDto.UserModify userInput) {
        return userService.modifyUser(id, userInput);
    }

    @MutationMapping
    public void removeUser(@Argument String id) {
        userService.removeUser(id);
    }
}