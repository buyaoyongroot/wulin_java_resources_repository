//tealium universal tag - utag.1150 ut4.0.201512011544, Copyright 2015 Tealium.com Inc. All Rights Reserved.
try{(function(id,loader){var u={};utag.o[loader].sender[id]=u;if(utag===undefined){utag={};}if(utag.ut===undefined){utag.ut={};}if(utag.ut.loader===undefined){u.loader=function(o){var a,b,c,l;a=document;if(o.type==="iframe"){b=a.createElement("iframe");b.setAttribute("height","1");b.setAttribute("width","1");b.setAttribute("style","display:none");b.setAttribute("src",o.src);}else if(o.type==="img"){utag.DB("Attach img: "+o.src);b=new Image();b.src=o.src;return;}else{b=a.createElement("script");b.language="javascript";b.type="text/javascript";b.async=1;b.charset="utf-8";b.src=o.src;}if(o.id){b.id=o.id;}if(typeof o.cb==="function"){if(b.addEventListener){b.addEventListener("load",function(){o.cb();},false);}else{b.onreadystatechange=function(){if(this.readyState==="complete"||this.readyState==="loaded"){this.onreadystatechange=null;o.cb();}};}}l=o.loc||"head";c=a.getElementsByTagName(l)[0];if(c){utag.DB("Attach to "+l+": "+o.src);if(l==="script"){c.parentNode.insertBefore(b,c);}else{c.appendChild(b);}}};}else{u.loader=utag.ut.loader;}
u.ev={'view':1};u.initialized=false;u.map={};u.extend=[function(a,b){var o=[{"page":"Flash Site Visit Pixel","url":"www.ibm.com/msp/us/en/flash-storage-solutions"},{"page":"SPSS Site Visit Pixel","url":"www.ibm.com/msp/us/en/predictive-optimization-solutions"},{"page":"WANewRegThankYou1_TW","url":"www.ibm.com/ibmid/basic_register/register_confirmation.html?watsonanalytics=true"},{"page":"IBM_WA_Landin_TW","url":"www.ibm.com/analytics/watson-analytics/"},{"page":"IBM_WA_Signup_TW","url":"www.ibm.com/ibmid/basic_register/register.html?watsonanalytics=true"},{"page":"Retarget WA","url":"www.ibm.com/ibmid/basic_register/register.html?watsonanalytics=true"},{"page":"Flash Site Visit Pixel","url":"www.ibm.com/msp/us/en/flash-storage-solutions"},{"page":"SPSS Site Visit Pixel","url":"www.ibm.com/msp/us/en/predictive-optimization-solutions"},{"page":"Cloud_IAAS_Twitter_Visitors","url":"www.ibm.com/cloud-computing/in/en/iaas.html","data":{"twitter_txn_id":"ntvep"}},{"page":"Retarget WA","url":"www.ibm.com/ibmid/basic_register/register.html?watsonanalytics=true","data":{"twitter_txn_id":"ntugk"}}]
function getURL(h){var l=document.createElement("a");var href=h+"";if(!(href.indexOf("http")==0||href.indexOf("//")==0)){href="//"+href}l.href=href;return l};function getPath(h){var p=getURL(h).pathname+"";return((p.indexOf("/")===0)?p:"/"+p)};for(var i=0;i<o.length;i++){var t=o[i];if(b["dom.pathname"]==getPath(t.url)&&(b["dom.query_string"]==getURL(t.url).search.substring(1)||getURL(t.url).search.substring(1)==""||b["dom.query_string"].indexOf(getURL(t.url).search.substring(1))>-1)&&(b["dom.hash"]==getURL(t.url).hash.substring(1)||getURL(t.url).hash.substring(1)==""||b["dom.hash"].indexOf(getURL(t.url).hash.substring(1))>-1)){utag.DB(t);(function(txn_id){utag.ut.loader({type:"script",src:"//platform.twitter.com/oct.js",cb:function(){twttr.conversion.trackPid(txn_id,{tw_sale_amount:0,tw_order_quantity:0});}});})(t.data.twitter_txn_id);}}
return false;}];u.send=function(a,b){if(u.ev[a]||u.ev.all!==undefined){var c,d,e,f,i;u.data={};for(c=0;c<u.extend.length;c++){try{d=u.extend[c](a,b);if(d==false)return}catch(e){}};for(d in utag.loader.GV(u.map)){if(b[d]!==undefined&&b[d]!==""){e=u.map[d].split(",");for(f=0;f<e.length;f++){u.data[e[f]]=b[d];}}}
}};utag.o[loader].loader.LOAD(id);})("1150","ibm.main");}catch(error){utag.DB(error);}
