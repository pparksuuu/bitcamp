<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam01</title>
</head>
<body>
<h1>JSTL(JSP Standard Tag Library)</h1>
<pre>
- 변수, 조건문, 반복문, URL다루기, 국제화 지원, 숫자 및 날짜 형식 변환, XML, DB 연동 등
    다양한 기능을 제공하는 JSP 확장 태그이다 
- EL과 함께 사용하면 JSP 페이지에서 자바 코드를 최소화 할 수 있다.

JSTL 사용
1) JSTL 라이브러리 추가
  - JSTL은 JSP에서 기본으로 제공하지 않는다.
  - JSTL 기능을 구현한 라이브러리를 추가해야 한다.
  - 보통 apache.org에서 제공하는 구현체를 사용한다.
2) 방법
  - mvnrepository.org에서 JSTL 라이브러리를 찾는다.
  - build.gradle 설정 파일에 라이브러리 정보를 추가한다.
  - "gradle.eclipse"를 실행하여 라이브러리를 가져온다.
  - 이클립스 프로젝트를 갱신한다.
  
</pre>
<%
pageContext.setAttribute("name", "홍길동");
pageContext.setAttribute("age", 20); // auto-boxing
%>
${pageScope.name} <br>
${pageScope["name"]} <br>
${pageScope['name']} <br>

${pageScope.age} <br>

해당 객체나 프로퍼티를 찾을 수 없으면 null이 아닌 빈 문자열이 리턴된다.
${pageScope.tel}

</body>
</html>