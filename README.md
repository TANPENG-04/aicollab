# AICollab - AI 实时协作平台

[![Java 21](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/technologies/javase/jdk21)
[![Spring Boot 3.5.11](https://img.shields.io/badge/Spring%20Boot-3.5.11-brightgreen)](https://spring.io)

**Java 项目**（Virtual Threads + LangChain4j + 云原生）

## 📋 项目文档
- [需求文档 (PRD)](docs/PRD.md)
- [系统架构图](docs/aicollab-architecture-diagram.png)
- [数据库 ER 图](docs/aicollab-er.png)
- [接口设计文档](docs/API.md)

## 🚀 技术亮点
- Java 21 Virtual Threads（高并发实时协作）
- Spring Boot 4.0 + JPA + JWT
- LangChain4j RAG AI（文档智能总结）
- Docker + GraalVM Native Image（秒级启动）

## 快速启动
```bash
./mvnw spring-boot:run
访问：http://localhost:8080/swagger-ui.html （自动接口文档）
作者：tanpeng | GitHub Star 欢迎点亮！