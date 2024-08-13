package com.ohgiraffers.restapi.section05.swagger;

import com.ohgiraffers.restapi.section05.swagger.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name="SWAGGER 테스트 컨트롤러", description = "스웨거 테스트 입니다.") // 스웨거 테스트 이름을 설정
@RestController
@RequestMapping("/swagger") //http://localhost:8080/swagger-ui/index.html 에 가서 조회 가능하다.
public class SwaggerTestController {

    private List<UserDTO> users;

    public SwaggerTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "홍길동", new java.util.Date()));
        users.add(new UserDTO(2, "user02", "pass02", "유관순", new java.util.Date()));
        users.add(new UserDTO(3, "user03", "pass03", "이순신", new java.util.Date()));
    }

    @GetMapping("/users")
    @Operation(summary = "USER 목록 조회", description = "유저 목록 전체를 조회합니다.")    // 테스트 단위 별 이름 설정
    public ResponseEntity<ResponseMessage> findAllUsers() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("users", users);
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
