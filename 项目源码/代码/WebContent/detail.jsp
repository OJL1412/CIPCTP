<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>

<title>行业资讯</title>

<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/banner.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("ul.typeul .typeone").click(function()
	{
		var arrow = $(this).find("span.arrow");
		if(arrow.hasClass("up"))
		{
			arrow.removeClass("up");
			arrow.addClass("down");
		}
		else if(arrow.hasClass("down"))
		{
			arrow.removeClass("down");
			arrow.addClass("up");
		}
		$(this).parent().find(".typetwo").slideToggle();
	});
})
</script>
</head>

<body style="background: url(images/bg.jpg)"></body>

<body>
<div class="header">
  <div class="main">
     <a href="index.jsp"><img src="images/logo.png" /></a>
  </div>
</div>


<div class="clear"></div>
<div class="nav" style="background: url(images/nav.gif)">
  <ul>
    <li><a href="index.jsp">首页</a></li>
    <li><a href="about.jsp">关于我们</a></li>
    <li><a href="product.jsp">产品展示</a></li>
    <li><a href="news.jsp">行业动态</a></li>
    <li><a href="notices.jsp">我要留言</a></li>
    <li><a href="contact.jsp">联系我们</a></li>
  </ul>
</div>


<div class="clear"></div>
<div class="banner">
  <div class="b-img">
      <img src="images/banner.jpg" width="100%"/>
      <img src="images/banner.jpg" width="100%" />
  </div>
  <div class="clear"></div>
  <div class="b-list"> </div>
</div>


<div class="clear"></div>
<div class="main">
  <div class="mainL">
    <div class="titbox">产品分类</div>
    <ul class="typeul">
      <li>
        <div class="typeone"><a href="human.jsp">人物画</a><span class="arrow up"></span></div>
        <div class="typetwo">
          <a href="human_xq.jsp">人物画简介</a>
        </div>
      </li>
      <li>
        <div class="typeone"><a href="bird.jsp">花鸟画</a><span class="arrow up"></span></div>
        <div class="typetwo">
          <a href="bird_xq.jsp">花鸟画简介</a>
        </div>
      </li>
      <li>
        <div class="typeone"><a href="product.jsp">山水画</a><span class="arrow up"></span></div>
        <div class="typetwo">
          <a href="product_xq.jsp">山水画简介</a>
        </div>
      </li>
    </ul>
    
    
    <div class="titbox">最新资讯</div>
    <ul class="newsul">
      <li><a href="detail.jsp" class="ccsl">字画装裱需要注意什么细节问题?</a></li>
      <li><a href="detail2.jsp" class="ccsl">字画装裱是什么，如何修复？</a></li>
      <li><a href="https://zhuanlan.zhihu.com/p/27397993" class="ccsl">中国的人物画!</a></li>
      <li><a href="https://www.zhihu.com/question/20756819" class="ccsl">为什么中国古代人物画总是看着不那么写实？</a></li>
      <li><a href="https://www.zhihu.com/question/27218828" class="ccsl">人物画与风景画哪个更有深度，更难画？</a></li>
    </ul>
    
    <div class="titbox">行业动态</div>
    <ul class="newsul">
     <li><a href="https://mp.weixin.qq.com/s?src=3&timestamp=1600694003&ver=1&signature=BfsraBuMBDpFx6pTofR8h-xAHcdrbHP*kM8u9nvTurJGJdT4HwCb8Mnb8nPGVtUX7QhzDyuLpy2oFhF0uDlHge117XjOKeKkHJuN1y5MaRVupTtT7*2pgQ2YltjxtRzYeeegyN4ZwvGTT5p42ExLo1mXEMCxCgs5Di-3g8-Ss0Q=" class="ccsl"> > 经典山水画50幅，太养眼了</a></li>
     <li><a href="https://zhuanlan.zhihu.com/p/104687678" class="ccsl"> > 初级古风人物绘画教程，绘画入门学习</a></li>
     <li><a href="https://pic.sogou.com/d?query=%E4%BA%BA%E7%89%A9%E7%94%BB%E5%8F%A4%E9%A3%8E&ie=utf8&page=1&did=1&st=255&mode=255&phu=http%3A%2F%2Fpic138.nipic.com%2Ffile%2F20170810%2F25762159_143638859038_2.jpg&p=40230500&entityid=&rawQuery=%E4%BA%BA%E7%89%A9%E7%94%BB%E5%8F%A4%E9%A3%8E" class="ccsl"> > 古风人物</a></li>
     <li><a href="https://mp.weixin.qq.com/s?src=11&timestamp=1600694094&ver=2598&signature=wjkU8M7*1seM9XUyLanVxNV3dqUIYrlKcP8BTRGkfJNhQ1SgTr9f8*xEe6-2OpxL4RLyGEyWG5RoQmSVw21Sa9OvLPqrE0k17G18WT9Xeqh60J3upMx26JuEnPUa9SzG&new=1" class="ccsl"> > 新古风人物画</a></li>
     <li><a href="https://wenku.baidu.com/view/8558bfd649649b6648d747e6.html" class="ccsl"> > 中国山水画</a></li>
    </ul>
    
    
    <div class="titbox">联系我们</div>
    <div class="lxwm">
      <div class="con">
        手 机：12345678910<br />
        电 话：77000000<br />
        邮箱：123***@qq.com<br />
        地 址：河北省石家庄市裕华**街道**楼  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
      </div>
    </div>
  </div>
  
  
  <div class="mainR">
    <div class="brandnavbox">
      <h2>行业动态</h2>
      <div class="con">当前位置：首页》行业动态</div>
    </div>
    <div class="detailbox">
      <div class="xq">
        <div class="tit">字画装裱需要注意什么细节问题?</div>
        <div class="date">发表时间：2019-10-10  点击量：8888</div>
        <div class="con">
          <p>装裱古旧字画，需经过冲洗去污、揭旧补缀、修磨残口、矾挣全色、刺制裱绫、镶嵌绫绢、转边扶背、砑光上杆等多道工序。但主要可分为：修复画心、品订裱式等。那么字画装裱需要注意什么细节问题呢？</p>
          <p>1、悬挂和展示书画时要谨慎从事，悬挂书画时一定要一手持画杈挑住画绳，一手托住书画未展开部分，然后慢慢的放开来将书画挂起，取下画衩，展开书画时要一人牵引画绳，另一人两手持轴头将书画展开，切忌两手向上持书画中间部分。否则，手五指会将书画划出折痕，对于无轴头的书画的书画作品，展示时用两指夹住，使画件从指缝中通过，此外，还应注意书画不宜长期悬挂，挂一段时间后要卷起收藏一段时间，对久存的书画要定期挂起来通风。</p>
          <p>2、书画裱件存放时不宜卷的过紧或过松，更不可反卷，如果卷的过紧，会出现压痕，影响书画美观，还可能导致裱件的变形或出现脱落;如果卷的过松，容易折毁书画，如果反卷，会使书画出现一道道折痕，特别是古旧字画损害更大。</p>
          <p>3、展示手绢，册页时要倍加注意，因手绢，册页的装裱较其它书画的装裱复杂，手绢在展示时要放置平整的案头或桌子上，注意案面或桌面不能有水或脏物，手绢展开时不宜展的过长，要边展边卷，册页展开时最好不用手指翻，可用一个光滑而又无毛刺的竹条，插进册页夹页之间翻阅，册页一般较厚，开始翻页码或翻到最后几页会出现两面薄厚不均，两页之间悬空，此时如果不注意压住幅面中间的悬空处，则易造成折断现象。</p>
          <p>4、暂不装裱的书画片不可随便折叠，摞起，否则存放一段时间一久就会从折叠出断裂，或在折处留下折痕，以至装裱后影响美观，若要临时欣赏，切不可用图钉钉于墙上或糨糊粘于墙上，否则或直接损坏书画片，正确保存书画片的方法是：可将书画片下面衬一层幅面相当薄的宣纸或皮纸，以纸卷为轴将书画片卷起，并用白纸或塑料膜包装，放在画盒内或者书橱内。</p>
          <p>5、书画装裱后更应妥善保存，存放在地上要考虑防潮，放蛀，防鼠，防霉烂，防玷污等，可将每件书画装入一个塑料袋，也可用白纸包好，存放是要平放，切勿竖置，更不要在书画上面放置重物，如果有条件，可根据规格配置画盒，并在盒内放些樟脑或吸潮剂。</p>
          <p>6、保管已经破损的古旧字画更要谨慎，一时不能修复的不要随意展示，以避免书画再度被损，如果是已破碎的字画则更要防止散片丢失，以免给将来修复带来困难，无论是新旧字画，只要原裱尚能悬挂，画心尚无破损，一般不要急于揭裱修复，因揭瘭一次就会对书画损伤一次。</p>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>


<div class="clear"></div>
<div class="footerBox">
  <div class="main">
    <div class="footL">
      <div class="tit">联系我们</div>
      <ul>
        <li class="f1">手 机：12345678910</li>
        <li class="f2">电 话：77000000</li>
        <li class="f3">邮箱：123***@qq.com</li>
        <li class="f4">地 址：河北省石家庄市裕华**街道**楼  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></li>
      </ul>
    </div>
    
    
    <div class="footR">
      <div class="telbox">
        <div class="tel">
          <span>12345678910</span>
          <b><p>欢迎来电咨询</p></b>
        </div>
      </div>
      <div class="footer">
        <div>***有限公司<br />联系方式：12345678910<br />地 址：河北省石家庄市裕华**街道**楼  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></div>
      </div>
    </div>
  </div>
</div>


<div class="clear"></div>
<div class="fnav">
  <div class="main">
    <a href="index.jsp">首页</a>
    <a href="about.jsp">关于我们</a>
    <a href="product.jsp">产品展示</a>
    <a href="news.jsp">行业动态</a>
    <a href="notices.jsp">我要留言</a>
    <a href="contact.jsp">联系我们</a>
  </div>
</div>

</body>
</html>