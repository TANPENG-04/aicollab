package com.pengtan.aicollab.config;

import com.pengtan.aicollab.service.AiAssistant;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: AiConfig
 * Description:
 * @Author Tanpeng
 * @Create 2026/3/13 19:43
 * @Version 1.0
 **/
@Configuration
public class AiConfig {
    @Autowired
    private OpenAiChatModel ChatModel;

    @Bean
    public AiAssistant aiAssistant() {
        AiAssistant aiAssisant = AiServices.builder(AiAssistant.class)
                .chatModel(ChatModel)
                .build();
        return aiAssisant;
    }
}
