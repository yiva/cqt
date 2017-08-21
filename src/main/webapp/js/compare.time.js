$.fn.extend({
	checkTime : function(){
	var s_time_id = this.attr("check-time");//开始时间
	var s_time = $("#"+s_time_id).val();
	//alert(s_time);
	var e_time = this.val();
	//alert(e_time);
	
	if(s_time >= e_time){
		if($('#'+this.attr("id")+'_error').length <= 0){
			this.parent().parent(".controls").append("<span for='"+this.attr("id")+"' id='"+this.attr("id")+"_error' class='help-block error'>开始时间不小于结束时间.</span>");
		}
		this.parent().parent(".controls").parent(".control-group").addClass("error");
		return false;
	}
	this.parent().parent(".controls").parent(".control-group").removeClass("error");
	this.parent().parent(".controls > span").remove();
	return true;
  }
});