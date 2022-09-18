---
home: true
heroImage: img/bg.gif
heroText: SPRING-TUTORIAL
tagline: ☕ spring-tutorial 是一个以简单范例来展示 spring 在 web 开发中的各种应用的教程。
bannerBg: none
postList: none
footer: CC-BY-SA-4.0 Licensed | Copyright © 2018-Now Dunwu
---

![license](https://badgen.net/github/license/dunwu/spring-tutorial)
![build](https://travis-ci.com/dunwu/spring-tutorial.svg?branch=master)

> **`spring-tutorial`** 是一个以简单范例来展示 spring 在 web 开发中的各种应用的教程。
>
> - 🔁 项目同步维护：[Github](https://github.com/dunwu/spring-tutorial/) | [Gitee](https://gitee.com/turnon/spring-tutorial/)
> - 📖 电子书阅读：[Github Pages](https://dunwu.github.io/spring-tutorial/) | [Gitee Pages](http://turnon.gitee.io/spring-tutorial/)

## 📖 内容

### 综合

- [Spring 概述](01.Java/13.框架/01.Spring/00.Spring综合/01.Spring概述.md)
- [SpringBoot 知识图谱](01.Java/13.框架/01.Spring/00.Spring综合/21.SpringBoot知识图谱.md)
- [SpringBoot 基本原理](01.Java/13.框架/01.Spring/00.Spring综合/22.SpringBoot基本原理.md)
- [Spring 常见面试题](01.Java/13.框架/01.Spring/00.Spring综合/99.Spring常见面试题.md)

### 核心

- [Spring 依赖注入（IoC）](01.Java/13.框架/01.Spring/01.Spring核心/01.Spring依赖注入.md)
- [Spring Bean 生命周期](01.Java/13.框架/01.Spring/01.Spring核心/02.Spring生命周期.md)
- [Spring AOP](01.Java/13.框架/01.Spring/01.Spring核心/03.SpringAop.md)
- [Spring 资源管理](01.Java/13.框架/01.Spring/01.Spring核心/04.Spring资源管理.md)
- [SpringBoot 教程之快速入门](01.Java/13.框架/01.Spring/01.Spring核心/21.SpringBoot之快速入门.md)
- [SpringBoot 之属性加载](01.Java/13.框架/01.Spring/01.Spring核心/22.SpringBoot之属性加载.md)
- [SpringBoot 之 Profile](01.Java/13.框架/01.Spring/01.Spring核心/23.SpringBoot之Profile.md)

### 数据

- [Spring 连接数据源](01.Java/13.框架/01.Spring/02.Spring数据/01.Spring连接数据源.md)
- [Spring 之 JDBC](01.Java/13.框架/01.Spring/02.Spring数据/02.Spring之JDBC.md)
- [SpringBoot 之 Mybatis](01.Java/13.框架/01.Spring/02.Spring数据/22.SpringBoot之Mybatis.md)
- [SpringBoot 之 MongoDB](01.Java/13.框架/01.Spring/02.Spring数据/23.SpringBoot之MongoDB.md)
- [SpringBoot 之 Elasticsearch](01.Java/13.框架/01.Spring/02.Spring数据/24.SpringBoot之Elasticsearch.md)

### Web

- [Spring WebMvc](01.Java/13.框架/01.Spring/03.SpringWeb/01.SpringWebMvc.md)
- [SpringBoot 之应用 EasyUI](01.Java/13.框架/01.Spring/03.SpringWeb/21.SpringBoot之应用EasyUI.md)

### IO

- [SpringBoot 之异步请求](01.Java/13.框架/01.Spring/04.SpringIO/01.SpringBoot之异步请求.md)
- [SpringBoot 之 Json](01.Java/13.框架/01.Spring/04.SpringIO/02.SpringBoot之Json.md)
- [SpringBoot 之邮件](01.Java/13.框架/01.Spring/04.SpringIO/03.SpringBoot之邮件.md)

### 集成

- [Spring 集成缓存中间件](01.Java/13.框架/01.Spring/05.Spring集成/01.Spring集成缓存.md)
- [Spring 集成定时任务中间件](01.Java/13.框架/01.Spring/05.Spring集成/02.Spring集成调度器.md)
- [Spring 集成 Dubbo](01.Java/13.框架/01.Spring/05.Spring集成/03.Spring集成Dubbo.md)

### 其他

- [Spring4 升级](01.Java/13.框架/01.Spring/99.Spring其他/01.Spring4升级.md)
- [SpringBoot 之 banner](01.Java/13.框架/01.Spring/99.Spring其他/21.SpringBoot之banner.md)
- [SpringBoot 之 Actuator](01.Java/13.框架/01.Spring/99.Spring其他/22.SpringBoot之Actuator.md)

## 💻 示例

### 重要库版本

| 库或工具             | 版本            | 说明                                                                                                                                                                                                          |
| -------------------- | --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Spring Framework     | 5.0.2.RELEASE   |                                                                                                                                                                                                               |
| JDK                  | 1.8+            | Spring5 开始，要求 JDK8+                                                                                                                                                                                      |
| Maven                | 3.5.2           | 本项目使用 [maven](https://maven.apache.org/index.html) 作为构建工具。                                                                                                                                        |
| jetty-maven-plugin   | 9.4.8.v20171121 | [Jetty](http://www.eclipse.org/jetty/) 可作为 web 服务器和 servlet 容器。此插件可以免部署启动 web app。                                                                                                       |
| tomcat7-maven-plugin | 2.2             | [Tomcat](https://tomcat.apache.org/index.html) 可作为 web 服务器和 servlet 容器。此插件可以免部署启动 web app。Tomcat 早已经发布 Tomcat8，但是 maven 插件 一直没有提供 tomcat8 的支持（最后更新为 2013 年）。 |

### 启动

为了便于展示示例，所有 war 包形式的项目都可以使用 maven 插件快速启动嵌入式服务器，支持 Tomcat 和 Jetty 两种方式。

Tomcat7 嵌入式服务器启动：

```bash
$ mvn tomcat7:run -Dmaven.test.skip=true
```

Jetty 嵌入式服务器启动：

```bash
$ mvn jetty:run -Dmaven.test.skip=true
```

如果子项目中无特殊说明，默认端口配置为 8089，当然，你可以自己指定。

启动成功后，访问 http://localhost:8089 。

### 规范

- 推荐使用 [IDEA](https://www.jetbrains.com/idea/) 作为 IDE
- 代码规范使用 [阿里巴巴 Java 开发手册](https://github.com/alibaba/p3c)
  - 如果你使用 IDEA 作为你的 IDE，推荐安装 Alibaba-Java-Coding-Guidelines 插件来做静态检查。

## 📚 资料

- **官方**
  - [Spring 官网](https://spring.io/)
  - [Spring Framework 官方文档](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html)
  - [Spring Github](https://github.com/spring-projects/spring-framework)
- **书籍**
  - [《 Spring 实战（第 5 版）》](https://book.douban.com/subject/34949443/)
- **教程**
  - [《小马哥讲 Spring 核心编程思想》](https://time.geekbang.org/course/intro/265)
  - [geekbang-lessons](https://github.com/geektime-geekbang/geekbang-lessons)
  - [跟我学 Spring3](http://jinnianshilongnian.iteye.com/blog/1482071)

## 🚪 传送

◾ 💧 [钝悟的 IT 知识图谱](https://dunwu.github.io/waterdrop/) ◾ 🎯 [钝悟的博客](https://dunwu.github.io/blog/) ◾
