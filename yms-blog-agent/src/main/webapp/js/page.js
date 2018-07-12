var $curs = {};
// jump page
function jumpPage(page) {
	$curs.pageNo = page;
	query($curs);
}
function pagePlugin(pluginName,totalPages,page,totalNum,pageMethod){
	   if(page<=0){
		   return;
	   }
		var aim = $('#'+pluginName);
		aim.html("");
		var moz = 0;
		var minPage = page - 2;
		if(minPage <= 0){
			moz = minPage - 1;
			minPage = 1;
		}
		var maxPage = page + 2 - moz;
		if(maxPage > totalPages){
			maxPage = totalPages;
		}
		
		aim.append('<span> <a href="javascript:void(-1)" onclick="jumpPage('+ 1 +')">首页</a></span>');
		if(page != 1){
			aim.append('<span ><a href="javascript:void(-1)" onclick="jumpPage('+ (page-1) +')">上一页</a></span>');
		}
		for(var i = minPage ;i <= maxPage;i++){
			if(i != page){
				aim.append('<span><a href="javascript:void(-1)" onclick="jumpPage('+ i +')">'+ i +'</a></span>');
			}else{
				aim.append('<span><a href="javascript:void(-1)" style="color:#D3D3D3">'+ i +'</a></span>');				
			}
		}
		
		if(page != totalPages){
			aim.append('<span><a href="javascript:void(-1)" onclick="jumpPage('+ (page+1) +')">下一页</a></span>');
		}
		aim.append('<span><a href="javascript:void(-1)" onclick="jumpPage('+ totalPages +')">尾页</a></span>');
		$('.targetPage').bind('keydown',function(event){
			if (event.which == 13){
				var tpVal = $(this).val();
				if(isNaN(tpVal)){
					$(this).val('');
				}else{
					if(parseInt(tpVal) > totalPages){
						pageMethod(totalPages);
					}else{
						pageMethod(tpVal);
					}
				}
            } 
		});
	}