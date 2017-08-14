/* repo = harmony-phase-0  */define(["css!search/1/typeahead.css"],function(){"use strict";var a,b,c;return a={up:function(a){return 38===a.which?!0:!1},down:function(a){return 40===a.which?!0:!1},left:function(a){return 37===a.which?!0:!1},right:function(a){return 39===a.which?!0:!1},enter:function(a){return 13===a.which?!0:!1},esc:function(a){return 27===a.which?!0:!1}},c={cache:{},emptyResponse:{types:[]},template:'<li class="typeahead_li_fmt pos{pos}" data-pos="{pos}">{text}</li>',init:function(a){var b=this;this.el=$("#"+a),this.input=this.el.find(".typeahead-search"),this.output=this.el.find(".typeahead-output"),this.ajaxData={s:2,sz:6},this.ajaxUrl=this.url(),this.input.length>0&&this.output.length>0?(this.input.hasClass("disabletypeahead")?webmd.debug("typeahead disabled: remove disabletypeahead class from input box to enable"):(this.input.keydown(function(a){b.keydown(a)}).keyup(function(a){b.keyup(a,this)}).focus(function(){$(b.output).find("li").length>0&&b.output.fadeIn(150)}).blur(function(){setTimeout(function(){b.output.fadeOut(100),b.waitingOnAjax=null},300)}),this.output.delegate("li","click",function(){webmd.debug("link clicked-value:"+$(this).text()),b.input.val($(this).text()),webmd.debug("start search:"+$(this).text()),b.submit()}).delegate("li","mouseover",function(){b.output.find(".selected").removeClass("selected"),$(this).hasClass("selected")||$(this).addClass("selected"),b.selected=$(this).index()+1}).delegate("li","mouseout",function(){$(this).removeClass("selected")})),this.initialized=!0):webmd.debug("typeahead disabled: required input/output elements are missing or this page is not secured")},url:function(){var a="";return document.location.hostname.indexOf(".perf.webmd")>-1?a="perf.":document.location.hostname.indexOf(".devintlive.webmd")>-1&&(a="devintlive."),"//www."+a+"webmd.com/api/qrl/LookupService.ashx"},fetch:function(a){var b,c,d,e=this;this.ajaxData.q=a;for(var f=a.length-1;f>0;f--)if(b=a.substring(0,f),b in this.cache&&0===this.cache[b].types.length){c=this.emptyResponse;break}return a in this.cache&&(c=this.cache[a]),c?this.callback(c):(d={type:"GET",cache:!0,url:this.ajaxUrl,dataType:"jsonp",data:this.ajaxData,jsonp:"jsonp",success:function(a){e.callback(a,e)}},$.ajax(d))},keydown:function(b){a.down(b)&&this._moveSelection(1),a.up(b)&&this._moveSelection(-1)},keyup:function(b,c){if(a.enter(b))this.submit(!0);else if(a.esc(b))this.output.fadeOut(100),this.waitingOnAjax=null;else if(a.up(b)||a.down(b))this.select(this.selected);else if(this._inputTextNumChanged(c)){var d=$(c).val();this.prevInput=d.replace(/[^a-z0-9]/gi,""),this.curSearch=d,d.length>2?this.search(this.curSearch):this._removeResults()}},search:function(a){this.waitingOnAjax=a,this.resultsNum=0,this.isThrottling===!1?(webmd.debug("no throttling,search for:"+a),this.fetch(a),this.isThrottling=!0):(webmd.debug("throttling...adding to queue:"+a),this._addtoQueue(a))},callback:function(a,b){var c=b||this;c.cache[c.ajaxData.q]=a,null!==c.waitingOnAjax?a.types&&a.types[0]&&a.types[0].references?(c.addResults(a.types[0].references),c.resultsNum=a.types[0].references.length):a.types.length<1&&(webmd.debug("empty results"),c._removeResults()):webmd.debug("prevented expired jsonp call")},addResults:function(a){this.selected=0;var b,c=this,d="";b=this.curSearch.toLowerCase().replace(/[^a-z0-9\s]/g,"").split(/[^a-z0-9]/),b=new RegExp(b.join("|"),"gi"),$.each(a,function(a,e){var f={pos:a+1,text:e.text.replace(b,function(a){return"<span>"+a+"</span>"})};d+=webmd.substitute(c.template,f)}),this.output.html(d).fadeIn(100)},select:function(a){this.output.find(".selected").removeClass("selected"),this.output.find(".typeahead_li_fmt.pos"+a).addClass("selected"),this.output.find(".selected").length>0?this.input.val(this.output.find(".selected").text()):this.input.val(this.curSearch)},moduleMetrics:function(a,b){var c="";return c=a>0?b+"_la"+a:b+"_submit"},submit:function(){this.form=this.el.closest("[data-metrics-module]").data("metrics-module")||"",webmd.search2=webmd.object(webmd.search,{submit:function(a,b,d){var e,f=c.moduleMetrics(b,d),g=webmd.url.getEnv(),h=webmd.url.getLifecycle();e=g?webmd.substitute("http://www{environment}.webmd.com/search",{environment:g}):webmd.substitute("http://www{lifecycle}.webmd.com/search",{lifecycle:h}),a&&(e+="/search_results/default.aspx?query="+a);try{ctrs(f)}catch(i){}return window.location.href=e,!1}}),webmd.search2.submit(this.input.val(),this.selected,this.form)},_removeResults:function(){var a=this;this.output.fadeOut(100),this.resultsNum=0,setTimeout(function(){a.output.html("")},100),this.waitingOnAjax=null},_moveSelection:function(a){this.resultsNum>0&&(this.selected=this.selected+a<=this.resultsNum&&this.selected+a>=0?this.selected+a:this.selected+a<0?this.resultsNum:0,this.select(this.selected))},_inputTextNumChanged:function(a){return this.prevInput!==$(a).val().replace(/[^a-z0-9]/gi,"")},_addtoQueue:function(a){var b=this;this.queue.length<1&&setTimeout(function(){b._fireQueue()},1e3),this.queue.push(a)},_fireQueue:function(){webmd.debug("fired queue:"+this.queue[this.queue.length-1]),this.fetch(this.queue[this.queue.length-1]),this.isThrottling=!1,this.queue=[]},resultsNum:0,initialized:!1,active:!1,form:"",selected:0,prevInput:"",curSearch:"",waitingOnAjax:null,isThrottling:!1,queue:[]},b={},b.init=function(a){var b=$.extend(!0,{},c);b.init(a)},b});