# 목차

- Papago NMT 사용해보기
- 텔레그램 봇 만들기



# I. Papago NMT 사용해보기

1. 파이썬 설치

2. 사용할 라이브러리 설치

   ```bash
   > pip install requests
   > pip install python-decouple # 환경변수 설정 라이브러리
   ```

3.  Naver 개발자 센터에서 API 사용 준비 작업

4. 코딩

   .env

   ```properties
   NAVER_CLIENT_ID="***************************"
   NAVER_CLIENT_SECRET="***********"
   ```

   .gitignore

   ```
   .env
   ```

   papago.py

   ```python
   import requests
   import pprint
   from decouple import config
   
   #1. 환경변수 설정
   naver_client_id = config('NAVER_CLIENT_ID')
   naver_client_secret = config('NAVER_CLIENT_SECRET')
   
   #2. URL 설정
   url = "https://openapi.naver.com/v1/papago/n2mt"
   
   #3. 헤더 및 환경변수 설정
   headers = {
       'X-Naver-Client-Id' : naver_client_id,
       'X-Naver-Client-Secret' : naver_client_secret,
   }
   
   data = {
       'source' : 'ko',
       'target' : 'en',
       'text' : '댕댕이'
   }
   
   #4. 요청
   #url에 헤더와 데이터를 포함해서 POST 요청을 보내고
   #그 결과(json)을 파싱
   response = requests.post(url, headers=headers, data=data).json()
   pprint.pprint(response)
   print(response['message']['result']['translatedText'])
   ```



5. 결과 확인

   ```
   $ C:/Users/student/AppData/Local/Programs/Python/Python37/python.exe c:/chatbot/papago.py
   {'message': {'@service': 'naverservice.nmt.proxy',
                '@type': 'response',
                '@version': '1.0.0',
                'result': {'srcLangType': 'ko',
                           'tarLangType': 'en',
                           'translatedText': 'cIog'}}}
   cIog
   
   ```

<br>

# II. 텔레그램 봇 만들기

1. @botfather 에게 말해서 챗봇 만들기.

   ```
   Done! Congratulations on your new bot. You will find it at t.me/fromlyra0xff_bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.
   
   Use this token to access the HTTP API:
   **************************************
   Keep your token secure and store it safely, it can be used by anyone to control your bot.
   
   For a description of the Bot API, see this page: https://core.telegram.org/bots/api
   ```

2. Web browser에서 아래 get url 들이 작동하는지 확인

   /getMe

   ```
   https://api.telegram.org/bot******************/getMe
   ```

   /getUpdates

   ```
   https://api.telegram.org/bot******************/getUpdates
   ```

   ```json
   {
     "ok": true,
     "result": [
       {
         "update_id": 246240855,
         "message": {
           "message_id": 1,
           "from": {
             "id": 936561044,
             "is_bot": false,
             "first_name": "Jaehyun",
             "last_name": "Kim",
             "language_code": "ko"
           },
           "chat": {
             "id": 936561044,
             "first_name": "Jaehyun",
             "last_name": "Kim",
             "type": "private"
           },
           "date": 1567147408,
           "text": "/start",
           "entities": [
             {
               "offset": 0,
               "length": 6,
               "type": "bot_command"
             }
           ]
         }
       },
   ...
   ```

   ***id : 936561044*** 확인해 놓는다.

3. 



메시지 보내보기 (chat_id는 update에서 확인한 )

[https://api.telegram.org/bot939234540:AAF0wj3-H_eicf5YEuTu8THaXr5rUV1uELg/sendMessage?chat_id=936561044&text=%EC%95%88%EB%85%95](https://api.telegram.org/bot939234540:AAF0wj3-H_eicf5YEuTu8THaXr5rUV1uELg/sendMessage?chat_id=936561044&text=안녕)





# III. HEROKU 에 배포

heroku 가입

heroku cli 다운로드 -> 설치



Procfile

```

```



runtime.txt

```
python-3.7.3
```



```bash
# 현재 라이브러리를  저장
pip freeze > requirements.txt
# 다음에 일관 인스톨 하려면?
pip install -l requirements.txt

```



```bash
git add .
git commit -m 'heroku setting'
```



작업 디렉토리에서 정식 git bash 를 연다(vscode 에서 안 되는 듯?)

```bash
$ heroku login
heroku: Press any key to open up the browser to login or q to exit:
Opening browser to https://cli-auth.heroku.com/auth/browser/15c343c8-81e0-4547-aef3-028de9c53a5d
heroku: Waiting for login...
Logging in... done
Logged in as mr.laughaway@gmail.com
^C▒ϰ▒ ▒۾▒▒▒ ▒▒▒▒▒ðڽ▒▒ϱ▒ (Y/N)? y

$ heroku create fromlyra0xff-bot #fromlyra0xff-bot은 프로젝트명이다 
Creating fromlyra0xff-bot... done
https://fromlyra0xff-bot.herokuapp.com/ | https://git.heroku.com/fromlyra0xff-bot.git

$ git push heroku master
remote: Verifying deploy... done.
To https://git.heroku.com/fromlyra0xff-bot.git
 * [new branch]      master -> master

```



heroku site에서 환경설정



{project} > settings > Config Vars > Reveal ...

KEY : TELEGRAM_TOKEN

VALUE: 어쩌구어쩌구어쩌구어쩌구어쩌구키



overview > Configure Add-ons > **Heroku Scheduler** 설치

Heroku Scheduler > Add Job > **설정**



텔레그렘 확인

