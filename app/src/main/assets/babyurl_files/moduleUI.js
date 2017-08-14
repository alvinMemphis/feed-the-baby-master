/* repo: newsletter/HEAD@1.6.1-0-geea1451 - Package Version: 1.6.1 - 2017-07-24 03:29 pm - User:  */
define(["newsletter/1/service","input_label/1/input_label"],function(e){var t;return t={selector:"#moduleID",nl:36,promo:!0,template:{content:'<div class="nls-header">{header}</div>\n{preContent}<div class="nls-content">\n{preForm}<form class="nls-form" action="#" novalidate="novalidate">\n<div class="validationWrapper"><div class="checkbox-container clearfix">{inputs}</div></div>\n<div class="input-container">\n<div class="email-container validationWrapper">\n<input type="email" class="nls-email" name="email" autocapitalize="off" autocorrect="off" placeholder="Enter email address" /> <button name="nl-submit" formnovalidate class="off {submitClass}" type="submit"><span>Submit</span></button>\n<div class="clearfix"></div></div>\n</div>\n</form>\n<div class="privacy-disclaimer">By clicking Submit, I agree to the WebMD <a href="/about-webmd-policies/about-terms-and-conditions-of-use">Terms & Conditions</a> & <a href="/about-webmd-policies/about-privacy-policy">Privacy Policy</a> and understand that I may opt out of WebMD subscriptions at any time.</div>{postForm}</div>\n{postContent}',header:"<h2>Subscribe... <span>{title} Newsletter</span></h2>",headerMulti:"<h2>Subscribe <span>to WebMD Newsletters</span></h2>",inputSingle:'<input type="hidden" name="nls" value="{id}">',inputMulti:'<label><input type="checkbox" name="nls" class="multi-checkbox" value="{id}">{title}</label>',downtime:"<p>This feature is currently unavailable. The site is undergoing routine maintenance and will be back shortly.</p>",loading:'<div class="loading"><div class="loading_medium_png"><span>Loading...</span></div></div>',successHeader:"<h2>Thank You.</h2>",successMsg:'<p class="success"><span>{email}</span> is now subscribed.</p>',failure:'<div class="failure"><p>This feature is temporarily unavailable.</p><p>Please visit our <a href="{url}">Newsletter Preference Center</a> for all of our available subscription offerings.</p>',readonly:'<div class="failure"><p>This feature is temporarily unavailable.</p><p>Please try again later.</p>',promo:'<div class="promo"><div class="promo-content clearfix"><img src="{image}" alt="WebMD App" /><div class="promo-description"><p>{text}</p><p><a href="{url}" class="webmd-btn webmd-btn-pr webmd-btn-m" onclick="wmdTrack(\'nlupgrd_sub\')">{button}</a></p><div class="clearfix"></div></div></div></div>',promoMobile:'<a href="{url}" onclick="wmdTrack(\'nlupgrd_sub\')"><div class="promo"><div class="promo-content clearfix"><img src="{image}" alt="WebMD App" /><p>{text}</p></div></div></a>',submitClass:""},metricsModule:"nl-single",metricsModuleMultiple:"nl-multie",newsletterUrl:webmd.substitute("https://member{env}.webmd.com/newsletters/newsletters.aspx",{env:webmd.url.getEnv()}),init:function(e){var t;return t=this,e=e||{},$.extend(!0,t,e),t.el=$(t.selector),t.multiple=$.isArray(t.nl),t.buildModule(),t.vendor=webmd.url.getParam("vendor")||"",t.publisher=webmd.url.getParam("publisher")||"",t.campaign=webmd.url.getParam("campaign")||"",webmd.isDown("reg")?(t.showDowntime(),void 0):(t.initEvents(),void 0)},buildModule:function(){var e,t,i,n,s;s=this,t=s.el,n="",s.multiple?(i=s.template.headerMulti,$.each(s.nl,function(e,t){n+=webmd.substitute(s.template.inputMulti,{id:s.getNewsletterId(t),title:s.getNewsletterTitle(t)},!0)})):(i=webmd.substitute(s.template.header,{title:s.getNewsletterTitle(s.nl)},!0),n=webmd.substitute(s.template.inputSingle,{id:s.getNewsletterId(s.nl),title:s.getNewsletterTitle(s.nl)},!0)),e=webmd.substitute(s.template.content,{header:i,inputs:n,preForm:s.template.preForm,postForm:s.template.postForm,preContent:s.template.preContent,postContent:s.template.postContent,submitClass:s.template.submitClass},!0),t.addClass("nls-module").html(e),s.dom={heading:t.find(".nls-header"),content:t.find(".nls-content"),form:t.find(".nls-form"),inputContainer:t.find(".input-container"),privacyDisclaimer:t.find(".privacy-disclaimer"),checkboxContainer:t.find(".checkbox-container"),inputEmail:t.find("input[name=email]"),inputNlId:t.find("input[type=hidden][name=nls]"),inputCheckboxes:t.find("input:checkbox[name=nls]"),button:t.find("button[name=nl-submit]")},s.resize()},initEvents:function(){var e;e=this,e.dom.form.on("submit",function(t){t.preventDefault(),e.submit()}),e.dom.inputEmail.one("focus",function(){e.showPrivacyDisclaimer()}),e.dom.inputEmail.on("blur",function(){return setTimeout(function(){e.validateEmail()},200),!0}),e.dom.inputCheckboxes.on("change",function(){e.validateNewsletter()}),e.dom.inputEmail.webmdInputLabel({label:e.dom.inputEmail.attr("placeholder")})},validate:function(){var e,t;return t=this,e=t.validateEmail(),e=t.validateNewsletter()&&e},validatePrivacy:function(){return this.dom.inputPrivacy.is(":checked")?(this.validationMessage(this.dom.inputPrivacy),!0):(this.validationMessage(this.dom.inputPrivacy,"Please acknowledge your agreement"),!1)},validateEmail:function(){var e,t;return e=this.dom.inputEmail.val(),t=/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,0===e.length?(this.validationMessage(this.dom.inputEmail,"Please enter your email address"),!1):!t.test(e)||this.dom.inputEmail.webmdInputLabel("isLabel")?(this.validationMessage(this.dom.inputEmail,"Enter a valid email address"),!1):(this.validationMessage(this.dom.inputEmail),!0)},validateNewsletter:function(){if(this.multiple){if(0===this.getSelectedNewsletters().length)return this.validationMessage(this.dom.checkboxContainer,"Please select a newsletter"),!1;this.validationMessage(this.dom.checkboxContainer)}return!0},stylePrivacyCheckbox:function(){this.dom.inputPrivacyLabel.toggleClass("checked",this.dom.inputPrivacy.is(":checked"))},submit:function(){var t,i,n;n=this,n.validate()&&(t=n.dom.inputEmail.val(),n.email=t,i=n.getSelectedNewsletters(),n.dom.content.html(n.template.loading),e.subscribe({email:t,privacy:!0,vendor:n.vendor,publisher:n.publisher,campaign:n.campaign,id:i}).done(function(e){var s;n.multiple?(s=n.metricsModuleMultiple,s+="_"+i.length+"-"+n.nl.length,wmdPageLink(s)):wmdPageLink(n.metricsModule),n.usertype=webmd.object.get("d.usertype",e),n.el.removeClass("error").addClass("confirmed"),n.dom.privacyDisclaimer.hide(),n.dom.heading.html(n.template.successHeader),n.dom.content.html(webmd.substitute(n.template.successMsg,{email:t})),n.resize(),n.promo&&n.buildPromo()}).fail(function(e,t){"readonly"===t?n.dom.content.html(n.template.readonly):n.dom.content.html(webmd.substitute(n.template.failure,{url:n.newsletterUrl})),n.resize()}))},buildPromo:function(){var t,i;t=this,i=Boolean(-1!=location.href.indexOf(".m.")),e.getPromo({id:t.getSelectedNewsletters(!0),mobile:i}).done(function(n){var s,r,a;if(!n.url){if(i||"Full"===t.usertype)return webmd.debug("No promo available."),!1;n=e.promoDefault}i?(a=t.template.promoMobile,s=e.urlGetPromoImg+"hd_"+n.image):(a=t.template.promo,s=e.urlGetPromoImg+n.image),r=webmd.substitute(a,{url:n.url,image:s,text:n.description,button:n.button}),n.email=t.email,"Light"===t.usertype&&(r=$(r).on("click","a",function(){return e.gotoPromo(n),!1})),t.dom.content.append(r),t.resize()}).fail(function(){webmd.debug("Promo build failed.")})},showDowntime:function(){var e;webmd.debug("Registration is down."),e=this,e.dom.content.addClass("downtime").html(e.template.downtime),e.resize()},showPrivacyDisclaimer:function(){this.dom.privacyDisclaimer.show()},resizeEvent:"newsletterResize",resize:function(){this.el.trigger(this.resizeEvent)},getNewsletterTitle:function(t){var i;return i=$.isPlainObject(t)?t.title||e.getName(t.id):e.getName(t),i||"Newsletter"},getNewsletterId:function(e){return $.isPlainObject(e)?e.id||"":e||""},getSelectedNewsletters:function(e){var t;return e&&this.selectedCache?this.selectedCache:(t=[],this.dom.inputCheckboxes.filter(":checked").each(function(){t.push($(this).val())}),this.dom.inputNlId.length&&t.push(this.dom.inputNlId.val()),this.selectedCache=t,t)},validationMessage:function(e,t){var i,n,s;i={wrapper:"validationWrapper",msg:"validationMessage",content:"validationMessageContent",error:"validationError"},s=$(e).closest("."+i.wrapper),0!==s.length&&(n=s.find("."+i.msg),t?(s.addClass(i.error),0===n.length&&(n=$('<div class="'+i.msg+'">'+'<div class="'+i.content+'"></div>'+"</div>").appendTo(s)),n.find("."+i.content).html(t),n.show()):(s.removeClass(i.error),n.hide()),this.resize())}}});