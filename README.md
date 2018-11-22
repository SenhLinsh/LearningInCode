# LearningInCode

笔记做多了, 发现查找起来太麻烦.

于是想到不如把笔记放在代码中, 想用的时候直接跳转该类, 查看注释便可.

## 接入

1. 在 Project 的 build.gradle 中:

```
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

2. 在 Module 的 build.gradle 中:

```
    dependencies {
        debugImplementation 'com.github.SenhLinsh:LearningInCode:+'
    }
```