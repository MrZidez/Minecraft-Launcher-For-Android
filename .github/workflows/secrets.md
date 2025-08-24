# GitHub Secrets для Minecraft Launcher Workflows

Этот файл описывает необходимые секреты, которые нужно настроить в GitHub для корректной работы workflows.

## 🔐 Необходимые секреты

### 1. **ANDROID_SIGNING_KEYSTORE**
**Описание:** Keystore файл для подписи release APK
**Тип:** File
**Формат:** Base64 encoded keystore
**Использование:** Подпись релизных версий

**Как создать:**
```bash
# Создание keystore
keytool -genkey -v -keystore minecraft-launcher.keystore \
  -alias minecraft-launcher \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000

# Конвертация в Base64
base64 -i minecraft-launcher.keystore
```

### 2. **ANDROID_SIGNING_KEY_ALIAS**
**Описание:** Алиас ключа в keystore
**Тип:** Secret
**Значение:** minecraft-launcher
**Использование:** Идентификация ключа для подписи

### 3. **ANDROID_SIGNING_KEY_PASSWORD**
**Описание:** Пароль для keystore
**Тип:** Secret
**Формат:** Текстовый пароль
**Использование:** Доступ к keystore

### 4. **ANDROID_SIGNING_STORE_PASSWORD**
**Описание:** Пароль для store
**Тип:** Secret
**Формат:** Текстовый пароль
**Использование:** Доступ к store

### 5. **MSAL_CLIENT_ID**
**Описание:** Client ID для Microsoft Authentication Library
**Тип:** Secret
**Формат:** UUID
**Использование:** MSAL аутентификация

**Как получить:**
1. Зарегистрируйте приложение в [Azure Portal](https://portal.azure.com)
2. Перейдите в "App registrations"
3. Создайте новое приложение
4. Скопируйте Application (client) ID

### 6. **MSAL_CLIENT_SECRET**
**Описание:** Client Secret для MSAL
**Тип:** Secret
**Формат:** Секретный ключ
**Использование:** MSAL аутентификация

**Как получить:**
1. В Azure Portal перейдите в "Certificates & secrets"
2. Создайте новый client secret
3. Скопируйте значение (оно показывается только один раз)

### 7. **FIREBASE_GOOGLE_SERVICES_JSON**
**Описание:** Google Services JSON файл для Firebase
**Тип:** File
**Формат:** JSON файл
**Использование:** Firebase интеграция

**Как получить:**
1. Перейдите в [Firebase Console](https://console.firebase.google.com)
2. Создайте проект или выберите существующий
3. Добавьте Android приложение
4. Скачайте google-services.json

### 8. **SONAR_TOKEN**
**Описание:** Токен для SonarCloud анализа
**Тип:** Secret
**Формат:** Токен
**Использование:** Анализ качества кода

**Как получить:**
1. Зарегистрируйтесь на [SonarCloud](https://sonarcloud.io)
2. Перейдите в Account > Security
3. Создайте новый токен

### 9. **SLACK_WEBHOOK_URL**
**Описание:** Webhook URL для Slack уведомлений
**Тип:** Secret
**Формат:** HTTPS URL
**Использование:** Уведомления о сборке

**Как создать:**
1. В Slack создайте новый app
2. Включите Incoming Webhooks
3. Создайте webhook для нужного канала
4. Скопируйте webhook URL

### 10. **DISCORD_WEBHOOK_URL**
**Описание:** Webhook URL для Discord уведомлений
**Тип:** Secret
**Формат:** HTTPS URL
**Использование:** Уведомления о сборке

**Как создать:**
1. В Discord канале перейдите в Settings > Integrations
2. Создайте новый webhook
3. Скопируйте webhook URL

## ⚙️ Настройка секретов

### 1. **В GitHub репозитории:**
1. Перейдите в Settings > Secrets and variables > Actions
2. Нажмите "New repository secret"
3. Введите имя и значение
4. Нажмите "Add secret"

### 2. **В Organization (если применимо):**
1. Перейдите в Organization Settings > Secrets and variables > Actions
2. Создайте organization-level secrets
3. Выберите репозитории для доступа

### 3. **В Environment (для production):**
1. Создайте Environment в репозитории
2. Добавьте environment-specific secrets
3. Настройте protection rules

## 🔒 Безопасность

### **Рекомендации:**
- Используйте уникальные пароли для каждого проекта
- Регулярно ротируйте секреты
- Ограничьте доступ к секретам
- Логируйте использование секретов
- Используйте environment protection rules

### **Запрещено:**
- Коммитить секреты в код
- Использовать одинаковые секреты в разных проектах
- Делиться секретами в публичных местах
- Хранить секреты в незашифрованном виде

## 📋 Чек-лист настройки

### **Обязательные секреты:**
- [ ] `ANDROID_SIGNING_KEYSTORE`
- [ ] `ANDROID_SIGNING_KEY_ALIAS`
- [ ] `ANDROID_SIGNING_KEY_PASSWORD`
- [ ] `ANDROID_SIGNING_STORE_PASSWORD`

### **Рекомендуемые секреты:**
- [ ] `MSAL_CLIENT_ID`
- [ ] `MSAL_CLIENT_SECRET`
- [ ] `FIREBASE_GOOGLE_SERVICES_JSON`
- [ ] `SONAR_TOKEN`

### **Опциональные секреты:**
- [ ] `SLACK_WEBHOOK_URL`
- [ ] `DISCORD_WEBHOOK_URL`

## 🚨 Устранение проблем

### **Секрет не найден:**
```yaml
# В workflow добавьте проверку
- name: Check Secrets
  run: |
    if [ -z "${{ secrets.REQUIRED_SECRET }}" ]; then
      echo "Error: Required secret not found"
      exit 1
    fi
```

### **Секрет не работает:**
1. Проверьте правильность имени
2. Убедитесь, что секрет добавлен в нужный scope
3. Проверьте права доступа
4. Пересоздайте секрет при необходимости

### **Секрет устарел:**
1. Создайте новый секрет
2. Обновите workflows
3. Удалите старый секрет
4. Протестируйте новую конфигурацию

## 📞 Поддержка

Если у вас возникли проблемы с секретами:
1. Проверьте логи workflows
2. Убедитесь в правильности настройки
3. Создайте Issue с детальным описанием
4. Не включайте секреты в публичные сообщения

---

**Важно:** Храните секреты в безопасном месте и никогда не коммитьте их в репозиторий!