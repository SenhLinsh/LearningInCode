package com.linsh.code.build;

public class LearnSettingModuleBuildGradle {
}

/*

                                                                                    // ## apply plugin ##
                                                                                    // 声明了接下来要用到哪些插件的内容 (需要在 project 的 build.gradle 中添加依赖)

apply plugin: 'com.android.application'                                             // 应用插件, 指定该 Module 为 APP 应用
apply plugin: 'com.android.library'                                                 // 依赖库插件, 指定该 Module 为依赖库
apply plugin: 'kotlin-android'                                                      // kotlin 插件

                                                                                    // ## android ##
android {

    compileSdkVersion 26
                                                                                    // 编译应用的 Android API 版本
    buildToolsVersion '28.0.3'                                                      // 构建工具版本 (可省略?)

                                                                                    // ## defaultConfig ##
                                                                                    // 配置应用的默认属性，可以覆盖 AndroidManifest.xml 中的属性
    defaultConfig {
        applicationId "com.linsh.app"
                                                                                    // 覆盖了 AndroidManifest 中的 package name (覆盖了应用唯一标识的属性)
        minSdkVersion 16                                                            // 配置运行应用的最小 API
        targetSdkVersion 26                                                         // 目标版本 / 运行版本, 代码运行时的目标版本
                                                                                    // 如果使用的代码版本比目标版本高, 则会进行降版本处理, 表现为目标版本的特性
        versionCode 1                                                               // 应用的版本号
        versionName "1.0"                                                           // 版本名称
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

                                                                                    // 还可以添加签名，占位符等等

        ndk {
                                                                                    // 指定 ndk 需要兼容的架构
                                                                                    // (这样其他依赖包里 mips, x86, armeabi, arm-v8 之类的 so 会被过滤掉)
            abiFilters "armeabi-v7a"
        }
    }

    signingConfigs {                                                                // ## 签名配置 ##
        config {
            keyAlias 'code'
            keyPassword '*****'
            storeFile file('../keystore/xxx.jks')
            storePassword '*****'
        }
    }

    buildTypes {                                                                    // ## buildTypes ##
                                                                                    // 用来定义如何构建和打包不同类型的应用，常见的就是测试和生产
        debug {                                                                     // debug 环境下的配置

                                                                                    // 自定义生成或修改 BuildConfig 的字段 (Sync之后就有了)
            buildConfigField "boolean", "BOOLEAN_CONFIG", "true"                    // 生成 BuildConfig 的字段
            buildConfigField "String", "STRING_CONFIG", '"yes"'                     // 生成 BuildConfig 的字段

            resValue "string", "app_name0", "LearningInCode0"                       // 生成资源文件(strings.xml的值), 可在AndroidManifest中引用 @string/app_name0
            manifestPlaceholders = [app_name: "LearningInCode"]                     // 替换 AndroidManifest 中定义的变量, 如: ${app_name}

            debuggable true                                                         // 是否支持调试
            jniDebuggable true                                                      // 是否支持jni调试
            zipAlignEnabled false                                                   // 是否支持Zip Align
            minifyEnabled false                                                     // 是否去除无用的资源
            shrinkResources false                                                   // 打开资源压缩
        }

        release {
            debuggable false
            jniDebuggable false
            zipAlignEnabled true
            minifyEnabled true
            shrinkResources true

            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'      // 混淆文件的指定

                                                                                    // 以下在 release 环境下生成对应的变量, 以和 debug 环境产生区别
            resValue "string", "app_name0", "LearningInCode0"
            manifestPlaceholders = [app_name: "LearningInCode"]
        }
    }

    sourceSets {
        main {
            jniLibs.srcDirs = ['src/main/jniLibs']                                  // 指定 jni 的 so 文件的目录
        }
    }

    productFlavors {                                                                // 配置多种打包风格 (如多渠道, 多配置等)

        flavorDimensions 'default'                                                  // gradle 3.0
                                                                                    // 解决 : All flavors must now belong to a named flavor dimension.

        xiaomi {
            buildConfigField 'String', 'CHANNEL', '"Xiaomi"'                        // 配置小米商店的渠道名称
        }

        demo {
            buildConfigField 'String', 'HOST', '"http://www.xxx.com"'               // 配置 Demo 环境下的 HOST
        }
    }

    android.applicationVariants.all { variant ->

        variant.outputs.each { output ->
                                                                                    // 控制打包 apk 的文件名
            def buildTypeName = buildType.name                                      // buildTypes : release & debug 等
            def versionName = variant.versionName
            def flavorName = variant.flavorName
            def date = new Date().format("yyyy-MM-dd")
            output.outputFile = new File(output.outputFile.parent, "xxx.apk")       // gradle 2.x
            if (output.outputFile != null && output.outputFile.name.endsWith('.apk')) // gradle 3.x
                output.outputFileName = "xxx.apk"
        }
    }
}

repositories {
    flatDir {
        dirs 'libs'                                                                 // 导入 libs 中的 jar包和 aar包
        dirs '../xxx/libs'                                                          // 如果依赖的 Module 中存在 aar包, 需要在这里配置具体的 aar 路径, 否则会找不到
    }
    mavenCentral()
}

                                                                                    // ## 依赖传递 & 依赖排除 & 使用强制版本 的全局配置 ##
configurations.all {

    transitive = false                                                              // transitive = false 时, 表示全局关闭依赖传递, 即不再依赖该 Module 中依赖库中的依赖 (一般很少用)
    compile.exclude module: 'code'                                                  // 编译期排除依赖传递: 指定模块
    all*.exclude group: 'com.android.support', module: 'appcompat-v7'               // 排除依赖传递: 指定库

    resolutionStrategy {                                                            // 使用强制版本: 冲突时优先使用该版本进行解决
        force 'org.hamcrest:hamcrest-core:1.3'
    }
}

                                                                                    // ## dependencies ## 依赖配置
dependencies {

    implementation fileTree(include: ['*.jar'], dir: 'libs')                        // 遍历引用 libs 下面的 jar 包

    implementation 'com.android.support:appcompat-v7:26.1.0'
    testImplementation 'junit:junit:4.12'                                           // 单元测试 ( test 环境下使用)

    implementation('com.github.SenhLinsh:Utils-Everywhere:2.0.0') {
        transitive = true                                                           // 依赖传递: 是否传递 Utils-Everywhere 中的依赖库, 默认为 true; false 为不依赖 Utils-Everywhere 中的依赖库
        exclude group: 'org.unwanted', module: 'iAmBuggy'                           // 依赖排除: 不传递 Utils-Everywhere 中指定的依赖
        exclude module: 'share'                                                     // 依赖排除: 不传递 Utils-Everywhere 中指定的依赖
        force = true                                                                // 使用强制版本: 冲突时优先使用该版本进行解决
    }

    implementation 'com.github.SenhLinsh:Utils-Everywhere:2.0.0@jar'                       // 也可以采用添加 @jar 的方式忽略该依赖的所有传递性依赖

    implementation 'com.github.SenhLinsh:Utils-Everywhere:+'                        // "+" 号表示使用动态版本: 可以让工程使用依赖最新版本
                                                                                    // 不推荐使用, 它会降低你系统构建的速度同时提高构建失败的风险
                                                                                    // 因为Gradle不得不每次检查远程仓库是否存在最新版本，同时新版本也可能带来无法预知的兼容性问题

    implementation project(':code')                                                 // 依赖 Module
}


//  ##### compile 和 implementation & api 的关系
// AS 3.0 之后, compile 被标注为过时, 可用 api 指令代替. 同时尽量优先使用 implementation, 因为它会使编译速度有所增快
// implementation 的不同在于它该依赖库所依赖的依赖库不再对外部公开, 即无法直接使用 LshUtils 里面的依赖库的类, 如: Gson, OkHttp 等
// 目前使用的建议是: 优先使用 implementation, 如果有错，则使用 api 指令

// ##### 依赖冲突 的解决:
// 1. 依赖冲突时，如果有两个依赖引用了相同jar包的不同版本时，默认情况下 gradle 会采用最新版本的 jar包
// 2. 可通过排除选项来排除


*/