# GitHub Actions для Minecraft Launcher

Этот репозиторий содержит набор GitHub Actions workflows для автоматизации сборки, тестирования и проверки качества кода Minecraft Launcher для Android.

## 🚀 Доступные Workflows

### 1. **Build Minecraft Launcher APK** (`build.yml`)
**Триггеры:**
- Push в ветки `main` или `master`
- Ручной запуск (workflow_dispatch)

**Что делает:**
- Устанавливает JDK 17
- Настраивает Android SDK
- Собирает debug APK
- Загружает артефакт
- Проверяет результат сборки

**Результат:** Debug APK файл доступен для скачивания

### 2. **Build Release APK** (`release.yml`)
**Триггеры:**
- Создание релиза (release published)
- Ручной запуск (workflow_dispatch)

**Что делает:**
- Устанавливает JDK 17
- Настраивает Android SDK для API 34
- Собирает release APK и AAB bundle
- Загружает оба артефакта
- Проверяет результат сборки

**Результат:** Release APK и AAB bundle файлы

### 3. **Test Minecraft Launcher** (`test.yml`)
**Триггеры:**
- Push в ветки `main` или `master`
- Pull Request в ветки `main` или `master`
- Ручной запуск (workflow_dispatch)

**Что делает:**
- Запускает unit тесты
- Выполняет lint проверки
- Проверяет стиль кода (ktlint)
- Загружает результаты тестов

**Результат:** Отчеты о тестировании и качестве кода

### 4. **Code Quality Check** (`quality.yml`)
**Триггеры:**
- Push в ветки `main` или `master`
- Pull Request в ветки `main` или `master`
- Ручной запуск (workflow_dispatch)

**Что делает:**
- Проверяет зависимости
- Валидирует структуру проекта
- Анализирует уязвимости
- Генерирует отчеты о сборке

**Результат:** Отчеты о качестве кода и зависимостях

## 🛠 Технические детали

### Android SDK Setup
Все workflows автоматически настраивают Android SDK:
```bash
# Скачивание Command Line Tools
wget -q https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip

# Установка компонентов
sdkmanager "platforms;android-33"
sdkmanager "build-tools;33.0.0"
sdkmanager "platform-tools"
sdkmanager "cmdline-tools;latest"
```

### Переменные окружения
- `ANDROID_HOME` - путь к Android SDK
- `JAVA_HOME` - путь к JDK 17
- `GITHUB_PATH` - для добавления инструментов в PATH

### Gradle команды
```bash
# Сборка debug APK
./gradlew assembleDebug --no-daemon --stacktrace

# Сборка release APK
./gradlew assembleRelease --no-daemon --stacktrace

# Сборка AAB bundle
./gradlew bundleRelease --no-daemon --stacktrace

# Запуск тестов
./gradlew test --no-daemon

# Lint проверки
./gradlew lintDebug --no-daemon
```

## 📱 Результаты сборки

### Debug Build
- **Путь:** `app/build/outputs/apk/debug/`
- **Файл:** `app-debug.apk`
- **Размер:** ~15-25 MB
- **Хранение:** 7 дней

### Release Build
- **APK путь:** `app/build/outputs/apk/release/`
- **Bundle путь:** `app/build/outputs/bundle/release/`
- **Файлы:** `app-release.apk` и `app-release.aab`
- **Хранение:** 30 дней

## 🔧 Настройка и использование

### 1. **Автоматический запуск**
Workflows запускаются автоматически при:
- Push в основную ветку
- Создание Pull Request
- Создание релиза

### 2. **Ручной запуск**
1. Перейдите в раздел "Actions" в GitHub
2. Выберите нужный workflow
3. Нажмите "Run workflow"
4. Выберите ветку и нажмите "Run workflow"

### 3. **Просмотр результатов**
1. В разделе "Actions" выберите workflow
2. Нажмите на выполненный run
3. Скачайте артефакты или просмотрите логи

## 📊 Мониторинг и отчеты

### Успешная сборка
- ✅ APK файл создан
- ✅ Артефакт загружен
- ✅ Размер файла проверен
- ✅ Логи доступны

### Ошибки сборки
- ❌ Детальные логи ошибок
- ❌ Stack trace для отладки
- ❌ Информация о зависимостях
- ❌ Рекомендации по исправлению

## 🚨 Устранение проблем

### Частые ошибки

#### 1. **SDK не найден**
```bash
# Проверьте переменную ANDROID_HOME
echo $ANDROID_HOME

# Переустановите SDK
rm -rf $ANDROID_HOME
# Запустите workflow заново
```

#### 2. **Лицензии не приняты**
```bash
# Принудительно примите лицензии
yes | sdkmanager --licenses
```

#### 3. **Недостаточно памяти**
```bash
# Увеличьте память для Gradle
export GRADLE_OPTS="-Xmx4g -XX:MaxPermSize=2048m"
```

#### 4. **Проблемы с зависимостями**
```bash
# Очистите кэш Gradle
./gradlew clean
./gradlew --refresh-dependencies
```

## 🔒 Безопасность

### Переменные окружения
- Все секреты хранятся в GitHub Secrets
- Переменные не логируются
- Доступ только для авторизованных пользователей

### Проверки безопасности
- Анализ зависимостей на уязвимости
- Проверка подписей APK
- Валидация структуры проекта

## 📈 Оптимизация

### Кэширование
- Gradle кэш между runs
- Android SDK кэш
- Maven repository кэш

### Параллелизация
- Независимые jobs
- Оптимизированные steps
- Минимальное время выполнения

## 🤝 Вклад в проект

### Добавление новых workflows
1. Создайте файл `.github/workflows/your-workflow.yml`
2. Следуйте существующему формату
3. Добавьте документацию
4. Протестируйте локально

### Улучшение существующих
1. Создайте Issue с описанием
2. Fork репозитория
3. Внесите изменения
4. Создайте Pull Request

## 📞 Поддержка

Если у вас возникли проблемы с workflows:
1. Проверьте логи выполнения
2. Создайте Issue с детальным описанием
3. Приложите скриншоты ошибок
4. Укажите версию Android и Gradle

---

**Примечание:** Эти workflows оптимизированы для Minecraft Launcher и могут потребовать адаптации для других Android проектов.