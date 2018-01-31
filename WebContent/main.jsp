<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script>
var control = '';

$('body').on('click', '#h', function(e){
	//e.preventDefault();
	alert("a");	
	control = '/reboard';
});

$('body').on('click','#b', function(e){
	//e.preventDefault();
	alert("b");
	control = '/album';
});



$(document).ready(function(){
	
	
	  $.ajax({
		type:'POST',
		dataType:'json',
		url:'${root}/boardadmin/hotlist.focus',
		success: function(data){
			makehotlist(data);
		}
	  });
	  $.ajax({
			type:'POST',
			dataType:'json',
			url:'${root}/boardadmin/rblist.focus',
			success: function(data){
				makerblist(data);
			}
		  });
	  
	  $.ajax({
			type:'POST',
			dataType:'json',
			url:'${root}/boardadmin/ralist.focus',
			success: function(data){
				makeralist(data);
			}
		  });
	
	});
	
var page = 1;
function makehotlist(data) {
	var output = '';
	var size = data.hlist.length;
	for(var i=0; i<size; i++) {
		output+='<tr>';
		output+='<th>';
		output+=data.hlist[i].seq;
		output+='</th>';
		output+='<td>';
		output+='<a id="h" href="javascript:viewArticle(\''+ data.hlist[i].bcode +'\','+page+',\'\',\'\',\''+data.hlist[i].seq +'\');">';
		//output+='<a href="javascript:controlmov(\''+ data.hlist[i].btype_name+'\');">';
		output+=decodeURI(data.hlist[i].subject);
		output+='</a>';
		output+='</td>';
		output+='<td>';
		output+=data.hlist[i].logtime;
		output+='</td>';
		output+='<td>';
		output+=decodeURI(data.hlist[i].cname);
		output+='</td>';
		output+='</tr>';
	}
	
	$("#hnotice").append(output);
	
}

function makerblist(data) {
	var output = '';
	var size = data.rblist.length;
	for(var i=0; i<size; i++) {
		
		var path = "${root}/upload/${data.rblist[i].savefolder}/${data.rblist[i].save_picture}";		
		output+='<div class="col-sm-3">';
		output+='<div class="thumbnail">';
		output+='<a id="b" href="javascript:viewArticle(\''+ data.rblist[i].bcode +'\','+page+',\'\',\'\',\''+data.rblist[i].seq +'\');">';
		output+='<img class="img-fluid" src=\"${root}/upload//'+data.rblist[i].savefolder+'//'+ data.rblist[i].save_picture+ '\">';
		output+='</a>';
		output+='<div class="caption">';
		output+='<h4>'
		output+=decodeURI(data.rblist[i].subject);
		output+='</h4>';
		output+='<p>'+decodeURI(data.rblist[i].content)+'</p>';
		output+='<p>'+data.rblist[i].logtime+'</p>';
		output+='</div>';
		output+='</div>';
		output+='</div>';
	}
	$("#rbnotice").append(output);
}


</script>
<style>
.card-body{
	margin-left:10px;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	padding-top:10px;
	padding-bottom:10px;
	
}

</style>

<div class="container-fluid">
      <h4><small>안녕하세요 <i class="ti-face-smile"></i> , <span>포커스에 오신걸 환영해요~</span></small></h4>
      <hr>
      <div class="col-sm-6">
      <h4><i class="ti-announcement"></i> 전체 공지사항</h4>
      <div class="row">
      		<div class="card">
      			<div class="card-body">
     				 <table class="table table-hover">
		                <thead>
		                      <tr>
		                      <th>글번호</th>
		                      <th>글제목</th>
		                      <th>작성자</th>
		                      <th>작성날짜</th>
		                   </tr>
		                </thead>
				          <tbody id="rnotice">
				           <tr>
				                <th scope="row">1</th>
				                <td>Kolor Tea Shirt For Man</td>
				                <td><span class="badge badge-primary">Sale</span></td>
				                <td>January 22</td>
				           </tr>
				           <tr>
				                <th scope="row">2</th>
				                <td>Kolor Tea Shirt For Women</td>
				                <td><span class="badge badge-success">Tax</span></td>
				                <td>January 30</td>
				           </tr>
				                <tr>
				                <th scope="row">3</th>
				                <td>Blue Backpack For Baby</td>
				                <td><span class="badge badge-danger">Extended</span></td>
				                <td>January 25</td>
				      		</tr>
				      		<tr>
				                <th scope="row">4</th>
				                <td>Blue Backpack For Baby</td>
				                <td><span class="badge badge-danger">Extended</span></td>
				                <td>January 25</td>
				      		</tr>
				      		<tr>
				                <th scope="row">5</th>
				                <td>Blue Backpack For Baby</td>
				                <td><span class="badge badge-danger">Extended</span></td>
				                <td>January 25</td>
				      		</tr>
					      	</tbody>
					      </table>
					      </div>
					 
					     
					    </div>
					    </div>
					    </div>
					    
					    
  		<div class="col-sm-6">
      <h4><i class="ti-stats-up"></i>  지식 게시판 인기글</h4>
      <div class="row">
      		<div class="card">
      			<div class="card-body">
     				 <table class="table table-hover ">
		                <thead>
		                      <tr>
		                      <th>글번호</th>
		                      <th>글제목</th>
		                      <th>작성날짜</th>
		                      <th>언어</th>
		                   </tr>
		                </thead>
				          <tbody id="hnotice"></tbody>
					      </table>
					</div>
				</div>
			</div>		
		</div>
		<div class="col-sm-12">
      <h4><i class="ti-book"></i>  최신 책추천</h4>
      <div class="row">
      		<div class="card">
      			<div class="card-body">
     				 <div id="rbnotice" class="row"></div>
					</div>
				</div>
			</div>		
		</div>
		<br><br>
		
		</div>		     
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>
