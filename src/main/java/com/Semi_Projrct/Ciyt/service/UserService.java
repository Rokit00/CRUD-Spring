package com.Semi_Projrct.Ciyt.service;

import com.Semi_Projrct.Ciyt.dto.UserDTO;
import com.Semi_Projrct.Ciyt.entity.UserEntity;
import com.Semi_Projrct.Ciyt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userServiceRepository;
    public void signup(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userServiceRepository.save(userEntity);

    }

    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> byUserEmail = userServiceRepository.findByUserEmail(userDTO.getUserEmail());
        if (byUserEmail.isPresent()){
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            UserEntity userEntity = byUserEmail.get();
            if(userEntity.getUserPassword().equals(userDTO.getUserPassword())){
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            }
        }else {
            // 비밀번호 불일치(로그인실패)
            return null;
        }
        // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
        return null;
    }
}
