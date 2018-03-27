# 毕设题目--基于搜索引擎优化的健康问答系统 #

## 项目构建：## 
 - 采用spring boot + mybatis 框架构建
 - 前端模型采用 theleaf 模板
 - 爬虫模块采用 webmagic 框架
 - 搜索引擎模块采用 luence 框架
 - 数据源采用 DruidDataSource，数据库采用MySQL
 - 项目构建采用maven进行构建

## 项目模块：##
本项目划分出7个模块（module），各模块之间的作用及依赖关系如下：
 - ask-seo: 搜索引擎模块  ->ask-model
 - ask-spider: 爬虫模块，独立的一个模块  ->ask-dao
 - ask-model: 模型层模块，负责存放各种bean
 - ask-dao: 数据持久层模块，负责数据库的CURD操作 ->ask-model
 - ask-service: 业务层模块，负责项目中业务的处理 ->ask-dao，ask-seo
 - ask-web: web层模块，负责与视图层交互 ->ask-service
 - ask-util: 工具模块，存放项目中各种共用的工具类

## 项目数据库设计 ##
此文档待完善