# Deep-link-1

## Windows PowerShell
Being inside directory containing adb, you can test deep link using adb:
```powershell
./adb shell 'am start -d "http://10.0.2.2:8080/api/v1/task1?q=12\&p=7\&n=4"'
```

## Bash
Being inside directory containing adb, you can test deep link using adb:
```bash
./adb.exe shell 'am start -d "http://10.0.2.2:8080/api/v1/task1?q=12&p=7&n=4"'
```