package com.caobot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

class MessageServiceTest {
    @Value("${user.token}")
    private static String bot_token;

    @Test
    @DisplayName("token 이 제대로 들어갔는가 테스트")
    public void token_test() {
        assertThat(bot_token.equals("OTkxMDA3ODkyNDk4OTY4NjM2.GenBLb.cMcGXDTSnz-tjaA2PtPxa1F_Q9z0uG0ihS0otU"));
    }
}