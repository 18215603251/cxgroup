

/*pageIndex为查询的页码, pageCount为一页要展示的记录个数, url为后台的请求接口*/
var divideFunction = function(pageIndex, pageCount, requestUrl) {
	
	// 发送ajax请求获取信息
	$.ajax({
		url : requestUrl,
		data : {
			"pageCount" : pageCount,
			"pageIndex" : pageIndex
		},
		success : function(data) {
			/* 循环添加主体内容 */
			$.each(data.certs, function(index, element) {
				var title = element.title;
				var url = "/image/" + element.url;
				
				// div用于包裹标题与图片
				var div = $("<div></div>");
				$(div).addClass("index" + index);
				// 再将div加入到外部固定的div中
				$(".cert_list").append(div);

				var h4 = $("<h4></h4>");
				$(h4).addClass("h4").html(title);
				var img = $("<img></img>");
				$(img).attr("src", url).addClass("img");
				// 向div中加入这两个标签
				$(".index" + index).append(h4, img);
			});

			/** ***************添加导航内容****************** */
			$(".ul .totalPages").html(data.totalPageSize);
			$(".ul .currentPage").html(data.currentPage);

			/* 前 */
			if (data.start > 1) {
				var prepage = $("<li><a href> &laquo; </a></li>"); 		// 上一页
				$(prepage).attr("data_index", data.currentPage - 1);			// 给每个标签添加这个属性, 代表页码
				$(".nav-list").append(prepage);
			}
			var startpage = $("<li><a href>" + data.start + " </a></li>"); // 开始页
			$(startpage).attr("data_index", data.start);
			if (data.start == data.currentPage) {					// 给当前页添加激活状态
				$(startpage).addClass("active");
			}
			$(".nav-list").append(startpage);

			/* 中 */
			var list = new Array(data.end - data.start - 1);		// 结束标签与开始标签之间有多少个标签
			for (var i = 0; i < list.length; i++) {
				list[i] = data.start + i + 1;						// 第n个, 即标签页码数字
				var li = $("<li><a href>" + list[i] + "</a></li>");
				$(li).attr("data_index", list[i]);
				if (list[i] == data.currentPage) {
					$(li).addClass("active");
				}
				$(".nav-list").append(li);
			}

			/* 后 */
			var endpage = $("<li><a href> " + data.end + " </a></li>"); // 结束页
			$(endpage).attr("data_index", data.end);
			if (data.end == data.currentPage) {
				$(endpage).addClass("active");
			}
			$(".nav-list").append(endpage);
			if (data.end != data.totalPageSize) {
				var afterpage = $("<li><a href> &raquo; </a></li>"); // 下一页
				$(afterpage).attr("data_index", data.currentPage + 1);
				$(".nav-list").append(afterpage);
			}
		}
	});

}