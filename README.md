# Minecraft Launcher for Android

A pixel-perfect Minecraft Launcher for Android with Material You design, built using Jetpack Compose and following Clean Architecture principles.

## 🎯 Features

- **Pixel-perfect design** matching the official Minecraft Launcher
- **Material You (Material 3)** design system
- **Microsoft Account authentication** using MSAL
- **Offline account management**
- **Version selection and management** (Java/Bedrock)
- **Modern Android development** with Kotlin and Jetpack Compose
- **Clean Architecture** with MVVM pattern
- **Dark/Light theme support**

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 34 (API 34)
- Minimum Android version: 8.0 (API 26)
- Java 17 or later

### Building the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/Minecraft-Launcher-For-Android.git
   cd Minecraft-Launcher-For-Android
   ```

2. **Open in Android Studio:**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it

3. **Build the project:**
   ```bash
   # Using Gradle wrapper (recommended)
   ./gradlew build
   
   # Or using Android Studio
   # Build → Make Project (Ctrl+F9 / Cmd+F9)
   ```

4. **Run on device/emulator:**
   ```bash
   ./gradlew installDebug
   ```

### Using the Gradle Wrapper

The project includes a Gradle wrapper, so you don't need to install Gradle separately:

```bash
# List all available tasks
./gradlew tasks

# Build the project
./gradlew build

# Clean build
./gradlew clean

# Run tests
./gradlew test

# Generate debug APK
./gradlew assembleDebug

# Generate release APK
./gradlew assembleRelease
```

## 🏗️ Project Structure

```
app/
├── src/main/
│   ├── java/com/minecraft/launcher/
│   │   ├── data/           # Data layer (repositories, data sources)
│   │   ├── domain/         # Domain layer (entities, use cases)
│   │   ├── presentation/   # Presentation layer (UI, ViewModels)
│   │   └── di/            # Dependency injection
│   ├── res/               # Resources (layouts, strings, colors)
│   └── AndroidManifest.xml
├── build.gradle.kts       # App-level build configuration
└── proguard-rules.pro    # ProGuard rules

build.gradle.kts           # Project-level build configuration
settings.gradle.kts        # Project settings
gradle.properties          # Gradle properties
gradlew                   # Gradle wrapper script (Unix/Linux)
gradlew.bat               # Gradle wrapper script (Windows)
```

## 🎨 Design System

The app uses the official Minecraft color palette and Material You design principles:

- **Primary colors**: Minecraft green (#7CB342)
- **Secondary colors**: Minecraft blue (#42A5F5)
- **Accent colors**: Minecraft orange (#FF9800)
- **Background**: Dark theme with Minecraft aesthetics
- **Typography**: Material 3 typography scale

## 🔧 Dependencies

### Core Libraries
- **Jetpack Compose**: Modern UI toolkit
- **Material 3**: Material You design system
- **Navigation Compose**: Navigation between screens
- **ViewModel + LiveData**: State management
- **Hilt**: Dependency injection

### Authentication & Networking
- **MSAL**: Microsoft Authentication Library
- **Retrofit**: HTTP client for API calls
- **OkHttp**: HTTP client
- **Moshi/Gson**: JSON parsing

### Utilities
- **Coil**: Image loading
- **Accompanist**: System UI controller, navigation animations
- **AndroidX Security Crypto**: Encrypted shared preferences

## 📱 Screens

1. **Home Screen**: Main launcher interface with version cards
2. **Microsoft Auth**: Microsoft account login
3. **Offline Account**: Create offline Minecraft account
4. **Settings**: App configuration and preferences
5. **Download/Launch**: Game version management

## 🚀 CI/CD

The project includes GitHub Actions workflows for:

- **Build**: Debug APK generation
- **Release**: Release APK and AAB bundle generation
- **Testing**: Unit tests and code quality checks
- **Quality**: Dependency analysis and security checks

### Workflow Files
- `.github/workflows/build.yml` - Debug build
- `.github/workflows/release.yml` - Release build
- `.github/workflows/test.yml` - Testing and quality
- `.github/workflows/quality.yml` - Code quality analysis

## 🔐 Configuration

### Required Secrets
- `ANDROID_KEYSTORE_BASE64`: Base64 encoded keystore for signing
- `KEYSTORE_PASSWORD`: Keystore password
- `KEY_ALIAS`: Key alias
- `KEY_PASSWORD`: Key password

### Environment Variables
- `ANDROID_SDK_ROOT`: Android SDK path
- `JAVA_HOME`: Java installation path

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📞 Support

If you encounter any issues or have questions:

1. Check the [Issues](https://github.com/yourusername/Minecraft-Launcher-For-Android/issues) page
2. Create a new issue with detailed information
3. Include device information, Android version, and error logs

## 🎉 Acknowledgments

- Minecraft and Mojang for the original launcher design
- Google for Material Design and Android development tools
- The open-source community for the amazing libraries used in this project

---

**Note**: This is a fan project and is not affiliated with Mojang or Microsoft. Minecraft is a registered trademark of Mojang AB.