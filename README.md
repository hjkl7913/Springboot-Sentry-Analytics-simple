# 스프링부트 구글 애널리틱스, Sentry.io

## 스프링부트 프로젝트 의존성

- Web
- DevTools
- Mustache

![blog](https://postfiles.pstatic.net/MjAyMDA4MTdfMjM2/MDAxNTk3NjM0NTE4OTgz.7Ab5XIuP2OVra5uY6QfpqeOMJb4xpt6d8ALmYVyC2tkg.1IIvhzdCwI6wG-Jd_DD_PWpTNnFJ4ghBQJi_DlAZg6Ig.PNG.hjkl7913/Screenshot_1441.png?type=w773)

![blog](https://postfiles.pstatic.net/MjAyMDA4MTdfMjg3/MDAxNTk3NjM0NDAyNTIz.N8BzQTI5pJFI1zng1BTA7ax5WROzwiG5oPmNar5JNbQg.usI7PTDcWmu7hP2_FJljh8l4HrV5vdCEJ7I-ANfQ2Qog.PNG.hjkl7913/Screenshot_1442.png?type=w773)

## 구글 애널리틱스

- 파이어베이스에 프로젝트 생성 (웹)
- 모든 웹페이지에 footer로 자바스크립트 집어넣기

```js
<script src="https://www.gstatic.com/firebasejs/7.18.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.18.0/firebase-analytics.js"></script>
<script>
  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "API키",
    authDomain: "app-922a9.firebaseapp.com",
    databaseURL: "https://app-922a9.firebaseio.com",
    projectId: "app-922a9",
    storageBucket: "app-922a9.appspot.com",
    messagingSenderId: "795568835808",
    appId: "1:795568835808:web:50bd07100848d6e82dd485",
    measurementId: "G-16FG2356RB"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  firebase.analytics();
</script>
</body>
</html>
```

## Sentry.io (로그 남기기)

- sentry.io 회원가입
- Project 생성(Java)
- Settings - Project - 내프로젝트이름 - Client Keys(DSN) - DSN 확인하기

- Sentry 설정

```java
package com.cos.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;

@Configuration
public class SentrySupport {

	public SentrySupport() {
		System.out.println("================================ SentrySupport init()");
		Sentry.init("DSN주소");
	}

    public void logSimpleMessage(String msg) {
        // This sends an event to Sentry.
        EventBuilder eventBuilder = new EventBuilder()
                        .withMessage(msg)
                        .withLevel(Event.Level.ERROR)
                        .withLogger(SentrySupport.class.getName());

        // Note that the *unbuilt* EventBuilder instance is passed in so that
        // EventBuilderHelpers are run to add extra information to your event.
        Sentry.capture(eventBuilder);
    }
}
```

- Sentry 실행하는 법

```java
    sentrySupport.logSimpleMessage("프로덕트 쪽 오류");
```
