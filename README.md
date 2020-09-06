# orderFree-owner
### 동국대학교 2020밸류업 참여 프로젝트
### 오더프리 점주용 애플리케이션
## 목차
- [프로젝트 주제](#프로젝트-주제)
- [서비스 구성도](#서비스-구성도)
- [점주용 애플리케이션 사용 언어](#점주용-애플리케이션-사용-언어)
- [점주용 애플리케이션 디자인](#점주용-애플리케이션-디자인)
- [REST API 문서](#서버와의-통신을-위한-REST-API-문서)
- [안드로이드 코드구조](#안드로이드-코드구조)
- [점주용 애플리케이션 시연 영상](#애플리케이션-시연-영상)

## 프로젝트 주제
시각장애인분들의 키오스크 사용에 있어서의 불편함을 해결하고 접근성을 개선하기 위한 애플리케이션 기반 서비스 <br>
![subject_img](https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/OrderFreeSubject.png)<br>

## 서비스 구성도
서비스 구성도는 아래의 사진과 같다. <br>
![service_Map](https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/OrderFreeServiceMap.png)<br>
서비스 구성도를 보다시피 **점주용 애플리케이션**과 **유저용 애플리케이션** 그리고 **서버**가 존재한다. <br>
점주용 애플리케이션에는 점주(사용자)정보들을 입력받고, 가게 등록 및 가게이름 등 해당 가게를 등록한다. <br>
또한 가게의 메뉴를 카테고리에 맞게 등록, 수정, 삭제할 수 있으며 사용자들로부터 주문을 받아 확인할 수 있고 <br>
해당 주문의 음식이 완료 되었다면 사용자에게 푸시알림을 보낼 수 있다. <br>

## 점주용 애플리케이션 사용 언어
점주용 애플리케이션은 안드로이드 스튜디오에서 Java 언어로 작성되었다. 사용된 API는 다음과 같다. <br>
이미지를 서버로 업로드 하기 위해서 AWS의 S3 서비스를 사용하였다. <br>
사용자 애플리케이션으로 push notification을 보내기 위해서 FCM을 사용하였다. <br>
가게의 주소를 입력받기 위해서 카카오 도로명 주소 API를 사용하였다. <br>
아래의 링크로 들어가면 각각의 API를 사용하는 방법에 대해서 정리해 두었다. <br>
[FCM을 사용하여 푸시알림 보내기 - 1](https://blog.naver.com/jryoun1/222058760991) <br>
[FCM을 사용하여 푸시알림 보내기 - 2](https://blog.naver.com/jryoun1/222058831072) <br>
[카카오 도로명주소 API 사용하기](https://jryoun1.blog.me/222061503618) <br>

## 점주용 애플리케이션 디자인
<img src="https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/ownerApp_Design.png" width="500"> <br>

## 서버와의 통신을 위한 REST API 문서
#### 점주용 애플리케이션 REST API
![ownerAppRestApi](https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/ownerappRestApi.png) <br>

## 안드로이드 코드구조
```
UI
|- login
    |- activity
    |- data
|- mainview
    |- activity
    |- data
    |- menu
    |- order
Util
|- CategoryConverter.java
network
|- RetrofitClient.java
|- ServuceApi.java
MyFireBaseMessagingService.java
```
안드로이드 코드 구조는 간략하게 보면 UI, Util, network 폴더와 MyApp.java, MyFireBaseMessagingService.java 파일로 구성되어있다. <br>
먼저 **MyApp.java는** S3에서 올렸던 이미지를 받아오기 위해서 glide를 사용하는 과정에서 필요한 클래스이며 <br>
**MyFirebaseMessagingService.java는** FCM서비스를 이용하여 푸시알림을 받기 위해 작성된 클래스이다. <br>
서버와의 통신은 Retrofit2를 사용하였으며, 이를 위한 코드는 **network 폴더** 에 RetrofitClient와 ServiceApi로 구성되어있다. <br>
**Util 폴더** 는 메뉴카테고리를 위한 categoryConverter이며, 점주용 애플리케이션의 모든 기능과 관련된 코드는 UI 폴더 안에 있다.<br>
**UI 폴더** 는 login, mainview 폴더로 구성되어있으며 login에는 회원가입, 비밀번호찾기, 이메일찾기, 로그인과 같은 기본 기능이 구현되어있다. <br>
**mainview 폴더** 는 애플리케이션의 주요 기능인 메뉴등록, 메뉴수정, 카테고리설정, 메뉴목록보기, 판매 현황보기, 개인정보수정 등과 같은 기능들이 구현되어있다. <br>

점주용 애플리케이션은 3명에서 구현하였다. <br>
[연정민](https://github.com/jryoun1) - 회원가입, 로그인(+ 자동로그인), 로그아웃, 비밀번호찾기, 이메일찾기, 사용자 애플리케이션으로 알림 보내기, 도로명 주소 검색 API 적용 <br>
[김현도](https://github.com/kk090303) - 개인정보수정, 회원탈퇴, 판매 현황보기 <br>
[최고운](https://github.com/gowoon-choi) - 메뉴등록, 메뉴수정, 카테고리 별 메뉴보기, 주문 목록 확인, S3를 사용하여 이미지 업로드 및 불러오기 <br>

## 애플리케이션 시연 영상
아래의 영상에서 왼쪽에 있는 화면이 점주용 애플리케이션이며, 오른쪽은 사용자 애플리케이션이다. <br>
사용자 애플리케이션으로부터 주문이 들어왔을 때 점주용 애플리케이션에서는 알림을 통해 주문이 들어온 것을 확인하고 <br>
주문이 준비완료 되었을 때 사용자 애플리케이션으로 알림을 보내 준비완료를 알리는 것을 짧게 만든 영상이다. <br>
![ownerAppGif](https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/ownerAppGIF.gif) <br>

-----
아래의 링크를 통해 오더프리 서버와 유저용 애플리케이션의 코드 및 정보가 있는 페이지로 갈 수 있다. <br>
[오더프리 서버](https://github.com/jryoun1/orderFree-server/blob/master/README.md) <br>
[오더프리 유저용 애플리케이션]() <br>

