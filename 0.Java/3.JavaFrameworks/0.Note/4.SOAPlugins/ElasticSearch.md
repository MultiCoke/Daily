# ElasticSearch

## 1.简介

### 1.1 ElasticSearch简介

+ 搜索服务器，速度快，功能强
+ ElasticSearch是一个基于Lucene的搜索服务器
+ 是一个分布式、高扩展、高实时的搜索与数据分析引擎
+ 基于RESTful web接口
+ 应用场景：
  + 搜索：海量数据的查询 
  + 日志数据分析
  + 实时数据分析
+ 注意：MySQL有事务性,而ElasticSearch没有事务性,所以你删了的数据是无法恢复的

### 1.2 倒排索引

+ 将各个文档中的内容，进行分词，形成词条。然后记录词条和数据的唯一标识（id）的对 应关系，形成的产物。

  ![image-20201115191217414](C:\Users\HY\AppData\Roaming\Typora\typora-user-images\image-20201115191217414.png)

## 2. 核心概念

### 2.1 索引

+ ElasticSearch存储数据的地方，可以理解成关系型数据库中的数据库概念

  ![image-20201115192023462](C:\Users\HY\AppData\Roaming\Typora\typora-user-images\image-20201115192023462.png)

### 2.2 操作索引

+ 格式：http://ip:port/index_name
+ 添加索引：PUT ...
+ 查询索引：GET  .../_all 查询所有索引
+ 删除索引：DELETE ...
+ 关闭索引：POST .../_close
+ 打开索引：POST .../_open

### 2.3 映射

+ mapping定义了每个字段的类型、字段所使用的分词器等。相当于关系型数据库中的表结构

### 2.4 操作映射

#### 2.4.1 映射数据类型

+ 简单数据类型
  + 字符串
    + text：分词，不支持聚合
    + keyword：不会分词
  + 数值
  + 布尔
  + 二进制
  + 范围类型  interge_range, float_range
  + 日期 date
+ 复杂数据类型
  + 数组 []
  + 对象 {}

#### 2.4.2操作映射

+ 添加映射

  ```json
  PUT person/_mapping
  {
    "properties": {
      "name": {
        "type": "text"
      },
      "age": {
        "type": "integer"
      }
    }
  }
  ```

+ 创建索引并添加映射

  ```json
  PUT person
  {
    "mappings":{
      "properties": {
        "name": {
          "type": "text"
        },
        "age": {
          "type": "integer"
        }
      }
    }
  }
  
  ```

+ 查询映射

  ```json
  GET person/_mapping
  ```

+ 添加字段

  ```json
  PUT person/_mapping
  {
    "properties": {
      "address": {
        "type": "text"
      }
    }
  }
  ```

### 2.5 文档

+ Elasticsearch中的最小数据单元，常以json格式显示。一个document相当于关系型数据库中的一行数据。

### 2.6 操作文档

+ 添加文档，指定id

  ```json
  PUT person/_doc/1
  {
    "name": "张三",
    "age": 23,
    "address": "杭州市江干区"
  }
  ```

+ 添加文档指定id会随机生成一个id

+ 查看指定索引的指定文档

  ```json
  GET person/_doc/id
  ```

+ 查看所有文档

  ```json
  GET person/_search
  ```

+ 删除指定文档

  ```json
  DELETE person/_doc/id
  ```

### 2.7 分词器

+ 将一段文本，按照一定逻辑，分析成多个词语的一种工具

+ 默认分词器

  ```json
  GET /_analyze
  {
    "analyzer": "standard",
    "text": "xxxxx"
  }
  ```

+ 粗粒度分词器

  ```json
  GET /_analyze
  {
    "analyzer": "ik_max_word",
    "text": "xxx"
  }
  ```

+ 细粒度分词器

  ```json
  GET /_analyze
  {
    "analyzer": "ik_smart",
    "text": "xxx"
  }
  ```

  

+ 自定义字典

  ```
  # 进入文件夹
  cd /opt/elasticsearch-analysis-ik-7.4.0/config
  
  # 新建或者修改字典文件
  vim extra_personal.dic
  
  # 打开配置文件添加自定义配置
  vim IKAnalyzer.cfg.xml
  ```

### 2.8 查询文档

+ 词条查询：term

  + 词条查询不会分析查询条件，只有当词条和查询字符串完全匹配时才匹配搜索

    ```json
    GET person/_search
    {
      "query": {
        "term": {
          "name":{
            "value": "张三"
          }
        }
      }
    }
    ```

+ 全文查询：match

  + 全文查询会分析查询条件，先将查询条件进行分词，然后查询，求并集

    ```json
    GET person/_search
    {
      "query": {
        "match": {
          "address": "杭州"
        }
      }
    }
    ```

## 3. JavaAPI

### 3.1 ES整合SpringBoot

+ Maven坐标

  ```xml
  
  ```

  