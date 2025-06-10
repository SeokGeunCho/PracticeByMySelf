
package studio.aroundhub.onehourproject.member.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import studio.aroundhub.onehourproject.member.controller.dto.JoinRequest;
import studio.aroundhub.onehourproject.member.service.MemberService;


@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;


    @GetMapping("/hello")
    public String getHello() {

        return "Hello Around Hub Studio!";
    }


    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest) {

        String result = memberService.join(joinRequest);

        if ("success".equalsIgnoreCase(result)) {
            return "success";
        }else {
            return "fail";
        }
    }
}
