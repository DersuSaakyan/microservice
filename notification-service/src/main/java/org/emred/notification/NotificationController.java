package org.emred.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    @PostMapping("/send")
    public void sentNotification() {
        System.out.println("Notification was sent");
    }
}
