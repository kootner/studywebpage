# 모이소
![image](https://user-images.githubusercontent.com/79959576/173993336-ea3ea555-ca65-483a-a44a-d54246540ba4.png)

---
개발 스터디를 하고 싶은데 어디서 찾을까?

모집 공고를 내고 댓글로 신청자를 찾아보세요

## 제작기간 
22.06.10(금) ~ 22.06.16(목)


## 팀원 및 역할 분담
```
강현구
Role 상세페이지 조회, 수정, 삭제 기능 구현 
```
```
김정훈
Role 상세페이지 작성 기능 구현 , 코드 리팩토링 작업
```
```
박세열
Role 로그인 및 회원가입 기능 구현, 댓글 작성, 수정, 삭제 기능 구현, 소셜 로그인 구현
```

## 기술스택

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">


## 기능 요약 설명
* 회원가입/로그인을 통한 계정 정보 저장 및 관리
* 로그인 권한이 없더라도 메인 페이지 및 스터디 상세페이지 열람 가능
* 메인페이지에서 api로 간략한 설명과 사진을 요청하고 이것을 보내줌
* 상세페이지에서는 댓글 리스트를 보내주어 타 유저의 스터디 모집에 대한 반응 가능

## 데이터베이스 구조

![image](https://user-images.githubusercontent.com/79959576/173970297-05580a99-8b55-4441-91b6-5fb97cb830b0.png)

## API설계 
https://sky-song-209.notion.site/df5aae052be245d4a2c02c2ee55cc96d?v=057c39ce90374654a0a6c2f5792f6b52

## 프로젝트 화면
<로그인 페이지>
![](https://user-images.githubusercontent.com/105117965/174049537-7b509dc0-bed4-4bdf-b2fc-480dd2092dc5.png)

<회원가입 페이지>
![](https://user-images.githubusercontent.com/105117965/174049890-834a0af3-dd5d-4147-8224-1a85fc7d2ee5.png)

<메인 페이지>
![](https://user-images.githubusercontent.com/105117965/174049987-25178225-0e11-4eda-a8c9-1efc6e609e41.png)

<작성 페이지>
![](https://user-images.githubusercontent.com/105117965/174050090-eeb9fd26-7748-413f-b199-fa1548f2e675.png)

<상세 페이지>
![](https://user-images.githubusercontent.com/105117965/174050150-8917163d-359d-44bc-979b-0bd424ada5a8.png)


## 프로젝트 후기

강현구   
기능 구현 이외에도 이것저것 신경 써야 하는 부분이 많았던거 같았다 그리고 프론트랑 연결하는 부분에서 변수가 워낙 다양하다보니 에러를 찾고 수정하는대 많은 시간이 걸렸던거 같다 고치고 나면 정말 오타 하나나 코드 한줄차이 라는것이 약간 허탈한 경우도 있었다 그래도 구현하고자했던 메인 기능들은 다 구현 해서 다행이라고 생각한다

김정훈[@junghoon-kim96](https://github.com/junghoon-kim96)        
주특기 스프링을 활용하여 첫 프로젝트를 진행하는 과정은 앞선 3주 동안 배운 내용을 복습하고 좀 더 내것으로 만들며, 자신감을 얻는 시간이였다. 또한 프론트와 협업 도중 발생하는 트러블 해결 과정에서 서버와 클라이언트 간에 데이터 흐름을 좀더 정확히 파악하는 능력을 길렀고, 서버 문제를 해결하는 과정에선 수많은 구글링을 통해서 추가적인 스프링 공부가 되어졌다. 이번 프로젝트를 발판으로 삼아 한단계 발전된 모습으로 다음 프로젝트에 임하고 싶다.

박세열[@WE-DA-pluggg](https://github.com/WE-DA-pluggg)
기능구현 뿐만 아니라 프론트와의 협업으로 인한 시간 차이, 현실적으로 구현이 가능한 기능과 추가 기능에 대한 수요를 조절하는 능력을 기르는 주간이었다. CORS 수정이 이번 주차의 핵심 사안 중 하나였는데 단순히 ARC나 postman을 통해 스프링 서버 내부에서 localhost8080을 통한 api 호출과 실질적으로 프론트에서 보내는 api호출은 상당한 차이를 보였다. 또한 api 명세서를 통해 데이터 이름과 타입 등에 프론트에서 올바르게 받을 수 있도록 일치 시키는 것 또한 중요한 것을 인지했다. 무엇보다도 프론트와 백 간의 의견 조율, 데이터 가공 등의 협업의 핵심 가치들을 알아가는 한 주였다. 



## Trouble Shooting

1. 로그인시 토큰이 Header에는 정상적으로 들어가나 프론트에서 response로 데이터가 안가져와지는 문제 발생   
 -> 프론트 개발자 도구 창에서 302 리다이렉트 에러 발생 확인
 -> CORS에서 addExposedHeader 코드 추가하여 진행    
 -> 이슈 해결 안됨 -> 추가확인결과 addExposedHeader를 추가하는건 맞았으나 값에 Authorization에 ti를 it로 입력된 오타 확인    
 -> 수정 후 정상작동    
   
2. 스터디 작성 저장이 정상적으로 안되고 에러발생    
-> 토큰 문제인지 확인결과 문제없음    
-> ARC 확인결과 정상작동    
-> 데이터 전달 부분 확인결과 user 데이터가 API대로 commentlist에서 username, userNickname으로 전달하는것이 아닌 commentlist에 user에서 user데이터 들이 전달되는 부분 확인     
-> API 대로 수정하였으나 정상진행 안됨   
-> 알고보니 createdAt 데이터 또한 commentlist에 createdAt에 날짜 시간 값들이 하나하나씩 들어있는부분 확인 -> createdAt 내용을 String 으로 변경하여 전달    
-> 정상작동   

2. 소셜 로그인 구현 시 토큰 발급 처리 문제
-> 소셜 로그인은 외부 api로 기존에 사용하는 web security framework에서 jwt를 발급하는 형태가 아님
-> 서버 내에서 소셜로그인 서비스를 따로 만들어 서비스에서 토큰 provider를 호출하여 자체적으로 발급
-> 이후 서버에서 토큰 발급 확인 후 헤더에 토큰을 발급하고 프론트로 넘김
-> 프론트에서 확인
