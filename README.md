# Calculator App 🧮

A simple, clean calculator app built with **Kotlin + Jetpack Compose + Material3**.

## Features
- Basic arithmetic: +, −, ×, ÷
- Decimal support
- Clear (C) button
- Error handling (division by zero)
- Dark theme by default
- Modern Material3 UI

## Screenshots
*Add screenshots here after build*

## Build APK via GitHub Actions

### Automatic (Recommended)
1. Push to `main`/`master` branch
2. Go to **Actions** tab
3. Click "Build APK" workflow
4. Download `app-debug.apk` from **Artifacts**

### Manual Trigger
1. Go to **Actions** → **Build APK**
2. Click **Run workflow** → **Run workflow**
3. Wait for build (~3-5 min)
4. Download APK from artifacts

## Local Build
```bash
# Requires: JDK 17, Android SDK (API 34)
./gradlew assembleDebug
# APK at: app/build/outputs/apk/debug/app-debug.apk
```

## Tech Stack
| Component | Version |
|-----------|---------|
| Kotlin | 2.0.0 |
| AGP | 8.5.0 |
| Compose | 2024.08.00 |
| Compile SDK | 34 |
| Min SDK | 24 |
| Target SDK | 34 |

## Project Structure
```
calculator-app/
├── .github/workflows/build.yml    # CI pipeline
├── app/
│   ├── src/main/
│   │   ├── java/com/example/calculator/
│   │   │   ├── MainActivity.kt      # UI + Compose
│   │   │   ├── CalculatorViewModel.kt
│   │   │   └── CalculatorTheme.kt
│   │   ├── res/
│   │   │   ├── values/strings.xml
│   │   │   └── values/themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## License
MIT