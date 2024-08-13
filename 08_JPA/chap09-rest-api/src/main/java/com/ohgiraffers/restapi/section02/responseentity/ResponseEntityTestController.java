package com.ohgiraffers.restapi.section02.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    private List<UserDTO> users;

    public ResponseEntityTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "홍길동", new java.util.Date()));
        users.add(new UserDTO(2, "user02", "pass02", "유관순", new java.util.Date()));
        users.add(new UserDTO(3, "user03", "pass03", "이순신", new java.util.Date()));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {

        HttpHeaders headers = new HttpHeaders();
        // MIME 타입 예) text/html
        // json을 응답한다.
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);

    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByUserNo(@PathVariable/*("userNo")*/ int userNo) { // 생략 가능
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        // filer = 해당 결과 전부 불러옴
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).collect(Collectors.toList()).get(0);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공!", responseMap));
    }

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@RequestBody UserDTO newUser) {

        System.out.println(newUser);

        int lastUserNo = users.get(users.size() - 1).getNo();

        newUser.setNo(lastUserNo + 1);
        users.add(newUser);
        return ResponseEntity
                .created(URI.create("/entity/users/" + users.get(users.size() - 1).getNo()))  // 201 상태코드 + 생성된 리소스의 URI
                .build();
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO modifyInfo, @PathVariable int userNo) {

        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo)
                .collect(Collectors.toList()).get(0);

        foundUser.setId(modifyInfo.getId());
        foundUser.setPwd(modifyInfo.getPwd());
        foundUser.setName(modifyInfo.getName());

        return  ResponseEntity
                .created(URI.create("/entity/users/" + userNo))
                .build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<?> deleteUser(@PathVariable int userNo) {

        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo)
                .collect(Collectors.toList()).get(0);

        users.remove(foundUser);

        return ResponseEntity
                .noContent()
                .build();
    }
}
