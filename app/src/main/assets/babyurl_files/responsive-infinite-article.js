/* repo: infinite-scroll/release-cons-media@v1.11-192-gf3728ef - Package Version: 4.0.0 - 2017-08-02 11:38 am - User: Kotlyarevsky, Dimitry */
!function(a,b){"undefined"!=typeof window.s_sponsor_program&&window.s_sponsor_program&&a("html").addClass("inProgram"),b.responsiveInfiniteScroll={dfpAdNumber:1,defaults:{container:a("article.infinite"),content:".article-page",pageUrl:document.location.href.replace(/[\?#].*/,""),waypointOffset:{desktop:{dfp:3,dpv:"50%"},mobile:{dfp:3,dpv:"50%"}},ads:{desktop:{showAds:!1,pos:null},mobile:{showAds:!0,pos:2026}},debounce:{active:!0,interval:500,topicId:[]}},settings:{},pvids:{},init:function(c){if(!this.hasPages())return!1;if(this.settings=a.extend(this.defaults,c),"undefined"!=typeof b.articleConfig&&(this.settings=a.extend(this.settings,b.articleConfig)),"mobile"===b.responsiveAds._breakPoint||"phablet"===b.responsiveAds._breakPoint){this.setUpAdContainers();try{"undefined"!=typeof this.settings.sharethrough&&"undefined"!=typeof this.settings.sharethrough.topicsToRefresh&&a.inArray(window.s_topic,this.settings.sharethrough.topicsToRefresh)>-1&&b.adViewability.makeResponsiveMobileTopAdSticky(a("#ads2-pos-2025-ad-banner"),{top:a(".global-nav-container").height()+5+"px",width:"100%",height:"88px"},this.settings.sharethrough.timeout||5e3)}catch(d){b.debug(d)}}return!0},getPlatformOptions:function(){return"mobile"===b.responsiveAds._breakPoint||"phablet"===b.responsiveAds._breakPoint?{waypoint:b.responsiveInfiniteScroll.settings.waypointOffset.mobile,ads:b.responsiveInfiniteScroll.settings.ads.mobile}:{waypoint:b.responsiveInfiniteScroll.settings.waypointOffset.desktop,ads:b.responsiveInfiniteScroll.settings.ads.desktop}},insertAd:function(a){this.callDFPHouseAd(a)},hasPages:function(){var b=a(".article-page").length;return 2>b?!1:!0},setUpAdContainers:function(){var b=a(".article-page:last").data("page");a(".article-page").each(function(c,d){var e=a("<div/>",{"class":"inStreamAd"}),f=a(d),g=f.data("page");1===g||(a(d).data("page")===b?a("article footer").prepend(e):f.append(e))})},callDFPHouseAd:function(c){var d=a(c).data("page")||1,e="infinite-ad-"+d,f=a(c).find(".inStreamAd");f.append(a('<div id="'+e+'">')),googletag&&googletag.apiReady&&googletag.pubads().updateCorrelator(),b.ads2.setPageTarget({pg:d,ll:1,pvid:b.responsiveInfiniteScroll.pvids[d]||window.s_pageview_id}),b.ads2Consumer.defineAd({id:e,pos:this.getPlatformOptions().ads.pos,sizes:[[300,50],[300,51],[300,250],[300,253],[320,50],[320,51],[320,250]],refresh:!1,immediate:!1,keys:{strnativekey:b.sharethrough.sharethroughSlots[2026]}}),this.dfpAdNumber=d},enableDebugMode:function(){var c=this.getPlatformOptions().waypoint.dfp;return".staging"!==b.url.getLifecycle()?!1:void a("<style>").prop("type","text/css").html('			.article-page	{				position:relative;			}			.article-page:after {				content:"";				position:absolute;				top:'+100/c+"%;				left:0;				right: 0;				border-top:solid 1px red;			}").appendTo("head")}}}(jQuery,webmd||{}),$(function(){var a;if("mobile"===webmd.responsiveAds._breakPoint||"phablet"===webmd.responsiveAds._breakPoint||"WebMD Article"===s_publication_source){if(!webmd.responsiveInfiniteScroll.init())return!1;a=webmd.responsiveInfiniteScroll.getPlatformOptions(),"undefined"!=typeof webmd.url.getParam("debugmode")&&webmd.responsiveInfiniteScroll.enableDebugMode(),require(["waypoints/1/waypoints"],function(b){if(window.onElementHeightChange=function(a,b){var c,d=$(a).height();!function e(){c=$(a).height(),d!=c&&b(),d=c,a.onElementHeightChangeTimer&&clearTimeout(a.onElementHeightChangeTimer),a.onElementHeightChangeTimer=setTimeout(e,200)}()},window.onElementHeightChange(document.body,function(){Waypoint.refreshAll()}),$(".article-page:not(:first)").each(function(){var b,c,d=$(this),e=webmd.responsiveInfiniteScroll.settings.debounce,f=d.data("page");"undefined"==typeof window._loadedeAds&&(window._loadedAds=[]),c=new Waypoint({element:this,handler:function(c){if("up"===c||$.inArray(window.current_page,window._loadedAds)>-1)return!1;if(b=function(b,c,d){return function(){if(d!==window.current_page)return!1;try{window.advBidxc.isLoaded&&window.advBidxc.next()}catch(b){}c.find(".inStreamAd").length>0&&a.ads.showAds&&(webmd.responsiveInfiniteScroll.insertAd(c),window._loadedAds.push(d))}}(this,d,f),e.active&&$.inArray(window.s_topic,e.topicId)>-1)!function(){setTimeout(function(){b()},webmd.responsiveInfiniteScroll.settings.debounce.interval)}();else{try{window.advBidxc.isLoaded&&window.advBidxc.next()}catch(g){}d.find(".inStreamAd").length>0&&a.ads.showAds&&(webmd.responsiveInfiniteScroll.insertAd(d),window._loadedAds.push(f))}},offset:a.waypoint.dfp,continuous:!1});new Waypoint({element:this,handler:function(){var a=d.data("page");return window.current_page=a,a in webmd.responsiveInfiniteScroll.pvids?!0:(webmd.metrics.dpv({moduleName:"pg-n-swipe",pageName:webmd.responsiveInfiniteScroll.settings.pageUrl,iCount:a,refresh:!1}),void(webmd.responsiveInfiniteScroll.pvids[window.current_page]=window.s_pageview_id))},offset:a.waypoint.dpv,continuous:!0})}),"mobile"===webmd.responsiveAds._breakPoint||"phablet"===webmd.responsiveAds._breakPoint){new Waypoint({element:$("article footer")[0],handler:function(){window.googletag&&googletag.apiReady&&(googletag.pubads().updateCorrelator(),webmd.ads2.setPageTarget("pg",$(".article-page").length+1),webmd.ads2Consumer.defineAd({id:"ads2-pos-2026-ad-right-replacement",pos:a.ads.pos,sizes:[[300,50],[300,51],[300,250],[300,253],[320,50],[320,51],[320,250]],refresh:!1,immediate:!1,keys:{al:"cons_bot"}})),this.destroy()},offset:"50%",continous:!1})}})}});