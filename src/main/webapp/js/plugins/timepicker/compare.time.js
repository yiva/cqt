$.fn.extend({
	checkTime : function(){
	var s_time_id = this.attr("check-time");//开始时间
	var s_time = $("#"+s_time_id).val();
	var e_time = this.val();
	
	if(s_time >= e_time){
		this.parent().parent(".controls").parent(".control-group").addClass("error");
		this.parent().parent(".controls").append("<span for='"+this+"' class='help-block error'>开始时间不小于结束时间.</span>");
		return false;
	}
	this.parent().parent(".controls").parent(".control-group").removeClass("error");
	this.parent().parent(".controls span").remove();
	return true;
  }
});