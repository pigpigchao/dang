$(function(){
				$(".tooltip").mouseover(
					function(e){
						//��̬���һ��div,div��ʾ��ͼ
						//��ȡ��ǰaԪ�ص�hrefֵ
						var image_url=$(this).children("img").attr("src");
						var $div=$("<div id='tooltip'><img src='"+image_url+"' /></div>");
						$div.css("left",e.pageX+0.1);//����$div��ʽ,ָ����ʾ��left,top
						$div.css("top",e.pageY+0.1);
						$("body").append($div);//��div��ӵ�ҳ����
						$div.show();//��div��ͼ��ʾ
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

