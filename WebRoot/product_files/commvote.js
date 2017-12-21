
function win_hidden(){
    if($("tag_box"))$("tag_box").style.display="none";
}

function addReport(id){
    showMsgBox(id,'','',reportBack,id);
}

function reportBack(id){
    var lin = $("tag_box");
    lin.innerHTML = reportWin(id.substr(3),1);
    PosHelper.SetOffset(id,lin,-150,0);
}

function reportWin(review_id,value){
    var sb = new StringBuilder('<div class="report_window">');
    sb.append('<div class="report_wind_title">');
    sb.append('    <div class="report_title_left">�ٱ�������Ϣ</div>');
    sb.append('    <div class="report_window_close"><a class="win_close" href=javascript:win_hidden();><img src="images/window_close.gif" title="�رմ���" /></a></div>');
    sb.append('</div>');
    if(value==-2){
        sb.append('<h2 style="text-align:center">�ٱ�ʧ�ܣ�</h2>');
        sb.append('<div class="bt_ok">');
        sb.append('<input  class="win_close" type="button" value="�ر�" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }else if(value==-3){
        sb.append('<h2 style="text-align:center">���Ѿ��ٱ�����</h2>');
        sb.append('<div class="bt_ok">');
        sb.append('<input  class="win_close" type="button" value="�ر�" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }else if(value==1){
        sb.append('<h2>�ٱ�ԭ��(<span class="f_nostrong">&nbsp;��ѡ&nbsp;</span>)��</h2>');
        sb.append('<ul>');
        sb.append('    <li>');
        sb.append('        <label>');
        sb.append('            <input name="report_radio" type="radio" value="0" onclick="javascript:checkReportRadio(this);" />');
        sb.append('            �����漰����������ɫ�顢������������˽��Υ������</label>');
        sb.append('    </li>');
        sb.append('    <li>');
        sb.append('        <label>');
        sb.append('            <input name="report_radio" type="radio" value="1" onclick="javascript:checkReportRadio(this);" />');
        sb.append('            �����Ϣ</label>');
        sb.append('    </li>');
        sb.append('    <li>');
        sb.append('        <label>');
        sb.append('            <input name="report_radio" type="radio" value="2" onclick="javascript:checkReportRadio(this);" />');
        sb.append('            ���ڰ�Ȩ����</label>');
        sb.append('    </li>');
        sb.append('    <li>');
        sb.append('        <label>');
        sb.append('            <input name="report_radio" type="radio" value="3" onclick="javascript:checkReportRadio(this);" />');
        sb.append('            ����</label>');
        sb.append('    </li>');
        sb.append('</ul><input id="reportCheckValue" type="hidden"/>');
        sb.append('<h2>����˵��(<span class="f_nostrong">&nbsp;��ѡ&nbsp;</span>)��</h2>');
        sb.append('<div class="add_txt">');
        sb.append('    <textarea id="report_content" name="textarea" cols="" rows="" onfocus="javascript:showNotice();" onkeyup="javascript:changeNum();"></textarea>');
        sb.append('</div>');
        sb.append('<div id="report_notice"  style="text-align:left; margin:3px 0px 0 25px; color:#666;display:none">������������<span id="report_over">250</span>��</div>');
        sb.append('<div class="bt_ok">');
        sb.append('    <input name="input" type="button" id="report_btn" disabled onClick=javascript:saveReport("',review_id,'");  value="�ٱ�"  />');
        sb.append('    &nbsp;&nbsp;<input  class="win_close" type="button" value="ȡ��" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }else{
        sb.append('<h2 style="text-align:center">�ٱ��ɹ���</h2>');
        sb.append('<div class="bt_ok">');
        sb.append('<input  class="win_close" type="button" value="�ر�" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }
    sb.append('</div>');
    return sb.getString();
}

function showNotice(){
    $("report_notice").style.display="block";
}

function changeNum(){
    var str = $("report_content").value;
    var num = 250-str.length;
    if(num<0){
        $("report_content").value = str.substr(0,250);
        num = 0;
    }
    $("report_over").innerHTML = num;
}

function checkReportRadio(obj){
    if(obj.checked){
        $("report_btn").disabled = false;
        $("reportCheckValue").value = obj.value;
    }
}

function saveReport(review_id){
    var lin = $("tag_box");
    var aAjax = new Ajax("ajax_proxy.php");
    var url="http://commu.dangdang.com/api/reportapi.php";
    var send_data = "request_url="+url+"&par="+review_id+":0:0&desc="+$("report_content").value+"&labs="+$("reportCheckValue").value;
    var result = aAjax.invokeServer(send_data,'POST');
    lin.innerHTML = reportWin(review_id,result.value);
}

function checkRadio(obj){
    if(obj.checked){
        $("bookshelf_btn").disabled = false;
        $("checkValue").value = obj.value;
    }
}

function bookShelfWin(product_id,value){
    var sb = new StringBuilder('<div class="window">');
    sb.append('<div class="wind_title">');
    sb.append('<div class="title_left">�������</div>');
    sb.append('<div class="window_close"><a class="win_close" href=javascript:win_hidden();><img src="/images/window_close.gif" title="�رմ���" /></a></div>');
    sb.append('</div>');
    sb.append('<div class="wind_cont">');
    if(value==3){
        sb.append('<ul class="w_notice_ul">');
        sb.append('<li class="li_one"><p><!--<span class="red_span">*</span>-->�Ķ����ȣ�</p></li><li class="li_one"><input type="radio" name="bookshelf_radiobutton" value="0" onclick="javascript:checkRadio(this);" /><p>��û��ʼ</p></li><li><input name="bookshelf_radiobutton" type="radio" value="1" onclick="javascript:checkRadio(this);"/><p>���ڶ�</p></li><li><input name="bookshelf_radiobutton" type="radio" value="2" onclick="javascript:checkRadio(this);" /><p>�Ѷ���</p></li>');
        sb.append('</ul><input id="checkValue" type="hidden"/>');
        sb.append('<div class="div_butt">');
        sb.append('<input name="input" id="bookshelf_btn" type="button" disabled  onClick=javascript:saveBookshelf("',product_id,'"); value="����"  />');
        sb.append('<input  class="win_close" type="button" value="ȡ��" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }else if(value==1){
        sb.append('<ul class="w_notice_ul">');
        sb.append('<li class="li_one">����ɹ���</li>');
        sb.append('</ul>');
        sb.append('<div class="div_butt">');
        sb.append('<input  class="win_close" type="button" value="�ر�" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }else if(value==2){
        sb.append('<ul class="w_notice_ul">');
        sb.append('<li class="li_one">���Ѿ��������</li>');
        sb.append('</ul>');
        sb.append('<div class="div_butt">');
        sb.append('<input  class="win_close" type="button" value="�ر�" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }else{
        sb.append('<ul class="w_notice_ul">');
        sb.append('<li class="li_one">����ʧ�ܣ�</li>');
        sb.append('</ul>');
        sb.append('<div class="div_butt">');
        sb.append('<input  class="win_close" type="button" value="�ر�" onclick="javascript:win_hidden();" />');
        sb.append('</div>');
    }
    sb.append('</div></div>');
    return sb.getString();
}

function saveBookshelf(product_id){
    var lin =  $("tag_box");
    var aAjax= new Ajax("ajax_proxy.php");
    var url = "http://commu.dangdang.com/api/addbookshelfapi.php";
    var send_data = "request_url="+url+"&pid="+product_id+"&va="+$("checkValue").value;
    var result=aAjax.invokeServer(send_data,'POST');
    lin.innerHTML = bookShelfWin(product_id,result.value);
  
}
function shelfback(id,product_id){
    var lin =  $("tag_box");
    lin.innerHTML = bookShelfWin(product_id,3);
    PosHelper.SetOffset(id,lin,-150,0);
}

function addBookShelf(id,product_id){
    showMsgBox(id,'','',shelfback,id,product_id);
}

function JsVote(review_id,product_id,total,helpful)
{

    this.review_id = review_id;
    this.vote_type = 1;
    this.product_id = product_id;

    this.helpful = helpful;
    this.useless = total - helpful;

    var is_Agent;
    var CurrUrl = "http://login.dangdang.com/signin.aspx?returnURL="+escape(window.location.href);

    this.UsefulVote = UsefulVote;

    function UsefulVote()
    {

        var useF = 'votespan' + this.review_id
        var textF = 'VoteText' + this.review_id

        var voteNumObj = document.getElementById(useF);
        var voteTextObj = document.getElementById(textF);
        Vote(this.review_id,1,this.product_id,voteNumObj,voteTextObj,this.helpful,this.useless);

    }

    this.UselessVote = UselessVote;

    function UselessVote()
    {

        var useF = 'votespan' + this.review_id
        var textF = 'VoteText' + this.review_id

        var voteTextObj = document.getElementById(textF);
        var voteNumObj = document.getElementById(useF);

        Vote(this.review_id,0,this.product_id,voteNumObj,voteTextObj,this.helpful,this.useless)

    }


    this.ChangeText = ChangeText;
    function ChangeText(result,vote_type,voteNumObj,voteTextObj,helpful,useless)
    {
        statusCode = result.statusCode;
        if(statusCode>0){
            var myRev = "<span class='space'><a href='http://commu.dangdang.com/review/usefulreview.php' target='_blank'>�鿴�������������õ�����</a></span>"
            if(vote_type==1){
                voteNumObj.innerHTML = "��<span class='red' >" + (parseInt(helpful)+1) +"</span>����Ϊ����������";
                voteTextObj.innerHTML= "��л����ͶƱ" + myRev;
            }else
                voteTextObj.innerHTML= "��л����ͶƱ";
        }else if(statusCode == -3){
            voteTextObj.innerHTML="���Ѿ�Ͷ��Ʊ��" ;
        }
    }

    function Vote(review_id,vote_type,product_id,voteNumObj,voteTextObj,helpful,useless)
    {

        var aAjax= new Ajax("ajax_proxy.php");
        //  var aAjax= new Ajax("http://product.dangdang.com/Dang.Prod.Web/ajax_proxy.ashx");

        var url = "http://commu.dangdang.com/api/voteapi.php";
        
        var send_data = "request_url="+url+"&review_id="+review_id+"&vote_type="+vote_type;

        var result=aAjax.invokeServer(send_data,'POST');

        ChangeText(result,vote_type,voteNumObj,voteTextObj,helpful,useless);
    }


}




function viewPrdComm(pid,prodtype,locenable)
{


    //if($('malltab'))$('malltab').innerHTML =
    var send_data = "Dtype=comm" + "&Par="+pid+ "&Prodtype="+prodtype+ "&Locenable="+locenable;
    var result = XMLHttp._sendRequest('POST', "callback.php", send_data,true, "text/xml", commcallback)

}

function commcallback(httpobj)
{

    if(httpobj)
    {
        var html = httpobj.responseText;
        reInnerHTML($("tag_box"), html);
    }

}


function isLogin()
{
    var send_data = "Par=0&Dtype=log";
    var result = XMLHttp._sendRequest('POST', "callback.php", send_data, false)
    if(result.trim() >'0')return true;
    return false;
}


function CallVoto(id,par)
{
    showMsgBox(id,'','',CallVotoback,id,par);
}

function CallVotoback(id,par)
{
    //"use:productId:review_id:voteCount:helpfunCount"
    var sta = par.split(":");
    var useful = sta[0];
    var review_id = sta[2];
    var product_id = sta[1];
    var total_vote_count = sta[3];
    var total_helpful_count = sta[4];

    if(useful == 1)
    {
        new JsVote(review_id,product_id,total_vote_count,total_helpful_count).UsefulVote();
    }
    else
    {
        new JsVote(review_id,product_id,total_vote_count,total_helpful_count).UselessVote();
    }

}


//var custObj = {"cust":[
//{
//"custid":"2241970",
//"custname":"������",
//"displayid":2233,
//"image":"http://images.ddimg.cn/image/dfd.jpg",
//"area":"�Ͼ�",
//"review_count":300,
//"fav_book_count":13,
//"points":33,
//"reviewer_rating":"��������Ա"
//},

//{
//"custid":"8655272",
//"custname":"������",
//"displayid":2233,
//"image":"http://images.ddimg.cn/image/dfd.jpg",
//"area":"����",
//"review_count":30,
//"fav_book_count":23,
//"points":23,
//"reviewer_rating":"�м�����Ա"
//},
//{
//"custid":"9355576",
//"custname":"��",
//"displayid":2233,
//"image":"http://images.ddimg.cn/image/dfd.jpg",
//"area":"����",
//"review_count":330,
//"fav_book_count":113,
//"points":13,
//"reviewer_rating":"�߼�����Ա"
//}
//]};

//var bookcaseJson = {"bookcase":[{
//"prd":123343,
//"reading":620,
//"have_read":712,
//"no_read":12
//}]}




function getCustData(custid)
{


    if ( typeof custJson == 'undefined' || custJson == null ||(!custJson) )
    {

        return {
            "custid":"",
            "custname":"",
            "displayid":"",
            "image":"images/default.gif",
            "area":"",
            "review_count":"0",
            "fav_book_count":"0",
            "points":"0",
            "reviewer_rating":"",
            "review_honor":"0"
        }

    }

    var len = custJson.cust.length

    for(var i=0 ;i < len ;i ++)
    {
        if(custJson.cust[i].custid == custid) return custJson.cust[i];
    }

    return {
        "custid":"",
        "custname":"",
        "displayid":"",
        "image":"images/default.gif",
        "area":"",
        "review_count":"0",
        "fav_book_count":"0",
        "points":"0",
        "reviewer_rating":"",
        "review_honor":"0"
    }

}

function ReWrite(reviewid,parameters)
{

    if ( typeof custJson == 'undefined')
    {
        JSLoad ("http://commu.dangdang.com/api/customersapi.php?custId="+parameters);
    }

    var obj = parameters.split(",");
    var revobj = reviewid.split(",");

    if(typeof obj == "object")
    {
        for(var i=0;i<obj.length;i++)
        {
            var custid= obj[i];
            var revid = revobj[i];

            if($("buyer_"+revid))
            {
                html = RevDiv(custid);
                reInnerHTML($("buyer_"+revid), html);

            }

        }


    }

}


function RevDiv(custid){

    var custD =  getCustData(custid);

    var sb = new StringBuilder('<div class="buyer_pic">');


    sb.append('<div class="buyer_pic_bg">');

    if(custD.displayid > "1")
    {
        sb.append('<a target="_blank" title="�鿴���û���ȫ������" href= "http://commu.dangdang.com/member/myfirst.php?displayid=',custD.displayid,'"> <img src="',custD.image,'" \/><\/a>');
    }
    else
    {
        sb.append('<img src="',custD.image,'" \/>');
    }
    sb.append('<\/div>');
    sb.append('<div class="buyer_num">');


    if(custD.displayid > "1")
    {
        sb.append('<div class="buyer_num01"><a href="http://commu.dangdang.com/member/myreview.php?displayid=',custD.displayid,'"><img title="��������" src="images/icon_user01.gif"/><\/a><a href="http://commu.dangdang.com/member/myreview.php?displayid=',custD.displayid,'">',custD.review_count,'</a><\/div>');
        sb.append('<div class="buyer_num02"><a href="http://commu.dangdang.com/member/mybookshelfsubtype.php?displayid=',custD.displayid,'"><img title="��ܲ�����" src="images/icon_user02.gif"\/></a><a href="http://commu.dangdang.com/member/mybookshelfsubtype.php?displayid=',custD.displayid,'">',custD.fav_book_count,'</a><\/div>');

    }
    else
    {
        sb.append('<div class="buyer_num01"><img title="��������" src="images/icon_user01.gif"/>',custD.review_count,'<\/div>');
        sb.append('<div class="buyer_num02"><img title="��ܲ�����" src="images/icon_user02.gif"\/>',custD.fav_book_count,'<\/div>');

    }

    sb.append('</div></div>');
    sb.append('<div class="empty_box"></div>');
    if(custD.displayid > "1"){
        sb.append('<p><a target="_blank" title="�鿴���û���ȫ������" href="http://commu.dangdang.com/member/myfirst.php?displayid=',custD.displayid,'" >',custD.custname,'<\/a><\/p>');
    }
    else
    {
        sb.append('<p>',custD.custname,'<\/p>');
    }
    sb.append('<p class="buyer_city">',custD.area,'<\/p>');
    sb.append('<div class="buyer_cheer">');

    if(custD.review_honor > "0"){
        sb.append('<img class="special_pic" src="images/super_icon.gif" title="��Լ����Ա" />');
    }

    sb.append('<p>',custD.reviewer_rating,'<\/p>');
    //sb.append('<p>��Ծ�Ȼ��֣�',custD.points,'<\/p>');
    sb.append('<\/div>');

    return sb.getString();

}

//add new reivew
function NewReview(id,par)
{
    showMsgBox(id,'','',newReviewback,id,par);
}

function newReviewback(id,par)
{

    var url = "http://commu.dangdang.com/review/reviewpost.php?product_id=";
    
    var isOk = checkemail();

    if(isOk)
    {
        window.location.href = url + par;
    }
    else
    {
        $("checkemailp").style.display="block";
    }

}

function NewAnswer(id,par)
{
    showMsgBox(id,'','',newAnswerback,id,par);
}

function newAnswerback(id,par)
{
    var url = "http://commu.dangdang.com/question/questiondetail.php?question_id=";
    //var url = "http://comm.dangdang.com/QADetail.aspx?question_id=";
    var isOk = checkemail();
    if(isOk)
    {
        window.location.href = url + par;
    }
    else
    {
        $("answer"+par).style.display="inline";
    }
}

function NewQuestion(id,par)
{
    showMsgBox(id,'','',newQuestionback,id,par);
}

function newQuestionback(id,par)
{

    var url = "http://commu.dangdang.com/question/question.php?product_id=";

    var isOk = checkemail();

    if(isOk)
    {
        window.location.href = url + par;
    }
    else
    {
        $("qcheckemailp").style.display="block";
    }

}

function getCookie_one(name,type){
    var search;
    search = name + "=";
    var cookies=document.cookie.split(";")  ;

    if(type=="dangdang"){
        var dangdangcookie="";
        for(i=0;i<cookies.length;i++){
            if(cookies[i].indexOf("dangdang.com=")>-1){
                dangdangcookie=cookies[i].split("&");
                for(x=0;x<dangdangcookie.length;x++){
                    if(dangdangcookie[x].indexOf(search)>-1){
                        return unescape(dangdangcookie[x].substring(search.length,dangdangcookie[x].length));
                    }
                }
            }
        }

    }else{
        for(i=0;i<cookies.length;i++){
            if(cookies[i].indexOf("dangdang.com=")<0){
                if(cookies[i].indexOf(search)>-1){
                    return unescape(cookies[i].substring(search.length+1,cookies[i].length));
                }
            }
        }
    }
    return "";
}

function checkemail()
{

    var validatedflag=getCookie_one("validatedflag","");
    if(validatedflag=="1" || validatedflag=="2" || validatedflag=="3")
        return false;
    else
        return true;
}
