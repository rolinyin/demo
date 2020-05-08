# demo

#### 目录结构

```     
├─sql  
│  └─init  
├─src  
│  ├─main  
│  │  ├─java  
│  │  │  └─com   
│  │  │      └─yonyou  
│  │  │          └─demo    
│  │  │              ├─kafka  
│  │  │              │  ├─entity     
│  │  │              │  └─service    
│  │  │              └─redis  
│  │  │                  ├─api  
│  │  │                  ├─config  
│  │  │                  ├─entity  
│  │  │                  ├─repository  
│  │  │                  └─service             
│  │  └─resources  
│  │      └─mappings         
│  └─test  
│      ├─java  
│      │  └─com  
│      │      └─yonyou  
│      │          └─demo  
│      │              ├─kafka  
│      │              │  └─service    
│      │              └─redis  
│      │                  └─service                          
│      └─resources         
└─README.md  
```


#### 目录说明

* `sql/init`文件夹存放脚本文件。
* `src/main/java`存放kafka和redis的相关业务代码。
* `src/main/resource`存放properties文件、xml文件。
* `src/test/java`存放redis和kafka相关的测试类。
* `src/test/resource`存放单元测试相关配置文件。
