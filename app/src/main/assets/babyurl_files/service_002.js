/* repo: newsletter/HEAD@1.6.1-0-geea1451 - Package Version: 1.6.1 - 2017-07-24 03:29 pm - User:  */
/*! newsletter service wrapper */
define(["webmd-xdm/1/webmd-xdm"],function(e){var t;return t={urlSubscribe:"https://www"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/json2/subscribe2",urlUnsubscribe:"https://member"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/json2/unsub",urlGetPromo:"/api/reg/regapi.svc/jsonp/getnlappmapping",urlGetPromoImg:window.image_server_url+"/webmd/consumer_assets/site_images/registration/images/newsletterpromo/",urlAddChild:"https://member"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/cds/addchild",urlUpdateChild:"https://member"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/cds/updatechild",urlDeleteChild:"https://member"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/cds/deletechild",urlGetChildren:"https://member"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/cds/children",urlSubscribe2:"https://member"+webmd.url.getEnv()+".webmd.com/api/reg/regapi.svc/json2/subscribe2",timeout:15e3,names:{11:"Allergies and Asthma",12:"Arthritis",13:"Breast Cancer",14:"Cancer",16:"Cholesterol Management",17:"Chronic Pain",18:"Diabetes",19:"Emotional Wellness",21:"Fitness",22:"Digestive Health",24:"Heart Health",26:"Men's Health",25:"Hypertension",27:"Multiple Sclerosis",28:"Parenting and Children's Health",29:"Rheumatoid Arthritis",30:"Sex and Relationships",31:"Sleep Well",35:"Women's Health",36:"WebMD Daily",37:"Skin and Beauty",40:"Healthy Bones",41:"Weight Loss Wisdom",42:"Healthy Eating",43:"Living Better",44:"Depression",45:"Fibromyalgia",60:"Alzheimer's",61:"Cold and Flu",62:"Menopause",63:"Oral Health",66:"ADD/ADHD",74:"COPD",77:"Healthy Cats",78:"Healthy Dogs",82:"Alternative Health",83:"Daily Bite",84:"Pregnancy and Baby",97:"Eye Health",261:"Your Health Insurance Guide"},promoDefault:{image:"default.png",url:webmd.url.addLifecycleAndEnv("http://www.webmd.com/"),description:"Always safe &amp; secure, sign up with WebMD today and take advantage of a full suite of tools and services designed to help you on your journey to becoming a healthier you.",button:"Sign Up Now",appid:1,isMobile:!1},subscribe:function(t){var i,n,s,r,a={};if(s=this,i=new $.Deferred,n=i.promise(),t=$.extend({timeout:s.timeout},t),t.id===void 0)throw"Missing newsletter id";if(!t.email)throw"Missing email address";return $.isArray(t.id)&&(t.id=t.id.join(",")),a.NLRequest={},a.NLRequest.NLIDS=t.id,a.Email=t.email,t.privacy&&(a.PPAccept=1),t.vendor&&(a.Vendor=t.vendor),t.publisher&&(a.publisher=t.publisher),t.campaign&&(a.campaign=t.campaign),clearTimeout(r),r=setTimeout(function(){i.reject(n,"timeout","Newsletter service timed out.")},t.timeout),e.receiverUrl=webmd.url.addLifecycleAndEnv("https://www.webmd.com/xdm-oo"),n=e.call({service:"regapi/subscribe2",data:JSON.stringify(a)}).done(function(e){if("success"===e.stat){if(!webmd.cookie.exists("WBMD_AUTH")&&!webmd.cookie.exists("WBMD_SAUTH")){var t=webmd.object.get("subscriberKey",e);s.cookieSet(t)}}else-52===e.code?i.reject(n,"readonly","Newsletter service is in readonly mode"):i.reject(n,"error","Newsletter service returned an error")}).fail(function(){webmd.debug("Service Failed!"),wmdPageLink("reg-error_l-nl")})},subscribe2:function(t){var i,n,s,r,a={};if(s=this,i=new $.Deferred,n=i.promise(),t=$.extend({timeout:s.timeout},t),!t.Email)throw"Missing email address";if(t.NLRequest){if(a.NLRequest={},t.NLRequest.NLIDS===void 0)throw"Missing newsletter id";a.NLRequest.NLIDS=$.isArray(t.NLRequest.NLIDS)?t.NLRequest.NLIDS.join(","):t.NLRequest.NLIDS}if(t.CDSRequest){if(a.CDSRequest={},!t.CDSRequest.dob)throw"Missing birthdate";t.CDSRequest.firstname&&(a.CDSRequest.firstname=t.CDSRequest.firstname),t.CDSRequest.name&&(a.CDSRequest.name=t.CDSRequest.name),a.CDSRequest.dob=t.CDSRequest.dob,a.CDSRequest.gender=t.CDSRequest.gender||2}return a.Email=t.Email,clearTimeout(r),r=setTimeout(function(){i.reject(n,"timeout","Newsletter service timed out.")},t.timeout),webmd.debug("service.unsubscribe settings: ",t),e.receiverUrl=webmd.url.addLifecycleAndEnv("https://www.webmd.com/xdm-oo"),n=e.call({service:"regapi/subscribe2",data:JSON.stringify(a)}).done(function(e){if("success"===e.stat){if(!webmd.cookie.exists("WBMD_AUTH")&&!webmd.cookie.exists("WBMD_SAUTH")){var t=webmd.object.get("subscriberKey",e);s.cookieSet(t),3===e.code&&(wmdPageLink("reg-success_l-nl"),webmd.debug("service.subscribe: New, light user registration"))}}else-52===e.code?i.reject(n,"readonly","Newsletter service is in readonly mode"):i.reject(n,"error","Newsletter service returned an error")}).fail(function(){webmd.debug("Service Failed!"),wmdPageLink("reg-error_l-nl")})},cookieSet:function(e){var t,i,n;t=new Date,t.setTime(t.getTime()+23328e6),i=";expires="+t.toUTCString(),n="WBMD_MB9",_dom=document.domain.split("."),c_domain=webmd.url.getSLD(),document.cookie=n+"="+e+"; path=/ ;domain="+c_domain+i},unsubscribe:function(e){var t,i,n,s,r;if(s=this,i=new $.Deferred,n=i.promise(),e=$.extend({timeout:s.timeout},e),e.nlids===void 0)throw"Missing newsletter id";if(!e.email)throw"Missing email address";return $.isArray(e.nlids)||(e.nlids=JSON.parse("["+e.nlids+"]")),t={nlids:e.nlids,email:e.email},clearTimeout(r),r=setTimeout(function(){i.reject(n,"timeout","Newsletter service timed out.")},e.timeout),webmd.debug("service.unsubscribe settings: ",e),$.ajax(s.urlUnsubscribe,{type:"post",data:JSON.stringify(t),contentType:"application/json",success:function(e){clearTimeout(r),i.resolve(e)},error:function(e,t,n){i.reject(e,t,n)}}),n},getPromo:function(e){var t,i,n,s;if(s=this,t={},i=new $.Deferred,n=i.promise(),e=$.extend({mobile:!1,timeout:s.timeout},e),e.cdsPromo){if(e.dob===void 0)throw"Missing Child date of birth"}else{if(e.id===void 0)throw"Missing newsletter id";$.isArray(e.id)||(e.id=[e.id]),t.nls=e.id.join(",")}return e.mobile&&(t.mobile=1),e.dob&&(t.dob=e.dob),$.ajax(s.urlGetPromo,{method:"get",data:t,success:function(e){function t(t){return webmd.object.get("d.data.nlAppMapping."+t,e)||""}var n,s,r;s=!1,n=t("appIdField"),-1==n&&(n="",s=!0),r={image:t("sourceIdField")+".png",url:t("retURLField"),description:t("valuePropField"),button:webmd.cookie.exists("WBMD_AUTH")&&s===!1?"Get Started":t("driverLanguageField"),appid:n,isMobile:s},r.url||(r={}),i.resolve(r)},error:function(e,t,n){i.reject(e,t,n)}}),n},gotoPromo:function(e){e.isMobile?window.location=e.url:require(["registration/1/regOverlay"],function(t){t.show({appid:e.appid,mode:"signup",returl:e.url,formValues:{email:e.email}})},function(){window.location=e.url})},addChild:function(t){var i,n={},s=this;if(t=$.extend({timeout:s.timeout},t),t.email===void 0&&!webmd.cookie.exists("WBMD_AUTH"))throw"Missing email address";if(!t.dob)throw"Missing birthdate";if(t.firstname&&(n.firstname=t.firstname),t.token&&(n.token=t.token),t.name&&(n.name=t.name),n.email=t.email,n.dob=t.dob,n.gender=t.gender||2,t.vendor&&(n.vendor=t.vendor),t.publisher&&(n.publisher=t.publisher),t.campaign&&(n.campaign=t.campaign),!t.privacy_policy_accept)throw"Privacy Policy must be accepted";return n.privacy_policy_accept=1,e.receiverUrl=webmd.url.addLifecycleAndEnv("https://www.webmd.com/xdm-oo"),i=e.call({service:"regapi/cds/addchild",data:JSON.stringify(n)}).done(function(e){if("success"===e.d.stat&&!webmd.cookie.exists("WBMD_AUTH")&&!webmd.cookie.exists("WBMD_SAUTH")){var t=webmd.object.get("subscriberKey",e.d);null!=t&&s.cookieSet(t)}}).fail(function(){webmd.debug("Service Failed!")})},updateChild:function(e){var t,i,n,s={},r=this;if(e=$.extend({timeout:r.timeout},e),!e.id||e.id===void 0)throw"id is required";if(!e.dob)throw"Missing birthdate";return e.name&&(s.name=e.name),e.gender&&(s.gender=e.gender),t=new $.Deferred,i=t.promise(),e=$.extend({timeout:r.timeout},e),clearTimeout(n),n=setTimeout(function(){t.reject(i,"timeout","Newsletter service timed out.")},e.timeout),s.id=e.id,s.dob=e.dob,e.token&&(s.token=e.token),$.ajax(r.urlUpdateChild,{type:"post",data:JSON.stringify(s),contentType:"application/json",success:function(e){clearTimeout(n),t.resolve(e)},error:function(e,i,n){t.reject(e,i,n)}}),i},deleteChild:function(e){var t,i,n,s={},r=this;if(e=$.extend({timeout:r.timeout},e),!e.id||e.id===void 0)throw"id is required";return e.token&&(s.token=e.token),s.id=e.id,t=new $.Deferred,i=t.promise(),e=$.extend({timeout:r.timeout},e),clearTimeout(n),n=setTimeout(function(){t.reject(i,"timeout","Newsletter service timed out.")},e.timeout),$.ajax(r.urlDeleteChild,{type:"post",data:JSON.stringify(s),contentType:"application/json",success:function(e){clearTimeout(n),t.resolve(e)},error:function(e,i,n){t.reject(e,i,n)}}),i},getChildren:function(e){var t,i;return t=this.urlGetChildren,e&&e.guid&&(t=t+"?token="+e.guid),i=$.getJSON(t)},getName:function(e){return this.names[e]||""}}});