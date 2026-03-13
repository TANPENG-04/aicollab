package com.pengtan.aicollab.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

import java.util.List;


public interface AiAssistant {

    @SystemMessage("你是一个专业的文档助手，请用中文回复。")
    String summarize(@UserMessage String documentContent);

    @SystemMessage("基于以下文档内容回答用户问题：")
    String ragAnswer(@UserMessage String question, @V("context") List<String> documentContents);
}