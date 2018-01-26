var control = "";

function moveWrite(bcode) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("pg").value = "1";
	document.getElementById("key").value = "";
	document.getElementById("word").value = "";
	
	document.getElementById("commonForm").action = root + control + "/write.focus";
	document.getElementById("commonForm").submit();
}


function moveModify(bcode,pg,key,word,seq) {
   document.getElementById("bcode").value = bcode;
   document.getElementById("pg").value = pg;
   document.getElementById("key").value = key;
   document.getElementById("word").value = word;
   document.getElementById("seq").value = seq;
   
   document.getElementById("commonForm").action = root + control + "/modify.focus";
   document.getElementById("commonForm").submit();
}

function deleteArticle(bcode,seq,reply) {
	if(reply == 0) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("seq").value = seq;	
	document.getElementById("commonForm").action = root + control + "/delete.focus";
	document.getElementById("commonForm").submit();	
	} else {
		alert("지울수 없습니다.");
		return;
	}
}

function listArticle(bcode, pg, key, word) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("pg").value = pg;
	document.getElementById("key").value = key;
	document.getElementById("word").value = word;
	
	document.getElementById("commonForm").action = root + control + "/list.focus";
	document.getElementById("commonForm").submit();
}

function viewArticle(bcode, pg, key, word, seq) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("pg").value = pg;
	document.getElementById("key").value = key;
	document.getElementById("word").value = word;
	document.getElementById("seq").value = seq;
	
	document.getElementById("commonForm").action = root + control + "/view.focus";
	document.getElementById("commonForm").submit();
}