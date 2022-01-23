package deliver.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliver")
@RequiredArgsConstructor
public class DeliverOrderController {

    @PostMapping
    public void deliverOrder(

    ) { //request용 도메인?

        //orderPayedPort 로 command 유효성 검증한 후 호출
    }
}
