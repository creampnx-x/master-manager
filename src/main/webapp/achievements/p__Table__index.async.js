"use strict";(self.webpackChunk=self.webpackChunk||[]).push([[311],{6098:function(_e,q,a){a.r(q),a.d(q,{default:function(){return Ke}});var Z={};a.r(Z),a.d(Z,{addUser:function(){return Ce},deleteUser:function(){return be},getUserDetail:function(){return ye},modifyUser:function(){return Fe},queryUserList:function(){return ge}});var pe=a(90967),_=a.n(pe),he=a(30577),x=a.n(he),fe=a(58357),o=a.n(fe),Ie=a(86378),h=a.n(Ie),Se=a(71977),g=a.n(Se),A=a(42325);function ge(m,n){return B.apply(this,arguments)}function B(){return B=g()(o()().mark(function m(n,s){return o()().wrap(function(d){for(;;)switch(d.prev=d.next){case 0:return d.abrupt("return",(0,A.request)("http://localhost:8080/master_manager_war/IdentifyList",h()({method:"GET",params:h()({},n)},s||{})));case 1:case"end":return d.stop()}},m)})),B.apply(this,arguments)}function Ce(m,n){return D.apply(this,arguments)}function D(){return D=g()(o()().mark(function m(n,s){return o()().wrap(function(d){for(;;)switch(d.prev=d.next){case 0:return d.abrupt("return",(0,A.request)("http://localhost:8080/master_manager_war/CreateIdentifyServlet",h()({method:"POST",headers:{"Content-Type":"application/json"},params:n},s||{})));case 1:case"end":return d.stop()}},m)})),D.apply(this,arguments)}function ye(m,n){return E.apply(this,arguments)}function E(){return E=g()(o()().mark(function m(n,s){var c;return o()().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return c=n.userId,r.abrupt("return",(0,A.request)("/api/v1/user/".concat(c),h()({method:"GET",params:h()({},n)},s||{})));case 2:case"end":return r.stop()}},m)})),E.apply(this,arguments)}function Fe(m,n){return P.apply(this,arguments)}function P(){return P=g()(o()().mark(function m(n,s){return o()().wrap(function(d){for(;;)switch(d.prev=d.next){case 0:return d.abrupt("return",(0,A.request)("http://localhost:8080/master_manager_war/UpdateServlet",h()({method:"GET",headers:{"Content-Type":"application/json"},params:h()({},n)},s||{})));case 1:case"end":return d.stop()}},m)})),P.apply(this,arguments)}function be(m,n){return R.apply(this,arguments)}function R(){return R=g()(o()().mark(function m(n,s){var c;return o()().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return c=n.userId,r.abrupt("return",(0,A.request)("/api/v1/user/".concat(c),h()({method:"DELETE",params:h()({},n)},s||{})));case 2:case"end":return r.stop()}},m)})),R.apply(this,arguments)}var xe={UserController:Z},Te=a(86188),ee=a(88542),Ae=a(58261),$e=a(44123),C=a(50226),te=a(96018),T=a(95598),ne=a(38496),je=a(56115),F=a(93236),re=a(68569),t=a(62086),Ue=function(n){var s=n.modalVisible,c=n.onCancel;return(0,t.jsx)(re.Z,{destroyOnClose:!0,title:"\u65B0\u5EFA",width:420,visible:s,onCancel:function(){return c()},footer:null,children:n.children})},we=Ue,j=a(64843),Ze=a(15484),Be=a(64256),L=a(8446),De=a(22271),Ee=a(15223),Pe=function(n){return(0,t.jsxs)(j.L,{stepsProps:{size:"small"},stepsFormRender:function(c,d){return(0,t.jsx)(re.Z,{width:640,bodyStyle:{padding:"32px 40px 48px"},destroyOnClose:!0,title:"\u89C4\u5219\u914D\u7F6E",visible:n.updateModalVisible,footer:d,onCancel:function(){return n.onCancel()},children:c})},onFinish:n.onSubmit,children:[(0,t.jsxs)(j.L.StepForm,{initialValues:{name:n.values.name,nickName:n.values.nickName},title:"\u57FA\u672C\u4FE1\u606F",children:[(0,t.jsx)(Ze.Z,{width:"md",name:"name",label:"\u89C4\u5219\u540D\u79F0",rules:[{required:!0,message:"\u8BF7\u8F93\u5165\u89C4\u5219\u540D\u79F0\uFF01"}]}),(0,t.jsx)(Be.Z,{name:"desc",width:"md",label:"\u89C4\u5219\u63CF\u8FF0",placeholder:"\u8BF7\u8F93\u5165\u81F3\u5C11\u4E94\u4E2A\u5B57\u7B26",rules:[{required:!0,message:"\u8BF7\u8F93\u5165\u81F3\u5C11\u4E94\u4E2A\u5B57\u7B26\u7684\u89C4\u5219\u63CF\u8FF0\uFF01",min:5}]})]}),(0,t.jsxs)(j.L.StepForm,{initialValues:{target:"0",template:"0"},title:"\u914D\u7F6E\u89C4\u5219\u5C5E\u6027",children:[(0,t.jsx)(L.Z,{width:"md",name:"target",label:"\u76D1\u63A7\u5BF9\u8C61",valueEnum:{0:"\u8868\u4E00",1:"\u8868\u4E8C"}}),(0,t.jsx)(L.Z,{width:"md",name:"template",label:"\u89C4\u5219\u6A21\u677F",valueEnum:{0:"\u89C4\u5219\u6A21\u677F\u4E00",1:"\u89C4\u5219\u6A21\u677F\u4E8C"}}),(0,t.jsx)(De.Z.Group,{name:"type",width:"md",label:"\u89C4\u5219\u7C7B\u578B",options:[{value:"0",label:"\u5F3A"},{value:"1",label:"\u5F31"}]})]}),(0,t.jsxs)(j.L.StepForm,{initialValues:{type:"1",frequency:"month"},title:"\u8BBE\u5B9A\u8C03\u5EA6\u5468\u671F",children:[(0,t.jsx)(Ee.Z,{name:"time",label:"\u5F00\u59CB\u65F6\u95F4",rules:[{required:!0,message:"\u8BF7\u9009\u62E9\u5F00\u59CB\u65F6\u95F4\uFF01"}]}),(0,t.jsx)(L.Z,{name:"frequency",label:"\u76D1\u63A7\u5BF9\u8C61",width:"xs",valueEnum:{month:"\u6708",week:"\u5468"}})]})]})},Re=Pe,U=xe.UserController,Le=U.addUser,Ve=U.queryUserList,ze=U.deleteUser,V=U.modifyUser,f=localStorage.getItem("user_type"),ae=localStorage.getItem("user_id"),ke=localStorage.getItem("mentor"),Ge=function(){var m=g()(o()().mark(function n(s){var c;return o()().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return c=C.ZP.loading("\u6B63\u5728\u6DFB\u52A0"),r.prev=1,r.next=4,Le(h()(h()({},s),{},{user_id:ae,user_type:f,mentor:ke,paper_time:Date.parse(s.paper_time),prize_time:Date.parse(s.prize_time)}));case 4:return c(),C.ZP.success("\u6DFB\u52A0\u6210\u529F"),r.abrupt("return",!0);case 9:return r.prev=9,r.t0=r.catch(1),c(),C.ZP.error("\u6DFB\u52A0\u5931\u8D25\u8BF7\u91CD\u8BD5\uFF01"),r.abrupt("return",!1);case 14:case"end":return r.stop()}},n,null,[[1,9]])}));return function(s){return m.apply(this,arguments)}}(),Me=function(){var m=g()(o()().mark(function n(s){var c;return o()().wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return c=C.ZP.loading("\u6B63\u5728\u914D\u7F6E"),r.prev=1,r.next=4,V({userId:s.id||""},{name:s.name||"",nickName:s.nickName||"",email:s.email||""});case 4:return c(),C.ZP.success("\u914D\u7F6E\u6210\u529F"),r.abrupt("return",!0);case 9:return r.prev=9,r.t0=r.catch(1),c(),C.ZP.error("\u914D\u7F6E\u5931\u8D25\u8BF7\u91CD\u8BD5\uFF01"),r.abrupt("return",!1);case 14:case"end":return r.stop()}},n,null,[[1,9]])}));return function(s){return m.apply(this,arguments)}}(),Oe=function(){var m=g()(o()().mark(function n(s){var c,d;return o()().wrap(function(I){for(;;)switch(I.prev=I.next){case 0:if(c=C.ZP.loading("\u6B63\u5728\u5220\u9664"),s){I.next=3;break}return I.abrupt("return",!0);case 3:return I.prev=3,I.next=6,ze({userId:((d=s.find(function(z){return z.id}))===null||d===void 0?void 0:d.id)||""});case 6:return c(),C.ZP.success("\u5220\u9664\u6210\u529F\uFF0C\u5373\u5C06\u5237\u65B0"),I.abrupt("return",!0);case 11:return I.prev=11,I.t0=I.catch(3),c(),C.ZP.error("\u5220\u9664\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5"),I.abrupt("return",!1);case 16:case"end":return I.stop()}},n,null,[[3,11]])}));return function(s){return m.apply(this,arguments)}}(),Ne=function(){var n=(0,F.useState)(!1),s=x()(n,2),c=s[0],d=s[1],r=(0,F.useState)(!1),I=x()(r,2),z=I[0],ie=I[1],We=(0,F.useState)({}),ue=x()(We,2),k=ue[0],le=ue[1],y=(0,F.useRef)(),Ye=(0,F.useState)(),se=x()(Ye,2),G=se[0],w=se[1],He=(0,F.useState)([]),de=x()(He,2),$=de[0],Je=de[1],Qe=(0,F.useState)(),oe=x()(Qe,2),Xe=oe[0],M=oe[1],ce=[{title:"\u6559\u79D1\u4E66",dataIndex:"textbook",hideInTable:!0},{title:"\u6807\u51C6",dataIndex:"standard",hideInTable:!0},{title:"\u4E13\u5229",dataIndex:"patent",hideInTable:!0},{title:"\u62A5\u544A",dataIndex:"report",hideInTable:!0},{title:"\u53D1\u660E\u8BC1\u4E66",dataIndex:"devCertificate",hideInTable:!0}],me=[{title:"\u6807\u51C6",dataIndex:"standard",hideInTable:!0},{title:"\u5176\u4ED6",dataIndex:"others",hideInTable:!0}],ve=[{title:"\u5956\u9879\u540D\u79F0",dataIndex:"name",hideInTable:!0,formItemProps:{name:"prize_name"}},{title:"\u5956\u9879\u7EA7\u522B",dataIndex:"prizeLevel",hideInTable:!0,formItemProps:{name:"prize_level"}},{title:"\u83B7\u5956\u7B49\u7EA7",dataIndex:"awardsRank",hideInTable:!0,formItemProps:{name:"awards_rank"}},{title:"\u6392\u540D",dataIndex:"rank",hideInTable:!0},{title:"\u83B7\u5956\u65F6\u95F4",dataIndex:"time",hideInTable:!0,formItemProps:{name:"prize_time"}},{title:"\u8BC1\u660E\u8D44\u6E90",dataIndex:"resource",hideInTable:!0,formItemProps:{name:"prize_resource"}}],O=[{title:"ID",dataIndex:"id",tip:"ID\u662F\u552F\u4E00\u7684 key",hideInDescriptions:!0,hideInForm:!0},{title:"\u521D\u5BA1\u72B6\u6001",dataIndex:"initialStatus",hideInDescriptions:!0,hideInForm:!0,render:function(v,e){var i,u,l,S;return(0,t.jsx)(te.Z,{color:(e==null||(i=e.initialStatus)===null||i===void 0?void 0:i.trim())==="pending"?"blue":(e==null||(u=e.initialStatus)===null||u===void 0?void 0:u.trim())==="access"?"success":"error",children:(e==null||(l=e.initialStatus)===null||l===void 0?void 0:l.trim())==="pending"?"\u7B49\u5F85":(e==null||(S=e.initialStatus)===null||S===void 0?void 0:S.trim())==="access"?"\u901A\u8FC7":"\u5931\u8D25"})}},{title:"\u7EC8\u5BA1\u72B6\u6001",dataIndex:"finalStatus",hideInDescriptions:!0,hideInForm:!0,render:function(v,e){var i,u,l,S;return(0,t.jsx)(te.Z,{color:(e==null||(i=e.finalStatus)===null||i===void 0?void 0:i.trim())==="pending"?"blue":(e==null||(u=e.finalStatus)===null||u===void 0?void 0:u.trim())==="access"?"success":"error",children:(e==null||(l=e.finalStatus)===null||l===void 0?void 0:l.trim())==="pending"?"\u7B49\u5F85":(e==null||(S=e.finalStatus)===null||S===void 0?void 0:S.trim())==="access"?"\u901A\u8FC7":"\u5931\u8D25"})}},h()({},localStorage.getItem("user_type")==="mentor"||localStorage.getItem("user_type")==="admin"?{title:"\u7814\u7A76\u751F\u7C7B\u522B",dataIndex:"userType",hideInDescriptions:!0,hideInForm:!0}:{hideInDescriptions:!0,hideInForm:!0}),h()({},localStorage.getItem("user_type")==="mentor"||localStorage.getItem("user_type")==="admin"?{title:"\u53D1\u8D77\u7814\u7A76\u751F",dataIndex:"sponsor",hideInDescriptions:!0,hideInForm:!0}:{hideInDescriptions:!0,hideInForm:!0}),{title:"\u8BBA\u6587",hideInDescriptions:!0,hideInForm:!0,render:function(v,e){return(0,t.jsx)("a",{onClick:function(){var u,l,S;M(O),w((u=e==null||(l=e.masterAchievements)===null||l===void 0?void 0:l.paper)!==null&&u!==void 0?u:e==null||(S=e.doctorAchievements)===null||S===void 0?void 0:S.paper)},children:"\u67E5\u770B\u8BBA\u6587"})}},h()({},localStorage.getItem("user_type")!=="master"?{title:"\u5956\u52B1",hideInDescriptions:!0,hideInForm:!0,render:function(v,e){var i;return(0,t.jsx)(T.Z,{onClick:function(){var l;M(ve),w(e==null||(l=e.doctorAchievements)===null||l===void 0?void 0:l.prize)},type:"link",disabled:!(e!=null&&(i=e.doctorAchievements)!==null&&i!==void 0&&i.prize),children:"\u67E5\u770B\u5956\u52B1"})}}:{hideInDescriptions:!0,hideInForm:!0}),{title:"\u8BBA\u6587\u540D\u79F0",dataIndex:"name",hideInTable:!0,formItemProps:{name:"paper_name"}},{title:"\u51FA\u7248\u793E",dataIndex:"publication",hideInTable:!0,formItemProps:{name:"paper_publication"}},{title:"\u8BBA\u6587\u5E93",dataIndex:"repo",hideInTable:!0,formItemProps:{name:"paper_repo"}},{title:"\u72B6\u6001",dataIndex:"status",hideInTable:!0,formItemProps:{name:"paper_status"}},{title:"\u7D22\u5F15\u7C7B\u578B",dataIndex:"indexType",hideInTable:!0,formItemProps:{name:"paper_indexType"}},{title:"\u65F6\u95F4",dataIndex:"time",hideInTable:!0,formItemProps:{name:"paper_time"}},{title:"\u8BBA\u6587\u8D44\u6E90",dataIndex:"resource",hideInTable:!0,formItemProps:{name:"paper_resource"}},{title:"\u64CD\u4F5C",dataIndex:"option",valueType:"option",render:function(v,e){return(0,t.jsx)(t.Fragment,{children:(0,t.jsx)("a",{onClick:function(){M(e!=null&&e.masterAchievements?ce:me),w(e)},children:"\u67E5\u770B\u5176\u4ED6\u6210\u679C"})})}},h()({},localStorage.getItem("user_type")==="mentor"||localStorage.getItem("user_type")==="admin"?{title:"\u5BA1\u6838",dataIndex:"_",valueType:"option",render:function(v,e){var i,u,l,S,N,K,W,Y,H,J,Q,X;return(0,t.jsxs)(t.Fragment,{children:[(0,t.jsx)(ne.Z,{title:"\u901A\u8FC7\u5BA1\u6838",description:"\u786E\u8BA4\u8BA9\u6210\u679C\u901A\u8FC7\u5BA1\u6838?",onConfirm:function(){var b;V({node:f==="admin"?1:0,status:"access",id:e.id}),(b=y.current)===null||b===void 0||b.reload()},disabled:f==="admin"&&((e==null||(i=e.initialStatus)===null||i===void 0?void 0:i.trim())!=="access"||(e==null||(u=e.finalStatus)===null||u===void 0?void 0:u.trim())!=="pending")||f==="mentor"&&(e==null||(l=e.initialStatus)===null||l===void 0?void 0:l.trim())!=="pending",children:(0,t.jsx)(T.Z,{disabled:f==="admin"&&((e==null||(S=e.initialStatus)===null||S===void 0?void 0:S.trim())!=="access"||(e==null||(N=e.finalStatus)===null||N===void 0?void 0:N.trim())!=="pending")||f==="mentor"&&(e==null||(K=e.initialStatus)===null||K===void 0?void 0:K.trim())!=="pending",type:"link",children:f==="mentor"?"\u901A\u8FC7\u521D\u5BA1":"\u901A\u8FC7\u7EC8\u5BA1"})}),(0,t.jsx)(ne.Z,{title:"\u4E0D\u901A\u8FC7\u5BA1\u6838",description:"\u786E\u8BA4\u8BA9\u6210\u679C\u4E0D\u901A\u8FC7\u5BA1\u6838?",onConfirm:function(){var b;V({node:f==="admin"?1:0,status:"failed",id:e.id}),(b=y.current)===null||b===void 0||b.reload()},disabled:f==="admin"&&((e==null||(W=e.initialStatus)===null||W===void 0?void 0:W.trim())!=="access"||(e==null||(Y=e.finalStatus)===null||Y===void 0?void 0:Y.trim())!=="pending")||f==="mentor"&&(e==null||(H=e.initialStatus)===null||H===void 0?void 0:H.trim())!=="pending",children:(0,t.jsx)(T.Z,{disabled:f==="admin"&&((e==null||(J=e.initialStatus)===null||J===void 0?void 0:J.trim())!=="access"||(e==null||(Q=e.finalStatus)===null||Q===void 0?void 0:Q.trim())!=="pending")||f==="mentor"&&(e==null||(X=e.initialStatus)===null||X===void 0?void 0:X.trim())!=="pending",type:"link",danger:!0,children:f==="mentor"?"\u4E0D\u901A\u8FC7\u521D\u5BA1":"\u4E0D\u901A\u8FC7\u7EC8\u5BA1"})})]})}}:{hideInDescriptions:!0,hideInForm:!0})];return(0,t.jsxs)(Te._z,{header:{title:"\u7814\u7A76\u751F\u6210\u679C"},children:[(0,t.jsx)(ee.Z,{headerTitle:"\u7814\u7A76\u751F\u6210\u679C\u5217\u8868",actionRef:y,rowKey:"id",search:!1,toolBarRender:function(){return[f!=="mentor"&&f!=="admin"&&(0,t.jsx)(T.Z,{type:"primary",onClick:function(){return d(!0)},children:"\u65B0\u5EFA"},"1")]},request:g()(o()().mark(function p(){var v;return o()().wrap(function(i){for(;;)switch(i.prev=i.next){case 0:return i.next=2,Ve({user_id:ae,user_type:f});case 2:return v=i.sent,i.abrupt("return",{data:v.map(function(u){return h()(h()(h()({},u==null?void 0:u.masterAchievements),u==null?void 0:u.doctorAchievements),u)}),success:!0});case 4:case"end":return i.stop()}},p)})),columns:O}),($==null?void 0:$.length)>0&&(0,t.jsxs)(Ae.S,{extra:(0,t.jsxs)("div",{children:["\u5DF2\u9009\u62E9"," ",(0,t.jsx)("a",{style:{fontWeight:600},children:$.length})," ","\u9879\xA0\xA0"]}),children:[(0,t.jsx)(T.Z,{onClick:g()(o()().mark(function p(){var v,e;return o()().wrap(function(u){for(;;)switch(u.prev=u.next){case 0:return u.next=2,Oe($);case 2:Je([]),(v=y.current)===null||v===void 0||(e=v.reloadAndRest)===null||e===void 0||e.call(v);case 4:case"end":return u.stop()}},p)})),children:"\u6279\u91CF\u5220\u9664"}),(0,t.jsx)(T.Z,{type:"primary",children:"\u6279\u91CF\u5BA1\u6279"})]}),(0,t.jsx)(we,{onCancel:function(){return d(!1)},modalVisible:c,children:(0,t.jsx)(ee.Z,{onSubmit:function(){var p=g()(o()().mark(function v(e){var i;return o()().wrap(function(l){for(;;)switch(l.prev=l.next){case 0:return l.next=2,Ge(e);case 2:i=l.sent,i&&(d(!1),y.current&&y.current.reload());case 4:case"end":return l.stop()}},v)}));return function(v){return p.apply(this,arguments)}}(),rowKey:"id",type:"form",columns:[].concat(O,_()(f==="doctor"?ve:[]),_()(f==="doctor"?me:ce))})}),k&&Object.keys(k).length?(0,t.jsx)(Re,{onSubmit:function(){var p=g()(o()().mark(function v(e){var i;return o()().wrap(function(l){for(;;)switch(l.prev=l.next){case 0:return l.next=2,Me(e);case 2:i=l.sent,i&&(ie(!1),le({}),y.current&&y.current.reload());case 4:case"end":return l.stop()}},v)}));return function(v){return p.apply(this,arguments)}}(),onCancel:function(){ie(!1),le({})},updateModalVisible:z,values:k}):null,(0,t.jsx)(je.Z,{width:600,visible:!!G,onClose:function(){w(void 0)},closable:!1,children:G&&(0,t.jsx)($e.vY,{column:1,title:"\u6210\u679C",request:g()(o()().mark(function p(){return o()().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",{data:G||{}});case 1:case"end":return e.stop()}},p)})),columns:Xe})})]})},Ke=Ne}}]);
