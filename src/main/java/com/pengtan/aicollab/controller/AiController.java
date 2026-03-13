package com.pengtan.aicollab.controller;

import com.pengtan.aicollab.service.AiAssistant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@Tag(name = "AI 模块")
public class AiController {

  @Autowired
  private AiAssistant openAiChatModel;


    @Operation(summary = "AI 一键总结文档")
    @PostMapping("/summarize")
    public String summarize(@RequestBody String content) {
        return openAiChatModel.summarize(content);
    }

    @Operation(summary = "AI RAG 智能问答")
    @PostMapping("/ask")
    public String ask(@RequestBody String question, @RequestParam Long documentId) {
        // 这里可以从数据库取文档内容（简化版）
        return openAiChatModel.ragAnswer(question, List.of("文档内容占位"));
    }
}