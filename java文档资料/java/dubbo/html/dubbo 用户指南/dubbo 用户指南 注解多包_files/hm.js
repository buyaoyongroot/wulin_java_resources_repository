(function(){var h={},mt={},c={id:"d86954201130d615136257dde062a503",dm:["360doc.com"],js:"tongji.baidu.com/hm-web/js/",etrk:[],icon:'',ctrk:true,align:1,nv:-1,vdur:1800000,age:31536000000,rec:1,rp:[[95775, 2],[99342, 2]],trust:0,vcard:0,qiao:0,lxb:0,conv:0,med:0,cvcc:'',cvcf:[],apps:''};var q=void 0,r=!0,s=null,w=!1;mt.j={};mt.j.M=/msie (\d+\.\d+)/i.test(navigator.userAgent);mt.j.Ja=/msie (\d+\.\d+)/i.test(navigator.userAgent)?document.documentMode||+RegExp.$1:q;mt.j.cookieEnabled=navigator.cookieEnabled;mt.j.javaEnabled=navigator.javaEnabled();mt.j.language=navigator.language||navigator.browserLanguage||navigator.systemLanguage||navigator.userLanguage||"";mt.j.Oa=(window.screen.width||0)+"x"+(window.screen.height||0);mt.j.colorDepth=window.screen.colorDepth||0;mt.cookie={};
mt.cookie.set=function(a,b,f){var d;f.J&&(d=new Date,d.setTime(d.getTime()+f.J));document.cookie=a+"="+b+(f.domain?"; domain="+f.domain:"")+(f.path?"; path="+f.path:"")+(d?"; expires="+d.toGMTString():"")+(f.eb?"; secure":"")};mt.cookie.get=function(a){return(a=RegExp("(^| )"+a+"=([^;]*)(;|$)").exec(document.cookie))?a[2]:s};mt.p={};mt.p.W=function(a){return document.getElementById(a)};mt.p.ua=function(a){var b;for(b="A";(a=a.parentNode)&&1==a.nodeType;)if(a.tagName==b)return a;return s};
(mt.p.Q=function(){function a(){if(!a.D){a.D=r;for(var b=0,e=d.length;b<e;b++)d[b]()}}function b(){try{document.documentElement.doScroll("left")}catch(d){setTimeout(b,1);return}a()}var f=w,d=[],e;document.addEventListener?e=function(){document.removeEventListener("DOMContentLoaded",e,w);a()}:document.attachEvent&&(e=function(){"complete"===document.readyState&&(document.detachEvent("onreadystatechange",e),a())});(function(){if(!f)if(f=r,"complete"===document.readyState)a.D=r;else if(document.addEventListener)document.addEventListener("DOMContentLoaded",
e,w),window.addEventListener("load",a,w);else if(document.attachEvent){document.attachEvent("onreadystatechange",e);window.attachEvent("onload",a);var d=w;try{d=window.frameElement==s}catch(m){}document.documentElement.doScroll&&d&&b()}})();return function(b){a.D?b():d.push(b)}}()).D=w;mt.event={};mt.event.c=function(a,b,f){a.attachEvent?a.attachEvent("on"+b,function(d){f.call(a,d)}):a.addEventListener&&a.addEventListener(b,f,w)};
mt.event.preventDefault=function(a){a.preventDefault?a.preventDefault():a.returnValue=w};mt.l={};mt.l.parse=function(){return(new Function('return (" + source + ")'))()};
mt.l.stringify=function(){function a(a){/["\\\x00-\x1f]/.test(a)&&(a=a.replace(/["\\\x00-\x1f]/g,function(a){var d=f[a];if(d)return d;d=a.charCodeAt();return"\\u00"+Math.floor(d/16).toString(16)+(d%16).toString(16)}));return'"'+a+'"'}function b(a){return 10>a?"0"+a:a}var f={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"};return function(d){switch(typeof d){case "undefined":return"undefined";case "number":return isFinite(d)?String(d):"null";case "string":return a(d);case "boolean":return String(d);
default:if(d===s)return"null";if(d instanceof Array){var e=["["],f=d.length,m,g,k;for(g=0;g<f;g++)switch(k=d[g],typeof k){case "undefined":case "function":case "unknown":break;default:m&&e.push(","),e.push(mt.l.stringify(k)),m=1}e.push("]");return e.join("")}if(d instanceof Date)return'"'+d.getFullYear()+"-"+b(d.getMonth()+1)+"-"+b(d.getDate())+"T"+b(d.getHours())+":"+b(d.getMinutes())+":"+b(d.getSeconds())+'"';m=["{"];g=mt.l.stringify;for(f in d)if(Object.prototype.hasOwnProperty.call(d,f))switch(k=
d[f],typeof k){case "undefined":case "unknown":case "function":break;default:e&&m.push(","),e=1,m.push(g(f)+":"+g(k))}m.push("}");return m.join("")}}}();mt.lang={};mt.lang.d=function(a,b){return"[object "+b+"]"==={}.toString.call(a)};mt.lang.ab=function(a){return mt.lang.d(a,"Number")&&isFinite(a)};mt.lang.cb=function(a){return mt.lang.d(a,"String")};mt.localStorage={};
mt.localStorage.H=function(){if(!mt.localStorage.g)try{mt.localStorage.g=document.createElement("input"),mt.localStorage.g.type="hidden",mt.localStorage.g.style.display="none",mt.localStorage.g.addBehavior("#default#userData"),document.getElementsByTagName("head")[0].appendChild(mt.localStorage.g)}catch(a){return w}return r};
mt.localStorage.set=function(a,b,f){var d=new Date;d.setTime(d.getTime()+f||31536E6);try{window.localStorage?(b=d.getTime()+"|"+b,window.localStorage.setItem(a,b)):mt.localStorage.H()&&(mt.localStorage.g.expires=d.toUTCString(),mt.localStorage.g.load(document.location.hostname),mt.localStorage.g.setAttribute(a,b),mt.localStorage.g.save(document.location.hostname))}catch(e){}};
mt.localStorage.get=function(a){if(window.localStorage){if(a=window.localStorage.getItem(a)){var b=a.indexOf("|"),f=a.substring(0,b)-0;if(f&&f>(new Date).getTime())return a.substring(b+1)}}else if(mt.localStorage.H())try{return mt.localStorage.g.load(document.location.hostname),mt.localStorage.g.getAttribute(a)}catch(d){}return s};
mt.localStorage.remove=function(a){if(window.localStorage)window.localStorage.removeItem(a);else if(mt.localStorage.H())try{mt.localStorage.g.load(document.location.hostname),mt.localStorage.g.removeAttribute(a),mt.localStorage.g.save(document.location.hostname)}catch(b){}};mt.sessionStorage={};mt.sessionStorage.set=function(a,b){if(window.sessionStorage)try{window.sessionStorage.setItem(a,b)}catch(f){}};
mt.sessionStorage.get=function(a){return window.sessionStorage?window.sessionStorage.getItem(a):s};mt.sessionStorage.remove=function(a){window.sessionStorage&&window.sessionStorage.removeItem(a)};mt.S={};mt.S.log=function(a,b){var f=new Image,d="mini_tangram_log_"+Math.floor(2147483648*Math.random()).toString(36);window[d]=f;f.onload=f.onerror=f.onabort=function(){f.onload=f.onerror=f.onabort=s;f=window[d]=s;b&&b(a)};f.src=a};mt.T={};
mt.T.Ca=function(){var a="";if(navigator.plugins&&navigator.mimeTypes.length){var b=navigator.plugins["Shockwave Flash"];b&&b.description&&(a=b.description.replace(/^.*\s+(\S+)\s+\S+$/,"$1"))}else if(window.ActiveXObject)try{if(b=new ActiveXObject("ShockwaveFlash.ShockwaveFlash"))(a=b.GetVariable("$version"))&&(a=a.replace(/^.*\s+(\d+),(\d+).*$/,"$1.$2"))}catch(f){}return a};
mt.T.Wa=function(a,b,f,d,e){return'<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id="'+a+'" width="'+f+'" height="'+d+'"><param name="movie" value="'+b+'" /><param name="flashvars" value="'+(e||"")+'" /><param name="allowscriptaccess" value="always" /><embed type="application/x-shockwave-flash" name="'+a+'" width="'+f+'" height="'+d+'" src="'+b+'" flashvars="'+(e||"")+'" allowscriptaccess="always" /></object>'};mt.url={};
mt.url.k=function(a,b){var f=a.match(RegExp("(^|&|\\?|#)("+b+")=([^&#]*)(&|$|#)",""));return f?f[3]:s};mt.url.Za=function(a){return(a=a.match(/^(https?:)\/\//))?a[1]:s};mt.url.ya=function(a){return(a=a.match(/^(https?:\/\/)?([^\/\?#]*)/))?a[2].replace(/.*@/,""):s};mt.url.Y=function(a){return(a=mt.url.ya(a))?a.replace(/:\d+$/,""):a};mt.url.Ya=function(a){return(a=a.match(/^(https?:\/\/)?[^\/]*(.*)/))?a[2].replace(/[\?#].*/,"").replace(/^$/,"/"):s};
h.o={$a:"http://tongji.baidu.com/hm-web/welcome/ico",P:"hm.baidu.com/hm.gif",ha:"baidu.com",Ga:"hmmd",Ha:"hmpl",Fa:"hmkw",Da:"hmci",Ia:"hmsr",Ea:"hmcu",z:0,m:Math.round(+new Date/1E3),protocol:"https:"===document.location.protocol?"https:":"http:",bb:0,na:6E5,oa:10,U:1024,ma:1,s:2147483647,da:"cc cf ci ck cl cm cp cu cw ds ep et fl ja ln lo lt nv rnd si st su v cv lv api u tt".split(" ")};
(function(){var a={r:{},c:function(a,f){this.r[a]=this.r[a]||[];this.r[a].push(f)},B:function(a,f){this.r[a]=this.r[a]||[];for(var d=this.r[a].length,e=0;e<d;e++)this.r[a][e](f)}};return h.w=a})();
(function(){function a(a,d){var e=document.createElement("script");e.charset="utf-8";b.d(d,"Function")&&(e.readyState?e.onreadystatechange=function(){if("loaded"===e.readyState||"complete"===e.readyState)e.onreadystatechange=s,d()}:e.onload=function(){d()});e.src=a;var l=document.getElementsByTagName("script")[0];l.parentNode.insertBefore(e,l)}var b=mt.lang;return h.load=a})();
(function(){function a(){var a="";h.b.a.nv?(a=encodeURIComponent(document.referrer),window.sessionStorage?f.set("Hm_from_"+c.id,a):b.set("Hm_from_"+c.id,a,864E5)):a=(window.sessionStorage?f.get("Hm_from_"+c.id):b.get("Hm_from_"+c.id))||"";return a}var b=mt.localStorage,f=mt.sessionStorage;return h.V=a})();
(function(){var a=mt.p,b=mt.event,f=mt.j,d=h.o,e=[],l={ea:function(){c.ctrk&&(b.c(document,"mouseup",l.la()),b.c(window,"unload",function(){l.F()}),setInterval(function(){l.F()},d.na))},la:function(){return function(a){a=l.va(a);if(""!==a){var b=(d.protocol+"//"+d.P+"?"+h.b.ca().replace(/ep=[^&]*/,"ep="+encodeURIComponent("["+a+"]"))).length;b+(d.s+"").length>d.U||(b+encodeURIComponent(e.join(",")+(e.length?",":"")).length+(d.s+"").length>d.U&&l.F(),e.push(a),(e.length>=d.oa||/t:a/.test(a))&&l.F())}}},
va:function(b){if(0===d.ma){var e=b.target||b.srcElement,k=e.tagName.toLowerCase();if("embed"==k||"object"==k)return""}f.M?(e=Math.max(document.documentElement.scrollTop,document.body.scrollTop),k=Math.max(document.documentElement.scrollLeft,document.body.scrollLeft),k=b.clientX+k,e=b.clientY+e):(k=b.pageX,e=b.pageY);var n=window.innerWidth||document.documentElement.clientWidth||document.body.offsetWidth;switch(c.align){case 1:k-=n/2;break;case 2:k-=n}k="{x:"+k+",y:"+e+",";e=b.target||b.srcElement;
return k=(b="a"==e.tagName.toLowerCase()?e:a.ua(e))?k+("t:a,u:"+encodeURIComponent(b.href)+"}"):k+"t:b}"},F:function(){0!==e.length&&(h.b.a.et=2,h.b.a.ep="["+e.join(",")+"]",h.b.i(),e=[])}};h.w.c("pv-b",l.ea);return l})();
(function(){var a=mt.p,b=h.o,f=h.load,d=h.V;h.w.c("pv-b",function(){c.rec&&a.Q(function(){for(var e=0,l=c.rp.length;e<l;e++){var m=c.rp[e][0],g=c.rp[e][1],k=a.W("hm_t_"+m);if(g&&!(2==g&&!k||k&&""!==k.innerHTML))k="",k=Math.round(Math.random()*b.s),k=4==g?"http://crs.baidu.com/hl.js?"+["siteId="+c.id,"planId="+m,"rnd="+k].join("&"):"http://crs.baidu.com/t.js?"+["siteId="+c.id,"planId="+m,"from="+d(),"referer="+encodeURIComponent(document.referrer),"title="+encodeURIComponent(document.title),"rnd="+
k].join("&"),f(k)}})})})();(function(){var a=h.o,b=h.load,f=h.V;h.w.c("pv-b",function(){if(c.trust&&c.vcard){var d=a.protocol+"//trust.baidu.com/vcard/v.js?"+["siteid="+c.vcard,"url="+encodeURIComponent(document.location.href),"source="+f(),"rnd="+Math.round(Math.random()*a.s),"hm=1"].join("&");b(d)}})})();
(function(){function a(){return function(){h.b.a.nv=0;h.b.a.st=4;h.b.a.et=3;h.b.a.ep=h.I.Aa()+","+h.I.xa();h.b.i()}}function b(){clearTimeout(y);var a;x&&(a="visible"==document[x]);z&&(a=!document[z]);g="undefined"==typeof a?r:a;if((!m||!k)&&g&&n)u=r,p=+new Date;else if(m&&k&&(!g||!n))u=w,t+=+new Date-p;m=g;k=n;y=setTimeout(b,100)}function f(a){var k=document,p="";if(a in k)p=a;else for(var b=["webkit","ms","moz","o"],e=0;e<b.length;e++){var d=b[e]+a.charAt(0).toUpperCase()+a.slice(1);if(d in k){p=
d;break}}return p}function d(a){if(!("focus"==a.type||"blur"==a.type)||!(a.target&&a.target!=window))n="focus"==a.type||"focusin"==a.type?r:w,b()}var e=mt.event,l=h.w,m=r,g=r,k=r,n=r,v=+new Date,p=v,t=0,u=r,x=f("visibilityState"),z=f("hidden"),y;b();(function(){var a=x.replace(/[vV]isibilityState/,"visibilitychange");e.c(document,a,b);e.c(window,"pageshow",b);e.c(window,"pagehide",b);"object"==typeof document.onfocusin?(e.c(document,"focusin",d),e.c(document,"focusout",d)):(e.c(window,"focus",d),
e.c(window,"blur",d))})();h.I={Aa:function(){return+new Date-v},xa:function(){return u?+new Date-p+t:t}};l.c("pv-b",function(){e.c(window,"unload",a())});return h.I})();
(function(){var a=mt.lang,b=h.o,f=h.load,d={Ka:function(e){if((window._dxt===q||a.d(window._dxt,"Array"))&&"undefined"!==typeof h.b){var d=h.b.K();f([b.protocol,"//datax.baidu.com/x.js?si=",c.id,"&dm=",encodeURIComponent(d)].join(""),e)}},Ua:function(b){if(a.d(b,"String")||a.d(b,"Number"))window._dxt=window._dxt||[],window._dxt.push(["_setUserId",b])}};return h.pa=d})();
(function(){function a(k){for(var b in k)if({}.hasOwnProperty.call(k,b)){var d=k[b];f.d(d,"Object")||f.d(d,"Array")?a(d):k[b]=String(d)}}function b(a){return a.replace?a.replace(/'/g,"'0").replace(/\*/g,"'1").replace(/!/g,"'2"):a}var f=mt.lang,d=mt.l,e=h.o,l=h.w,m=h.pa,g={A:[],G:0,aa:w,init:function(){g.e=0;l.c("pv-b",function(){g.qa();g.sa()});l.c("pv-d",g.ta);l.c("stag-b",function(){h.b.a.api=g.e||g.G?g.e+"_"+g.G:""});l.c("stag-d",function(){h.b.a.api=0;g.e=0;g.G=0})},qa:function(){var a=window._hmt||
[];if(!a||f.d(a,"Array"))window._hmt={id:c.id,cmd:{},push:function(){for(var a=window._hmt,k=0;k<arguments.length;k++){var p=arguments[k];f.d(p,"Array")&&(a.cmd[a.id].push(p),"_setAccount"===p[0]&&(1<p.length&&/^[0-9a-f]{32}$/.test(p[1]))&&(p=p[1],a.id=p,a.cmd[p]=a.cmd[p]||[]))}}},window._hmt.cmd[c.id]=[],window._hmt.push.apply(window._hmt,a)},sa:function(){var a=window._hmt;if(a&&a.cmd&&a.cmd[c.id])for(var b=a.cmd[c.id],d=/^_track(Event|MobConv|Order|RTEvent)$/,p=0,e=b.length;p<e;p++){var f=b[p];
d.test(f[0])?g.A.push(f):g.O(f)}a.cmd[c.id]={push:g.O}},ta:function(){if(0<g.A.length)for(var a=0,b=g.A.length;a<b;a++)g.O(g.A[a]);g.A=s},O:function(a){var b=a[0];if(g.hasOwnProperty(b)&&f.d(g[b],"Function"))g[b](a)},_setAccount:function(a){1<a.length&&/^[0-9a-f]{32}$/.test(a[1])&&(g.e|=1)},_setAutoPageview:function(a){if(1<a.length&&(a=a[1],w===a||r===a))g.e|=2,h.b.Z=a},_trackPageview:function(a){if(1<a.length&&a[1].charAt&&"/"===a[1].charAt(0)){g.e|=4;h.b.a.et=0;h.b.a.ep="";h.b.L?(h.b.a.nv=0,h.b.a.st=
4):h.b.L=r;var b=h.b.a.u,d=h.b.a.su;h.b.a.u=e.protocol+"//"+document.location.host+a[1];g.aa||(h.b.a.su=document.location.href);h.b.i();h.b.a.u=b;h.b.a.su=d}},_trackEvent:function(a){2<a.length&&(g.e|=8,h.b.a.nv=0,h.b.a.st=4,h.b.a.et=4,h.b.a.ep=b(a[1])+"*"+b(a[2])+(a[3]?"*"+b(a[3]):"")+(a[4]?"*"+b(a[4]):""),h.b.i())},_setCustomVar:function(a){if(!(4>a.length)){var d=a[1],e=a[4]||3;if(0<d&&6>d&&0<e&&4>e){g.G++;for(var p=(h.b.a.cv||"*").split("!"),f=p.length;f<d-1;f++)p.push("*");p[d-1]=e+"*"+b(a[2])+
"*"+b(a[3]);h.b.a.cv=p.join("!");a=h.b.a.cv.replace(/[^1](\*[^!]*){2}/g,"*").replace(/((^|!)\*)+$/g,"");""!==a?h.b.setData("Hm_cv_"+c.id,encodeURIComponent(a),c.age):h.b.Na("Hm_cv_"+c.id)}}},_setReferrerOverride:function(a){1<a.length&&(h.b.a.su=a[1].charAt&&"/"===a[1].charAt(0)?e.protocol+"//"+window.location.host+a[1]:a[1],g.aa=r)},_trackOrder:function(b){b=b[1];f.d(b,"Object")&&(a(b),g.e|=16,h.b.a.nv=0,h.b.a.st=4,h.b.a.et=94,h.b.a.ep=d.stringify(b),h.b.i())},_trackMobConv:function(a){if(a={webim:1,
tel:2,map:3,sms:4,callback:5,share:6}[a[1]])g.e|=32,h.b.a.et=93,h.b.a.ep=a,h.b.i()},_trackRTPageview:function(b){b=b[1];f.d(b,"Object")&&(a(b),b=d.stringify(b),512>=encodeURIComponent(b).length&&(g.e|=64,h.b.a.rt=b))},_trackRTEvent:function(b){b=b[1];if(f.d(b,"Object")){a(b);b=encodeURIComponent(d.stringify(b));var l=function(a){var b=h.b.a.rt;g.e|=128;h.b.a.et=90;h.b.a.rt=a;h.b.i();h.b.a.rt=b},m=b.length;if(900>=m)l.call(this,b);else for(var m=Math.ceil(m/900),p="block|"+Math.round(Math.random()*
e.s).toString(16)+"|"+m+"|",t=[],u=0;u<m;u++)t.push(u),t.push(b.substring(900*u,900*u+900)),l.call(this,p+t.join("|")),t=[]}},_setUserId:function(a){a=a[1];m.Ka();m.Ua(a)}};g.init();h.ia=g;return h.ia})();
(function(){function a(){"undefined"===typeof window["_bdhm_loaded_"+c.id]&&(window["_bdhm_loaded_"+c.id]=r,this.a={},this.Z=r,this.L=w,this.init())}var b=mt.url,f=mt.S,d=mt.T,e=mt.lang,l=mt.cookie,m=mt.j,g=mt.localStorage,k=mt.sessionStorage,n=h.o,v=h.w;a.prototype={N:function(a,b){a="."+a.replace(/:\d+/,"");b="."+b.replace(/:\d+/,"");var d=a.indexOf(b);return-1<d&&d+b.length===a.length},ba:function(a,b){a=a.replace(/^https?:\/\//,"");return 0===a.indexOf(b)},C:function(a){for(var d=0;d<c.dm.length;d++)if(-1<
c.dm[d].indexOf("/")){if(this.ba(a,c.dm[d]))return r}else{var e=b.Y(a);if(e&&this.N(e,c.dm[d]))return r}return w},K:function(){for(var a=document.location.hostname,b=0,d=c.dm.length;b<d;b++)if(this.N(a,c.dm[b]))return c.dm[b].replace(/(:\d+)?[\/\?#].*/,"");return a},X:function(){for(var a=0,b=c.dm.length;a<b;a++){var d=c.dm[a];if(-1<d.indexOf("/")&&this.ba(document.location.href,d))return d.replace(/^[^\/]+(\/.*)/,"$1")+"/"}return"/"},Ba:function(){if(!document.referrer)return n.m-n.z>c.vdur?1:4;
var a=w;this.C(document.referrer)&&this.C(document.location.href)?a=r:(a=b.Y(document.referrer),a=this.N(a||"",document.location.hostname));return a?n.m-n.z>c.vdur?1:4:3},getData:function(a){try{return l.get(a)||k.get(a)||g.get(a)}catch(b){}},setData:function(a,b,d){try{l.set(a,b,{domain:this.K(),path:this.X(),J:d}),d?g.set(a,b,d):k.set(a,b)}catch(e){}},Na:function(a){try{l.set(a,"",{domain:this.K(),path:this.X(),J:-1}),k.remove(a),g.remove(a)}catch(b){}},Sa:function(){var a,b,d,e,f;n.z=this.getData("Hm_lpvt_"+
c.id)||0;13===n.z.length&&(n.z=Math.round(n.z/1E3));b=this.Ba();a=4!==b?1:0;if(d=this.getData("Hm_lvt_"+c.id)){e=d.split(",");for(f=e.length-1;0<=f;f--)13===e[f].length&&(e[f]=""+Math.round(e[f]/1E3));for(;2592E3<n.m-e[0];)e.shift();f=4>e.length?2:3;for(1===a&&e.push(n.m);4<e.length;)e.shift();d=e.join(",");e=e[e.length-1]}else d=n.m,e="",f=1;this.setData("Hm_lvt_"+c.id,d,c.age);this.setData("Hm_lpvt_"+c.id,n.m);d=n.m===this.getData("Hm_lpvt_"+c.id)?"1":"0";if(0===c.nv&&this.C(document.location.href)&&
(""===document.referrer||this.C(document.referrer)))a=0,b=4;this.a.nv=a;this.a.st=b;this.a.cc=d;this.a.lt=e;this.a.lv=f},ca:function(){for(var a=[],b=this.a.et,d=0,e=n.da.length;d<e;d++){var f=n.da[d],g=this.a[f];"undefined"!==typeof g&&""!==g&&("tt"!==f||"tt"===f&&0===b)&&a.push(f+"="+encodeURIComponent(g))}this.a.rt&&(0===b?a.push("rt="+encodeURIComponent(this.a.rt)):90===b&&a.push("rt="+this.a.rt));return a.join("&")},Ta:function(){this.Sa();this.a.si=c.id;this.a.su=document.referrer;this.a.ds=
m.Oa;this.a.cl=m.colorDepth+"-bit";this.a.ln=m.language;this.a.ja=m.javaEnabled?1:0;this.a.ck=m.cookieEnabled?1:0;this.a.lo="number"===typeof _bdhm_top?1:0;this.a.fl=d.Ca();this.a.v="1.1.26";this.a.cv=decodeURIComponent(this.getData("Hm_cv_"+c.id)||"");this.a.tt=document.title||"";var a=document.location.href;this.a.cm=b.k(a,n.Ga)||"";this.a.cp=b.k(a,n.Ha)||"";this.a.cw=b.k(a,n.Fa)||"";this.a.ci=b.k(a,n.Da)||"";this.a.cf=b.k(a,n.Ia)||"";this.a.cu=b.k(a,n.Ea)||""},init:function(){try{this.Ta(),0===
this.a.nv?this.Qa():this.R(".*"),h.b=this,this.ka(),v.B("pv-b"),this.Pa()}catch(a){var b=[];b.push("si="+c.id);b.push("n="+encodeURIComponent(a.name));b.push("m="+encodeURIComponent(a.message));b.push("r="+encodeURIComponent(document.referrer));f.log(n.protocol+"//"+n.P+"?"+b.join("&"))}},Pa:function(){function a(){v.B("pv-d")}this.Z?(this.L=r,this.a.et=0,this.a.ep="",this.i(a)):a()},i:function(a){var b=this;b.a.rnd=Math.round(Math.random()*n.s);v.B("stag-b");var d=n.protocol+"//"+n.P+"?"+b.ca();
v.B("stag-d");b.ga(d);f.log(d,function(d){b.R(d);e.d(a,"Function")&&a.call(b)})},ka:function(){var a=document.location.hash.substring(1),d=RegExp(c.id),e=-1<document.referrer.indexOf(n.ha),f=b.k(a,"jn"),g=/^heatlink$|^select$/.test(f);a&&(d.test(a)&&e&&g)&&(this.a.rnd=Math.round(Math.random()*n.s),a=document.createElement("script"),a.setAttribute("type","text/javascript"),a.setAttribute("charset","utf-8"),a.setAttribute("src",n.protocol+"//"+c.js+f+".js?"+this.a.rnd),f=document.getElementsByTagName("script")[0],
f.parentNode.insertBefore(a,f))},ga:function(a){var b=k.get("Hm_unsent_"+c.id)||"",d=this.a.u?"":"&u="+encodeURIComponent(document.location.href),b=encodeURIComponent(a.replace(/^https?:\/\//,"")+d)+(b?","+b:"");k.set("Hm_unsent_"+c.id,b)},R:function(a){var b=k.get("Hm_unsent_"+c.id)||"";b&&(a=encodeURIComponent(a.replace(/^https?:\/\//,"")),a=RegExp(a.replace(/([\*\(\)])/g,"\\$1")+"(%26u%3D[^,]*)?,?","g"),(b=b.replace(a,"").replace(/,$/,""))?k.set("Hm_unsent_"+c.id,b):k.remove("Hm_unsent_"+c.id))},
Qa:function(){var a=this,b=k.get("Hm_unsent_"+c.id);if(b)for(var b=b.split(","),d=function(b){f.log(n.protocol+"//"+decodeURIComponent(b),function(b){a.R(b)})},e=0,g=b.length;e<g;e++)d(b[e])}};return new a})();
(function(){var a=mt.p,b=mt.event,f=mt.url,d=mt.l;try{if(window.performance&&performance.timing&&"undefined"!==typeof h.b){var e=+new Date,l=function(a){var b=performance.timing,d=b[a+"Start"]?b[a+"Start"]:0;a=b[a+"End"]?b[a+"End"]:0;return{start:d,end:a,value:0<a-d?a-d:0}},m=s;a.Q(function(){m=+new Date});var g=function(){var a,b,g;g=l("navigation");b=l("request");g={netAll:b.start-g.start,netDns:l("domainLookup").value,netTcp:l("connect").value,srv:l("response").start-b.start,dom:performance.timing.domInteractive-
performance.timing.fetchStart,loadEvent:l("loadEvent").end-g.start};a=document.referrer;var k=a.match(/^(http[s]?:\/\/)?([^\/]+)(.*)/)||[],u=s;b=s;if("www.baidu.com"===k[2]||"m.baidu.com"===k[2])u=f.k(a,"qid"),b=f.k(a,"click_t");a=u;g.qid=a!=s?a:"";b!=s?(g.bdDom=m?m-b:0,g.bdRun=e-b,g.bdDef=l("navigation").start-b):(g.bdDom=0,g.bdRun=0,g.bdDef=0);h.b.a.et=87;h.b.a.ep=d.stringify(g);h.b.i()};b.c(window,"load",function(){setTimeout(g,500)})}}catch(k){}})();
(function(){var a=h.o,b={init:function(){try{if("http:"===a.protocol){var b=document.createElement("IFRAME");b.setAttribute("src","http://boscdn.bpc.baidu.com/v1/holmes-moplus/mp-cdn.html");b.style.display="none";b.style.width="1";b.style.height="1";b.Xa="0";document.body.appendChild(b)}}catch(e){}}},f=navigator.userAgent.toLowerCase();-1<f.indexOf("android")&&-1===f.indexOf("micromessenger")&&b.init()})();
(function(){var a=mt.j,b=mt.lang,f=mt.event,d=mt.l;if("undefined"!==typeof h.b&&(c.med||(!a.M||7<a.Ja)&&c.cvcc)){var e,l,m,g,k=function(a){if(a.item){for(var b=a.length,d=Array(b);b--;)d[b]=a[b];return d}return[].slice.call(a)},n=function(a,b){for(var d in a)if(a.hasOwnProperty(d)&&b.call(a,d,a[d])===w)return w},v=function(a,f){var g={};g.n=e;g.t="clk";g.v=a;if(f){var k=f.getAttribute("href"),l=f.getAttribute("onclick")?""+f.getAttribute("onclick"):s,n=f.getAttribute("id")||"";m.test(k)?(g.sn="mediate",
g.snv=k):b.d(l,"String")&&m.test(l)&&(g.sn="wrap",g.snv=l);g.id=n}h.b.a.et=86;h.b.a.ep=d.stringify(g);h.b.i();for(g=+new Date;400>=+new Date-g;);};if(c.med)l="/zoosnet",e="swt",m=/swt|zixun|call|chat|zoos|business|talk|kefu|openkf|online|\/LR\/Chatpre\.aspx/i,g={click:function(){for(var a=[],b=k(document.getElementsByTagName("a")),b=[].concat.apply(b,k(document.getElementsByTagName("area"))),b=[].concat.apply(b,k(document.getElementsByTagName("img"))),d,e,f=0,g=b.length;f<g;f++)d=b[f],e=d.getAttribute("onclick"),
d=d.getAttribute("href"),(m.test(e)||m.test(d))&&a.push(b[f]);return a}};else if(c.cvcc){l="/other-comm";e="other";m=c.cvcc.q||q;var p=c.cvcc.id||q;g={click:function(){for(var a=[],b=k(document.getElementsByTagName("a")),b=[].concat.apply(b,k(document.getElementsByTagName("area"))),b=[].concat.apply(b,k(document.getElementsByTagName("img"))),d,e,f,g=0,l=b.length;g<l;g++)d=b[g],m!==q?(e=d.getAttribute("onclick"),f=d.getAttribute("href"),p?(d=d.getAttribute("id"),(m.test(e)||m.test(f)||p.test(d))&&
a.push(b[g])):(m.test(e)||m.test(f))&&a.push(b[g])):p!==q&&(d=d.getAttribute("id"),p.test(d)&&a.push(b[g]));return a}}}if("undefined"!==typeof g&&"undefined"!==typeof m){var t;l+=/\/$/.test(l)?"":"/";var u=function(a,d){if(t===d)return v(l+a,d),w;if(b.d(d,"Array")||b.d(d,"NodeList"))for(var e=0,f=d.length;e<f;e++)if(t===d[e])return v(l+a+"/"+(e+1),d[e]),w};f.c(document,"mousedown",function(a){a=a||window.event;t=a.target||a.srcElement;var d={};for(n(g,function(a,e){d[a]=b.d(e,"Function")?e():document.getElementById(e)});t&&
t!==document&&n(d,u)!==w;)t=t.parentNode})}}})();(function(){var a=mt.p,b=mt.lang,f=mt.event,d=mt.l;if("undefined"!==typeof h.b&&b.d(c.cvcf,"Array")&&0<c.cvcf.length){var e={fa:function(){for(var b=c.cvcf.length,d,g=0;g<b;g++)(d=a.W(decodeURIComponent(c.cvcf[g])))&&f.c(d,"click",e.ra())},ra:function(){return function(){h.b.a.et=86;var a={n:"form",t:"clk"};a.id=this.id;h.b.a.ep=d.stringify(a);h.b.i()}}};a.Q(function(){e.fa()})}})();
(function(){var a=mt.event,b=mt.l;if(c.med&&"undefined"!==typeof h.b){var f=+new Date,d={n:"anti",sb:0,kb:0,clk:0},e=function(){h.b.a.et=86;h.b.a.ep=b.stringify(d);h.b.i()};a.c(document,"click",function(){d.clk++});a.c(document,"keyup",function(){d.kb=1});a.c(window,"scroll",function(){d.sb++});a.c(window,"unload",function(){d.t=+new Date-f;e()});a.c(window,"load",function(){setTimeout(e,5E3)})}})();
(function(){function a(){this.f=s}var b=mt.S,f=mt.j;a.prototype={La:function(a){if(this.f)this.h(a,0);else if(this.isSupported()){try{this.f=new ActiveXObject("BDEXIE.BDExExtension.1"),this.$=r}catch(b){this.$=w}this.$?this.h(a,0):this.h(a,-1)}else this.h(a,-1)},Va:function(){this.f&&delete this.f;this.f=s},Ra:function(a,b,d){if(this.f&&"SetLocalCache"in this.f)try{this.f.SetLocalCache(a,b)===q&&this.h(d,0)}catch(f){this.h(d,-1)}else this.h(d,-1)},za:function(a,b){if(this.f&&"GetLocalCache"in this.f)try{this.h(b,
this.f.GetLocalCache(a))}catch(d){this.h(b,"")}else this.h(b,"")},wa:function(a){if(this.f&&"GetCryptStr"in this.f)try{this.h(a,this.f.GetCryptStr("strEncryptID1"))}catch(b){this.h(a,"")}else this.h(a,"")},h:function(a,b){"function"===typeof a&&a(b,this)},isSupported:function(){if(window.ActiveXObject||"ActiveXObject"in window)try{return!!new ActiveXObject("BDEXIE.BDExExtension.1")}catch(a){}return w},Ma:function(){var a=this;this.wa(function(d){d!==q&&""!==d&&(b.log("//datax.baidu.com/x.gif?dm="+
encodeURIComponent("datax.baidu.com/webadapter/guid")+"&ac="+encodeURIComponent(d)+"&v=hm-webadapter-0.0.1&rnd="+Math.round(2147483647*Math.random())),a.Ra("hmKey",+new Date,function(){a.Va()}))})}};if(f.M&&/^http(s)?:$/.test(document.location.protocol)){var d=new a;d.La(function(a){0===a&&d.za("hmKey",function(a){a=+a;(isNaN(a)||6048E5<+new Date-a)&&d.Ma()})})}})();})();
