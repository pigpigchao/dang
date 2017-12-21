$(function(){
				$(".tooltip").mouseover(
					function(e){
						//动态添加一个div,div显示大图
						//获取当前a元素的href值
						var image_url=$(this).children("img").attr("src");
						var $div=$("<div id='tooltip'><img src='"+image_url+"' /></div>");
						$div.css("left",e.pageX+0.1);//设置$div样式,指定显示的left,top
						$div.css("top",e.pageY+0.1);
						$("body").append($div);//将div添加到页面中
						$div.show();//将div大图显示
					}
				).mouseout(
					function(){
						$("#tooltip").remove();
					}
				).mousemove(function(e){
					$("#tooltip").css("left",e.pageX);
					$("#tooltip").css("top",e.pageY);
				});
			});

