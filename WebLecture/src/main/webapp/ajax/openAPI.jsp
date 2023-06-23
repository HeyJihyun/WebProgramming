<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#searchResult {
    width: 70%;
    height: 500px;
    border: 1px solid red;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $('button').click(function () {
            let searchDate = $('#searchDate').val().split('-').join('');
            console.log(searchDate);
            // 2023-06-21 박스오피스 요청
            $.ajax({
                url: 'http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
                type: 'get',
                data: {
                    key: 'd7c58083caa352247a4f9a4711b0c259',
                    targetDt: searchDate,
                    itemPerPage: '5'
                },
                // 200
                // 자바스크립트는 매개변수 중요 x 객체형으로 callback함수 실행
                success: callback, 
                error: function () {
                    alert('실패')
                }

            })
        })
    })
    
    // 자바스크립트에너는 callback함수가 중요
    function callback(result){
        let list = result.boxOfficeResult.dailyBoxOfficeList;
        console.log(list);
        $('#searchResult').empty();
        list.forEach(function(move){
            $('#searchResult').append('<h4>' + move.rank + '위 </h4>');
            $('#searchResult').append('<strong>' + move.movieNm + ' </strong>');
            $('#searchResult').append('(' + move.audiAcc + '명)<br>');
            $('#searchResult').append('<button>상세보기</button>');
            $('#searchResult').append('<hr>');
        })
    }
</script>
</head>

<body>
    <h2>일별 박스오피스 서비스</h2>
    검색일 :
    <input type="date" id="searchDate">
    <button>검색</button>
    <h3>검색결과</h3>
    <div id="searchResult"></div>
</body>

</html>