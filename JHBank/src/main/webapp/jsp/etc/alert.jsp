<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
    <script type="text/javascript">
    $().ready(function () {
            Swal.fire({
                icon: '${alert.icon}',                         // Alert 타입
                title: '${alert.msg}',         // Alert 제목
                text: '${alert.text}',  // Alert 내용
            }).then(function(){
                location.href='${alert.url}';
            });
    });
    </script>
