---
aliases:
---
## 首先导入 Camerax库

```
plugins {  
    alias(libs.plugins.android.application)  
    alias(libs.plugins.kotlin.compose)  
}  
  
android {  
    namespace = "com.android.example.cameraxapp"  
    // 修复 1：正确的 compileSdk 写法  
    compileSdk = 36  
  
    defaultConfig {  
        applicationId = "com.android.example.cameraxapp"  
        minSdk = 24  
        // 修复 2：标准 targetSdk        targetSdk = 36  
        versionCode = 1  
        versionName = "1.0"  
  
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"  
    }  
  
    buildTypes {  
        release {  
            isMinifyEnabled = false  
            proguardFiles(  
                getDefaultProguardFile("proguard-android-optimize.txt"),  
                "proguard-rules.pro"  
            )  
        }  
    }    compileOptions {  
        sourceCompatibility = JavaVersion.VERSION_11  
        targetCompatibility = JavaVersion.VERSION_11  
    }  
    buildFeatures {  
        compose = true  
        viewBinding = true  
    }  
}  
  
dependencies {  
    implementation(libs.androidx.core.ktx)  
    implementation(libs.androidx.lifecycle.runtime.ktx)  
    implementation(libs.androidx.activity.compose)  
    implementation(platform(libs.androidx.compose.bom))  
    implementation(libs.androidx.compose.ui)  
    implementation(libs.androidx.compose.ui.graphics)  
    implementation(libs.androidx.compose.ui.tooling.preview)  
    implementation(libs.androidx.compose.material3)  
    testImplementation(libs.junit)  
    androidTestImplementation(libs.androidx.junit)  
    androidTestImplementation(libs.androidx.espresso.core)  
    androidTestImplementation(platform(libs.androidx.compose.bom))  
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)  
    debugImplementation(libs.androidx.compose.ui.tooling)  
    debugImplementation(libs.androidx.compose.ui.test.manifest)  
  
    // 修复 3：使用最新稳定版 CameraX（兼容 Compose）  
    val camerax_version = "1.4.0"  
    implementation("androidx.camera:camera-core:$camerax_version")  
    implementation("androidx.camera:camera-camera2:$camerax_version")  
    implementation("androidx.camera:camera-lifecycle:$camerax_version")  
    implementation("androidx.camera:camera-video:$camerax_version")  
    implementation("androidx.camera:camera-view:$camerax_version")  
    implementation("androidx.camera:camera-extensions:$camerax_version")  
}
```


![697](image/Pasted%20image%2020260518173509.png)



