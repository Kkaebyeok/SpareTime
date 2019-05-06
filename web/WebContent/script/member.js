function loginCheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 써주세요");
		document.frm.id.focus();
		return false;
	}
	if (document.frm.pw.value.length == 0) {
		alert("암호를 반드시 입력해야 합니다.");
		document.frm.pw.focus();
		return false;
	}
	var url = "textlog"//+ document.frm.id.value+"&pw="+document.frm.pw.value;
	sessionStorage.setItem("id", document.frm.id.value);
	sessionStorage.setItem("pw", document.frm.pw.value);
	window.open(url,"", "width=300,height=200,left=800,top=500");
}

function idCheck() {
	var url = "idcheck?id=" + document.frm.id.value;
	window.open(url,"", "width=450,height=200");
	
	if(document.frm.id.value == ''){
		alert("아이디를 써주세요");
		document.frm.id.focus();
		return false;
	}
}


function choose() {
	opener.document.frm.id.value = document.frm.id.value;
	opener.document.frm.reid.value = document.frm.reid;
	self.close();
}

function joinCheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 써주세요");
		document.frm.id.focus();
		return false;
	}
	if (document.frm.id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		document.frm.id.focus();
		return false;
	}
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요");
		document.frm.name.focus();
		return false;
	}
	if (document.frm.nik.value.length == 0) {
		alert("닉네임을 써주세요");
		document.frm.nik.focus();
		return false;
	}
	if (document.frm.pw.value.length == 0) {
		alert("암호를 반드시 입력해야 합니다.");
		document.frm.pw.focus();
		return false;
	}
	if (document.frm.pw.value != document.frm.pw_check.value) {
		alert("암호가 일치하지 않습니다.");
		document.frm.pw.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복체크를 하지 않았습니다.");
		document.frm.reid.focus();
		return false;
	}
	if (isNaN(document.frm.tel.value)) {
		alert("휴대전화는 숫자만 입력가능합니다.");
		document.frm.tel.focus();
		return false;
	}
	alert("정상적으로 회원가입 되었습니다.")
}

function editCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요");
		document.frm.name.focus();
		return false;
	}
	if (document.frm.pw.value.length == 0) {
		alert("암호를 반드시 입력해야 합니다.");
		document.frm.pw.focus();
		return false;
	}
	if (document.frm.pw.value != document.frm.pw_check.value) {
		alert("암호가 일치하지 않습니다.");
		document.frm.pw.focus();
		return false;
	}
	if (isNaN(document.frm.tel.value)) {
		alert("휴대전화는 숫자만 입력가능합니다.");
		document.frm.tel.focus();
		return false;
	}
	if (document.frm.nik.value.length == 0) {
		alert("닉네임을 써주세요");
		document.frm.nik.focus();
		return false;
	}
	alert("회원정보가 수정 되었습니다.")
}

function submitCheck() {
	if (document.frm.title.value = "") {
		alert("제목을 써주세요.");
		document.frm.title.focus();
		return false;
	}
	else if (document.frm.content.value = "") {
		alert("내용을 써주세요.");
		document.frm.content.focus();
		return false;
	}else {
		return alert("게시글이 정상적으로 등록되었습니다.");
	}
	
}
