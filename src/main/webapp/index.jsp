<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<html>
<body>
<h2>FortuneWheel</h2>
<h5><button id="btn-1" class="btn" onclick="fortuneWheel()">抽奖</button></h5>
<h5><button id="btn-2" class="btn" onclick="userRegist()">用户信息接口</button></h5>
<h5><button id="btn-9" class="btn" onclick="allAwardee()">查询所有获奖人信息</button></h5>
<h5><button id="btn-10" class="btn" onclick="deleteAllAwardee()">删除所有获奖人信息</button></h5>
<h5><button id="btn-3" class="btn" onclick="insertAwardee()">插入获奖人信息</button></h5>
<h5><button id="btn-4" class="btn" onclick="awardee()">查询获奖人信息</button></h5>
<h5><button id="btn-11" class="btn" onclick="oneAwardInfo()">查询某个奖品信息</button></h5>
<h5><button id="btn-5" class="btn" onclick="awardInfo()">查询奖品信息</button></h5>
<h5>插入奖品信息</h5>
<form action="/insertAwardConfig" enctype="multipart/form-data" method="post">
    上传用户：<input type="text" name="awardName" value="name"><br/>
    上传Id：<input type="text" name="awardId" value="3"><br/>
    上传描述：<input type="text" name="awardDes" value="def"><br/>
    上传库存：<input type="text" name="awardNum" value="3"><br/>
    上传概率：<input type="text" name="awardProb" value="0.5"><br/>
    上传星期：<input type="text" name="awardWeek" value="2"><br/>
    上传文件1（请以jpg、png、gif格式上传）：<input type="file" name="awardImg"><br/>
    上传文件2（请以jpg、png、gif格式上传）：<input type="file" name="awardImg2"><br/>
    <input type="submit" value="提交">
</form>
<h5><button id="btn-6" class="btn" onclick="deleteAwardConfig()">删除奖品信息</button></h5>
<h5><button id="btn-12" class="btn" onclick="wardConfig()">配置奖品信息</button></h5>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<div>

</div>
<script>
    function fortuneWheel() {
        console.log("start")
        $.post("http://192.168.6.10:8080/fortuneWheel", {"awardNum": 1}, function(data) {
            console.log("TestWHEEL", data);
        });
    }
    function userRegist() {
        console.log("start")
        $.post("http://192.168.6.10:8080/userRegist", {"userName": "user0", "userPhone": "18810708780"}, function(data) {
            console.log("TestWHEEL", data);
        });
    }
    function allAwardee() {
        console.log("start")
        $.get("http://192.168.6.10:8080/allAwardee",  function(data) {
            console.log("TestPost4", data);
        });
    }
    function deleteAllAwardee() {
        console.log("start")
        $.post("http://192.168.6.10:8080/deleteAllAwardee",  function(data) {
            console.log("TestPost4", data);
        });
    }
    function insertAwardee() {
        console.log("start")
        $.post("http://192.168.6.10:8080/insertAwardee", {"userId": "123456", "phoneNum": "18888888888", "awardName": "10"}, function(data) {
            console.log("TestPost2", data);
        });
    }
    //modify
    function awardee() {
        console.log("start")
        $.get("http://192.168.6.10:8080/awardee", {"userId": 1}, function(data) {
            console.log("TestPost4", data);
        });
    }
    function oneAwardInfo() {
        console.log("start")
        $.get("http://192.168.6.10:8080/oneAwardInfo", {"awardId":1, "week":1}, function(data) {
            console.log("TestPost3", data);
        });
    }
    function awardInfo() {
        console.log("start")
        $.get("http://192.168.6.10:8080/awardInfo", {"week":1}, function(data) {
            console.log("TestPost3", data);
        });
    }
    function deleteAwardConfig() {
        console.log("start")
        $.post("http://192.168.6.10:8080/deleteAwardConfig", {"week": 2, "awardId": 3}, function(data) {
            console.log("TestPost6", data);
        });
    }
    function insertAwardConfig() {
        console.log("start")
        $.post("http://192.168.6.10:8080/insertAwardConfig", {"awardId": 3, "awardName": "name","awardDes":"def","awardNum":3,"awardProb":1,"awardImg":"abc","week":2}, function(data) {
            console.log("TestPost5", data);
        });
    }
    function awardConfig() {
        console.log("start")
        $.post("http://192.168.6.10:8080/awardConfig", {"awardId": 3, "awardName": "name","awardDes":"def","awardNum":3,"awardProb":1,"week":2}, function(data) {
            console.log("TestPost5", data);
        });
    }
    (function(){
        var data = {username: 'user0'};
//        $.ajax({
//            url : "http://localhost:8080/fortuneWheel",
//            type : "POST",
//            data :data,
//            dataType: 'json',
//            contentType:'application/json;charset=UTF-8',
//            success : function(result) {
//                console.log(result);
//            }
//        });

/*        $.post("http://localhost:8080/postTest", {"userName": "lshaluminum", "age": 10}, function(data) {
            console.log("TestPost", data);
        });*/
        //成功
        /*$("#btn-verify").post("http://localhost:8080/insertAwardee", {"userId": "123456", "awardName": "10"}, function(data) {
            console.log("TestPost2", data);
        });*/
//成功
        /*$.post("http://localhost:8080/awardConfig", {"awardId": 3, "awardName": "name","awardDes":"def","awardNum":3,"awardProb":1,"awardImg":"abc","week":2}, function(data) {
            console.log("TestPost5", data);
        });*/
//成功
/*        $.post("http://localhost:8080/deleteAwardConfig", {"week": 2, "id": 8}, function(data) {
            console.log("TestPost6", data);
        });*/
//成功
/*        $.post("http://localhost:8080/userLogin", {"userName": "test", "userPhone": "18888888888"}, function(data) {
            console.log("TestWHEEL", data);
        });*/
/*        $.get("http://localhost:8080/awardInfo", {"week":1}, function(data) {
         console.log("TestPost3", data);
         });*/
/*         $.get("http://localhost:8080/awardee", {"userPhone": "18810708785"}, function(data) {
         console.log("TestPost4", data);
         });*/
//成功
        //for (i=0;i<100;i++){
//            $.post("http://localhost:8080/fortuneWheel", {"awardNum": 1}, function(data) {
//                console.log("TestWHEEL", data);
//            });
        //}

    })();
</script>
</body>
</html>
