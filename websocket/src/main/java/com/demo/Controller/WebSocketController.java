package com.demo.Controller;

import com.demo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * <p>
 * Create on 2019/02/26
 *
 * @author zouyongsheng
 */
@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @MessageMapping("/sendTest")
    @SendTo("/topic/sendTest2")
    public Message send(Message message){

        System.out.println("收到客户端消息：" + message.toString());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        message.setDate(df.format(new Date()));
        return message;
    }

    /**
     *  客户端只要订阅了/topic/callback主题，服务器主动推数据
     * @return
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public Object callBack(){
        System.out.println("执行定时任务");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
        return "callback";
    }

    @SubscribeMapping("/subscribeTest")
    public Message sendMessage(){

        Message message = new Message();
        message.setMessage("服务器收到订阅");
        return message;
    }


}
