package com.caobot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

class MessageServiceTest {
    private static String bot_token;

    // Test 쪽은 @Value 가 안된다. 생각
    @Value("${user.token}")
    private void setBotToken(String value) {
        this.bot_token = value;
    }

    @Test
    @DisplayName("token 이 비었는가 테스트")
    public void token_test() {
        assertThat(!bot_token.isEmpty()).isTrue();
    }
}