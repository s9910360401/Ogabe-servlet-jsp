<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Ogabe_jsp.userservice.*"%>   
<%@ page import="com.Ogabe_jsp.uservo.*"%> 

<%
	UserService userSvc = new UserService();
    List<UserVO> list = userSvc.getAll();
    pageContext.setAttribute("list",list);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>OGABE|後台會員管理</title>
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
                <a class="nav-link active" aria-current="page" href="index.html"
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

    <div class="container p-5">
        <table class="table table-bordered border-dark border-1">
            <thead class="table-success text-primary-emphasis">
                <tr>
                    <th scope="col">會員_ID</th>
                    <th scope="col">會員_Email</th>
                    <th scope="col">會員_姓名</th>
                    <th scope="col">會員_暱稱</th>
                    <th scope="col">會員_地址</th>
                    <th scope="col">會員_電話</th>
                    <th scope="col">會員_VIP等級</th>
                    <th scope="col">會員_照片</th>
                    <th scope="col">Action</th>
            
                </tr>
            </thead>
          <tbody>
			<c:forEach var="UserVO" items="${list}" >        
            <tr>
              <th>${UserVO.user_ID}</th>
              <td>${UserVO.user_email}</td>
              <td>${UserVO.user_name}</td>
              <td>${UserVO.user_nickname}</td>
              <td>${UserVO.user_address}</td>
              <td>${UserVO.user_tel}</td>
              <td>${UserVO.user_vip_level_id}</td>
              <td><img src="ShowImage?user_ID=${UserVO.user_ID}"  width="110" height="140" id="userpic" ></td>
              <td>
              	<form METHOD="post" action="AdminUser">
              	 <input class="btn btn-sm btn-primary" type="submit" value="修改">
			     <input type="hidden" name="user_ID"  value="${UserVO.user_ID}">
			     <input type="hidden" name="action"	value="admin_GetOneUser_ForUpdate">                    
              	</form><br>
              	
              	<form METHOD="post" action="AdminUser">
              	 <input class="btn btn-sm btn-danger" type="submit" value="刪除">
			     <input type="hidden" name="user_ID"  value="${UserVO}">
			     <input type="hidden" name="action"	value="admin_user_Update">                    
              	</form>

              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
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


    </script>
</body>
</html>