package lomayd.SpringLabGraphQL.api.domain.user.service;

import org.springframework.stereotype.Service;

import lomayd.SpringLabGraphQL.api.domain.user.User;
import lomayd.SpringLabGraphQL.api.domain.user.dto.UserRequestDto;
import lomayd.SpringLabGraphQL.api.domain.user.dto.UserResponseDto;
import lomayd.SpringLabGraphQL.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(UserRequestDto.UserJoin userJoin){
        User user = User.builder()
                .id(userJoin.getId())
                .password(userJoin.getPassword())
                .name(userJoin.getName())
                .nickname(userJoin.getNickname())
                .email(userJoin.getEmail())
                .age(userJoin.getAge())
                .build();

        userRepository.save(user);
    }

    public UserResponseDto.UserInfo getUser(String id) {
        User user = userRepository.findById(id).get();

        return UserResponseDto.UserInfo.of(user);
    }

    public void modifyUser(String id, UserRequestDto.UserModify userModify) {
        User user = userRepository.findById(id).get();

        user.setPassword(userModify.getPassword());
        user.setName(userModify.getName());
        user.setNickname(userModify.getNickname());
        user.setEmail(userModify.getEmail());
        user.setAge(userModify.getAge());

        userRepository.save(user);
    }
    public void removeUser(String id) {
        userRepository.deleteById(id);
    }
}