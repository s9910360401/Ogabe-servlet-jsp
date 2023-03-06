<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.Ogabe_jsp.uservo.*"%>    
    
<%
		UserVO uservo = (UserVO) session.getAttribute("uservo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>OGABE|會員資料</title>
<!-- <link href="dist/css/bootstrap.min.css" rel="stylesheet" /> -->
<link href="dist/css/carousel.css" rel="stylesheet" />
<link href="dist/css/my.css" rel="stylesheet" />
<link href="cheatsheet.css" rel="stylesheet" />
<link href="dist/css/guideline.css" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
        .wrapper{
			display: flex;
			background: #EAE0DA;

        }
		#aside_style{
			width: 250px;
			background-color: #D9d9d9;
			flex-shrink:0
            
		}
        /* #icon_userdata{
          width: 100px;
          height: 100px;
        } */
        #navbarSupportedContent ul,li{
          color: black;
          font-size: 1.02em;
          font-weight: 800;
        }
        #preview{
          border: 1px solid black;
          display: inline-block;
          width: 145px;
          min-height: 196px;
          position: relative;
        }
        #preview span.text{
          position: absolute;
          display: inline-block;
          left: 50%;
          top: 50%;
          transform: translate(-50%, -50%);
          z-index: -1;
          color: lightgray;
        }
        #preview img.preview_img{
          width: 100%;
          height: 100%;
        }
		#space_block{
			width: 250px;
		}
    </style>
</head>
<body>
    <header>
      <nav
        class="navbar navbar-expand-md fixed-top navbar-dark bg-headercolor"
        aria-label="Fourth navbar example"
      >
        <div class="container-fluid">
          <a class="navbar-brand" href="index.html"
            ><img src="images\ogabecolor.png" alt="Ogabe Logo"
          /></a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarsExample04"
            aria-controls="navbarsExample04"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div
            class="collapse navbar-collapse flex-grow-0"
            id="navbarsExample04"
          >
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
              <!-- <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="index.html"
                  >首頁</a
                >
              </li> -->
              <!-- <li class="nav-item">
                <a class="nav-link" href="guideline.html">規格書</a>
              </li> -->
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="index.html"
                  >最新消息</a
                >
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  >購物商城</a
                >
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" href="breakpoint.html">咖啡豆</a>
                  </li>
                  <li><a class="dropdown-item" href="#">咖啡器具</a></li>
                  <li>
                    <a class="dropdown-item" href="#">組合活動</a>
                  </li>
                </ul>
              </li>

              <li class="nav-item">
                <a
                  class="nav-link"
                  aria-current="page"
                  href="forum_welcome.html"
                  >論壇</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="rest_index.html"
                  >線上訂餐</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="index.html"
                  >體驗課程</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="index.html"
                  >優惠活動</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="index.html"
                  >小遊戲</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="user_login.jsp"
                  >登入</a
                ><!--active是調整成高亮
                -->
              </li>
              <!-- Button trigger modal -->
              <button
                type="button"
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#staticBackdrop"
              >
                註冊
              </button>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    
            <div class="wrapper">
                <aside id="aside_style">
                    <br>
                    <div class="user_image">
                        <center>
                            <img src="ShowImage?user_ID=${uservo.user_ID}"  width="145" height="196" id="userpic" >
                        </center>
                        
                    </div><br><br>
                
                    <div class="container d-flex flex-row flex-md-row ms-0 px-1">
                        <nav class="navbar navbar-expand-md navbar-light d-flex flex-md-column">
            
                            <div>
                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle Navigation">
                                <span class="navbar-toggler-icon"></span>
                                </button>
                            </div>
            
                            <div class="collapse navbar-collapse w-100" id="navbarSupportedContent">
                                <ul class="navbar-nav w-100 d-flex flex-md-column  ">
                                    <li>
                                        <a href="#" class="nav-link" aria-current="page">會員基本資料</a>
                                    </li>
                                    <li>
                                        <a href="#" class="nav-link" aria-current="page">修改密碼</a>
                                    </li>
                                    <li>
                                        <a href="#" class="nav-link" aria-current="page">購物車</a>
                                    </li>
                                    <li>
                                        <a href="#" class="nav-link" aria-current="page">收藏的文章</a>
                                    </li>
                                    <li>
                                        <a href="#" class="nav-link" aria-current="page">購物商城訂單紀錄</a>
                                    </li>
                                    <li>
                                        <a href="#" class="nav-link" aria-current="page">線上訂餐訂單紀錄</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>   
                    <br><br><br><br><br><br>
                </aside>

				<div id="space_block">

				</div>

				<div id="contents" class="container p-4">
                
					<br>
						<h1>會員基本資料</h1>
					<br>
					  	
					  	<form enctype="multipart/form-data" action="user" method="post" name="update-form">

						  	<div class="form-group col-sm-8">
						  	<label for="exampleInputPassword1">會員姓名</label>
							  <div class="input-group">
								<input type="text" class="form-control" id="UserName" value="${uservo.user_name}" name="user_name">
								<button class="btn btn-primary"><i class="fa-regular fa-pen-to-square">編輯</i></button>
							  </div>
		
						  </div><br>
						  <div class="form-group col-sm-8">
							  <label for="exampleInputPassword1">會員暱稱</label>
							  <div class="input-group">
								<input type="text" class="form-control" id="UserNickname" value="${uservo.user_nickname}" name="user_nickname"> 
								<button class="btn btn-primary"><i class="fa-regular fa-pen-to-square">編輯</i></button>
							  </div>
						  </div><br>
						  <div class="form-group col-sm-8">
							  <label for="exampleInputPassword1">會員地址</label>
							  <div class="input-group">
								<input type="text" class="form-control" id="UserAddress" value="${uservo.user_address}" name="user_address"> 
								<button class="btn btn-primary"><i class="fa-regular fa-pen-to-square">編輯</i></button>
							  </div>
						  </div><br>
						  <div class="form-group col-sm-8">
							  <label for="exampleInputPassword1">會員電話</label>
							  <div class="input-group">
								<input type="text" class="form-control" id="UserMobile" value="${uservo.user_tel}" name="user_tel">
								<button class="btn btn-primary"><i class="fa-regular fa-pen-to-square">編輯</i></button>
							  </div>
						  </div><br>
						  <div class="form-group col-sm-8">
							<label for="exampleInputPassword1">會員照片更換</label>
							<div class="input-group">
							  <input type="file" class="form-control" id="p_file"  name="user_pic">
							  <button class="btn btn-primary"><i class="fa-solid fa-check">送出圖片</i></button>
							</div><br>
							<div>預覽圖</div>
							<div id="preview"><span class="preview_span"></span></div>
							</div><br>
							
            				<input type="hidden" name="action" value="update">
            				<input type="hidden" id="UserId" name="user_ID" value=${uservo.user_ID}>
							<button type="submit" class="btn btn-primary col-sm-5 ">送出資料</button>						  	
					  	
					  	</form>

				</div>
            </div> 

    <!-- footer -->
    <footer
      class="container-fluid mt-1 bg-footercolor text-center text-light link- p-3"
    >
      <p>
        <a href="#" class="text-info">關於我們</a> &middot;
        <a href="#" class="text-info">Q&A</a> &middot;
        <a href="#" class="text-info">顧客權益</a> &middot;
        <a href="#" class="text-info">客服中心</a>
      </p>
    </footer>




    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/726c532433.js" crossorigin="anonymous"></script>
    <script>
      let preview_el = document.getElementById("preview");
      let p_file_el = document.getElementById("p_file");
	  let UserName_el = document.getElementById("UserName");
	  let UserNickname_el = document.getElementById("UserNickname");
	  let UserAddress_el = document.getElementById("UserAddress");
	  let UserMobile_el = document.getElementById("UserMobile");


      let preview_img = function(file){
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.addEventListener("load", function(){
          let img_str = '<img src="' + reader.result + '" class="preview_img">';
          preview_el.innerHTML = img_str;
        })
      }

      p_file_el.addEventListener("change", function(e){
          if(this.files.length > 0){
            preview_img(this.files[0]);
          }else{
            preview_el.innerHTML = '<span class="text">預覽圖</span>';
          }
        });

    </script>


</body>
</html>