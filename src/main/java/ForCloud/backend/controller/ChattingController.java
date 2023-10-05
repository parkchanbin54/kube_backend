package ForCloud.backend.controller;

import ForCloud.backend.config.BaseResponse;
import ForCloud.backend.dto.Chatting.ChattingResponse;
import ForCloud.backend.service.ChattingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ResponseBody
@RequiredArgsConstructor
@Slf4j
public class ChattingController {

    private final ChattingService chattingService;
    private final Logger logger = LoggerFactory.getLogger(ChattingController.class);


    @GetMapping("/api/member/{memberId}/rooms")
    public BaseResponse<List<ChattingResponse>> getChattingList(@PathVariable(name="memberId") Long memberId){
        log.info("memberId: {}",memberId);
        List<ChattingResponse> response=chattingService.getChattingList(memberId);
        return new BaseResponse<>(response);
    }

    @DeleteMapping("/api/member/{memberId}/rooms/{roomId}")
    public BaseResponse<String> deleteRoom(@PathVariable(name="memberId")Long memberId,@PathVariable(name="roomId")Long roomId){
        String response=chattingService.deleteRoom(memberId,roomId);

        return new BaseResponse<>(response);
    }

    @PatchMapping("/api/member/{memberId}/rooms/{roomId}")
    public BaseResponse<String> endRoom(@PathVariable(name="memberId")Long memberId,@PathVariable(name="roomId") Long roomId){
        String response=chattingService.endRoom(memberId,roomId);

        return new BaseResponse<>(response);
    }

}
