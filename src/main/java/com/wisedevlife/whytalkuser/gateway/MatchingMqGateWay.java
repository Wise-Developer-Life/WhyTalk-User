package com.wisedevlife.whytalkuser.gateway;

import com.wisedevlife.whytalkuser.common.constants.MqConstant;
import com.wisedevlife.whytalkuser.common.utils.MessageQueueUtils;
import com.wisedevlife.whytalkuser.dto.message.MatchedUsersMessage;
import com.wisedevlife.whytalkuser.dto.message.MatchingJobMessage;
import com.wisedevlife.whytalkuser.dto.response.UserProfileResponse;
import com.wisedevlife.whytalkuser.entity.UserProfile;
import com.wisedevlife.whytalkuser.service.MatchingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MatchingMqGateWay {
    private final MatchingService matchingService;
    private final MessageQueueUtils messageQueueUtils;

    // TODO: use ack to ack message
    @RabbitListener(queues = MqConstant.MATCHING_QUEUE)
    public void matchingUser(MatchingJobMessage message) {
        List<UserProfile> matchedUsers = matchingService.matchUser(message.getUserId());

        if (matchedUsers.size() != 2) {
            log.info("No matched user found for user {}", message.getUserId());
            // TODO: design requeue message mechanism
            return;
        }

        UserProfile userProfile1 = matchedUsers.get(0);
        UserProfile userProfile2 = matchedUsers.get(1);

        UserProfileResponse user1 = UserProfileResponse.of(userProfile1);
        UserProfileResponse user2 = UserProfileResponse.of(userProfile2);

        MatchedUsersMessage matchedUsersMessage =
                MatchedUsersMessage.builder().user1(user1).user2(user2).build();

        messageQueueUtils.publishMessageToExchange(
                MqConstant.MATCHING_EXCHANGE,
                MqConstant.MATCHING_COMPLETE_ROUTING_KEY,
                matchedUsersMessage);
    }
}
