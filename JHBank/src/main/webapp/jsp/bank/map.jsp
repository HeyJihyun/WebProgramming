<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id="mapPage">
<h4>오시는길</h4>
<div id="map" style="width:500px;height:400px;"></div>
<h6>경기도 성남시 수정구 수정로 398 드림관 2층</h6>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0aebe6a45346423e17101d47f32c083e"></script>
  <script>
    var container = document.getElementById('map');
    var options = {
      center: new kakao.maps.LatLng(37.4590828, 127.1537789),
      level: 3
    };

    var map = new kakao.maps.Map(container, options);
  </script>

</section>
<jsp:include page="/jsp/include/bottom.jsp" />