
/**
* 获得请求参数的jquery全局插件
*/
$.extend({
	getParam:function(key) {

		var url = location.href; //获得当前url地址

		var index = url.indexOf('?');//返回？的位置

		var str = url.substring(index + 1); //截取？后面的内容

		var arr= str.split('&'); //按照&分解字符串为数组

		//遍历数组
		for (var i = 0;i < arr.length;i ++) {

			//根据=分解字符串
			var param = arr[i].split('=');

			//如果传入的参数名和当前名称相等，返回参数值
			if (param[0] == key) {
				return param[1];
			}

		}

	}	
});
