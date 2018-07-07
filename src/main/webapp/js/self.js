function switchNavActive(id){
	$("#sidebar > ul > li").removeClass("active");
	$(id).addClass("active");
	//判断父级标签是否为<li>
	var tagname = $(id).parent().parent()[0].tagName;
	if("li" == tagname || "LI" == tagname){
		$(id).parent().parent().addClass("active");
	}
}

