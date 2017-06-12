// 后端访问地址前缀
var baseUrl = "http://127.0.0.1:7777/hr";

//全局的ajax访问，处理ajax清求时sesion超时  
$.ajaxSetup({   
    complete: function(xhr, textStatus) {
        //通过XMLHttpRequest取得响应头，sessionstatus，  
        var sessionstatus = xhr.getResponseHeader("sessionStatus"); 

        if (sessionstatus == "timeout") {
            alert('登录超时，请重新登录');
            //如果超时就处理 ，指定要跳转的页面  
            location.href = 'logout.html';
        }
    }
});