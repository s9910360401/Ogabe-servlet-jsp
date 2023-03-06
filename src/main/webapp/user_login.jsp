<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errorMsgs = (String) session.getAttribute("errorMsgs");%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>OGABE|會員登入</title>
    <link href="dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="dist/css/carousel.css" rel="stylesheet" />
    <link href="dist/css/my.css" rel="stylesheet" />
    <link href="cheatsheet.css" rel="stylesheet" />
    <link href="dist/css/guideline.css" rel="stylesheet" />
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


			<a href="user_register.jsp"
                type="button"
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#staticBackdrop">註冊
            </a>

            </ul>
          </div>
        </div>
      </nav>
    </header>
    <main>
    <br>
    <div class="text-center mt-1">
        <h1>會員登入</h1>
    </div>
    
    <div class="row p-5" style="background-color: #EAE0DA;">
        <div class="col"></div>
        <div class="col">
        <form action="user" method="post" name="login-form">
            <div class="form-group col-sm-12">
              <label for="exampleInputEmail1">帳號</label>
              <input type="email" class="form-control" name="user_email" id="UserEmail1" placeholder="請輸入Email">
            </div><br>
            <div class="form-group col-sm-12">
              <label for="exampleInputPassword1">密碼</label>
              <input type="password" class="form-control" name="user_pwd" id="UserPassword1" placeholder="請輸入密碼">
            </div><br>
            
            
            <input type="hidden" name="action" value="login">
            <button type="submit" class="btn btn-primary col-sm-5 ">登入</button>
            
        </form><br>

        <div>還沒有會員? <a href="user_register.jsp">我要註冊</a></div>
        <div><a href=".">忘記密碼</a></div>
        </div>
        <div class="col"></div>
        </div>



    </main>
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
    <script src="dist/js/bootstrap.bundle.min.js"></script>
    <script>
    	let msg = "<%=errorMsgs%>";
    	console.log(msg);
    	if(!(msg=="null")){
    		alert(msg);
    		<% session.removeAttribute("errorMsgs"); %>
    	}
    </script>
</body>
</html>