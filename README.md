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
![ownerApp-Design](https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/ownerApp_Design.png)<br>

## 서버와의 통신을 위한 REST API 문서
#### 점주용 애플리케이션 REST API
![ownerAppRestApi](https://github.com/jryoun1/algorithm-study/blob/master/source/yeon/images/ownerappRestApi.png) <br>

## 안드로이드 코드구조
```
server.js 
package.json
package-lock.json
routes(폴더)
|- owner.js
|- main.js
|- user.js
|- usermain.js
html(폴더)
|- daum_address.html
```
## 애플리케이션 영상
아래의 영상에서 왼쪽에 

-----
아래의 링크는 점주용 애플리케이션과 유저용 애플리케이션의 코드 및 정보가 담겨있는 링크이다. <br>
[오더프리 서버](https://github.com/jryoun1/orderFree-server/blob/master/README.md) <br>
[오더프리 유저용 애플리케이션]() <br>

