<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
.hint{
	display:none;
	font-size:.7em;	/*0.7의 글자 높이를 줌*/
	color:blue;
}
</style>
<script>
window.onload = loadedHandler;
function loadedHandler(){
	$("[type=text]").click(inputClickHandler);	/*type이 저것인 것에 이벤트를 걸 것이다  */
	$("[type=password]").click(inputClickHandler);
	$("[type=email]").click(inputClickHandler);
}
function inputClickHandler(e){
	//console.log("inputClickHandler");
	//console.log(this);
	console.log($(this).parents("tr").next(".hint"));
	//var $hintElement = $(this).parent().parent().next(".hint");
	
	$(".hint").css("visibility", "hidden");
	//$(".hint").hide(); // hint class 인것들 모두 hide()
	var $hintElement = $(this).parents("tr").next(".hint"); // hint class 중- 클릭한 것과 관련있는 것만 show()
	//$hintElement.show();
	$hintElement.css("visibility", "visible");
}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<%-- <form action="<%=request.getContextPath() %>/join" method="post"> --%>
		<form id="frmJoin">
			<table >
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" placeholder="(5-9, 영문자로시작,숫자,특수기호_!만가능)"></td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-9, 영문자로시작,숫자,특수기호_!만가능)</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="mpwd"placeholder="(5-9, 대문자, 소문자, 숫자, 특수문자(!_#) 최소1개이상 포함)"></td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-9, 영문자로시작,숫자,특수기호_!만가능)</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname"></td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(2-10, 한글)</td>
				</tr>
				<tr>
					<th>전화번호(7, 좀전...)</th>
					<td><input type="text" name="mtel"></td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(7, 좀전...)</td>
				</tr>
				<tr>
					<th>이메일(5-100, 일단생략)</th>
					<td><input type="email" name="memail"></td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-100, 일단생략)</td>
				</tr>
				<tr>
					<th>주민번호(14, 좀전...)</th>
					<td><input type="text" name="msno"></td>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(14, 좀전...)</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
<script>
	$("#frmJoin [type=button]").click(sumbitHandler);
	function sumbitHandler(){
		var result = checkRegularExpression1();
		if(result == false){
			//return;
		}
		//전달
		var queryString =$("#frmJoin").serialize();
		console.log(queryString);
		//queryString: ?n1=v1&n2=v2
		//var queryStringEx = "?"+"mid=" +$("[name=mid]").val()+"&mpwd=" +$("[name=mpwd]").val();
	}
	
	$("frmJoin [type=button]").click(sumbitHandler);
	function sumbitHandler(){
		console.log("여기들어완?")
		//유효성 검사
		var id = $("[name=mid]").val();	//아이디에 관한걸 제한(a-z:a부터 z까지 A-Za-z:대문자 A부터 z까지 가능)
		var regEx_id = /^[A-Za-z][A-Za-z0-9_!]{4,8}$/; //{4,8}:아홉글자까지만  
		if( !regEx_id.test(id) ) { //id에 들어있는걸 검사해줘!(test)
			alert("아이디는 5-16자 영문자로 시작하고 영문자와 숫자만 입력해주세요");
			$("[name=mid]").focus();
			return;
		}
		/* 
		if(id.length < 5 || id.length > 16) {
			//오류 조건식으로 체크함!
			alert("아이디는 5-16자 입력해주세요");
			$("[name=mid]").focus();
			return;
		}
		*/
		//string 객체 메소드
		//includes("a")
		
	
		// id가 정상적으로 입력되어있다면 다음 pwd 체크함.
		var pwd = $("[name=mpwd]").val();
		var regEx_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#])[a-zA-Z0-9!_#]{5,9}$/;
		if( !regEx_pwd.test(pwd) ) {
			console.log("정규표현식 부적합")
			alert("비밀번호는 8-20자 입력해주세요");
			$("[name=mpwd]").focus();
			return;
		}else{
			console.log("정규표현식 적합")
		}
		/* 
		if (pwd.length < 8  || pwd.length > 20) {
			//오류 조건식으로 체크함
			alert("비밀번호는 8-20자 입력해주세요");
			$("[name=mid]").focus();
			return;
		} 
		*/
		
		
		/* 내가 코드친거
 		var tell = $("[name=mtell]").val();	
		var regExpTel1 = /^01[7, ]$/;
		if( !regEx_id.test(id) ) { 
			alert("전화번호는 7자 이상 입력해주세요");
			$("[name=mtell]").focus();
			return;
		}
		var ptell = $("[name=mtell]").val(); */
	
</script>	
	
	
	
</body>
</html>