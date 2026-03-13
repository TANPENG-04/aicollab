# AICollab 项目需求文档（PRD）

## 1. 项目概述
- 项目名称：AICollab - AI 驱动的实时协作平台
- 目标用户：大学生团队、初创团队、自由职业者
- 核心价值：解决“文档多、协作乱、知识找不着”的痛点
- 2026 技术亮点：Java 21 Virtual Threads + LangChain4j RAG + 云原生

## 2. 核心功能需求（MVP）
### 功能 1：用户认证
- 注册、登录（JWT）
- 密码加密（BCrypt）

### 功能 2：工作空间管理
- 创建/加入工作空间（团队）

### 功能 3：文档协作
- CRUD 文档
- 实时多人编辑（WebSocket + Virtual Threads）

### 功能 4：AI 助手
- 文档一键总结
- RAG 知识库智能问答
- AI 任务自动生成

### 功能 5：任务看板
- Kanban 拖拽任务

## 3. 非功能需求
- 高并发：支持 5000+ 同时在线（Virtual Threads）
- 安全性：JWT + HTTPS
- 可扩展：微服务准备（未来拆分）
- 部署：Docker + GraalVM Native Image

## 4. 技术选型（已确认）
见 README.md

**版本**：MVP v0.1  
**负责人**：谭鹏