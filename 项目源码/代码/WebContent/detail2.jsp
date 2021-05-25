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
        <div class="tit">字画装裱是什么，如何修复？</div>
        <div class="date">发表时间：2019-10-10  点击量：8888</div>
        <div class="con">
          <p>装裱古旧字画，需经过冲洗去污、揭旧补缀、修磨残口、矾挣全色、刺制裱绫、镶嵌绫绢、转边扶背、砑光上杆等多道工序。但主要可分为：修复画心、品订裱式等。</p>
          <p>修复画心 古旧字画有的残损，有的污脏，修复方法有以下几种：</p>
          <p>①去污。画心因烟熏尘染，质地变黄变黑，如画面颜色稳固，可将画心放入清水内浸泡，隔时换水，即可明净。污迹较重，可用热水浸泡，或缓缓浇淋开水。画面颜色受潮返铅的,可用双氧水涂抹消除。画心生霉,有黑有红,黑霉易涂,红霉可用高锰酸钾溶液涂在霉处，稍时再涂双氧水和淡草酸水，如霉不严重，一次即可除掉。用药物去污后，务必用清水冲淋画心，免蚀纸绢。</p>
          <p>②揭旧。揭前在画心正面用排笔蘸清水或温水刷湿，并覆盖新纸一张,反置案上待揭。古旧字画多有断裂,如在揭心之前，不附加垫纸，揭托之后，不易起案。画心局部颜色不稳定的，应稍施淡胶矾水，干后，再行闷水。有些残破糟朽的画心，当日揭不完时，应在已揭过的部位，均匀地放置些湿纸团，然后覆盖一层塑料薄膜，以防画心干裂错位。揭画心上的旧纸，一般应根据字画的薄厚、残状、颜色以及质地的具体情况制定揭旧方案。</p>
          <p>③托补。已揭好的画心，如完整，可调兑稀糊，托一层比命纸命绢稍浅的旧色纸。如有残缺，可用手将画心残处边际揉出薄口，选好补纸，端正纹理补上，并在补口边际搓出薄边。使接缝处厚度适宜。补缀残缺的绢本字画,一种方法是揭毕待干，用刀将残处刮成薄口,上糊补绢，浆口干后再修刮补绢边际，使补口相合。另一种方法是托上一层与原命绢质地、丝纹相近的薄绢。正面如有残缺，可用素纸补在托绢的背面，使画心薄厚统一，干后再用刀修磨画面残缺处的边际。托旧绢画心时，要用干纸吸去正面的溢糊，以免留有浆迹，影响古旧作品的“褒光”。</p>
          <p>④全色。字画经揭托，待干后，务使补纸补绢的矾性适度。否则，矾轻则透色，矾重则滞笔。全色时，应将颜色调兑得浅些,复次全就，使颜色渗进纸纹纤维,取得画面色调统一的效果。画心有缺笔的，补全时，需先审视画心气韵及用笔特点,然后轻勾轮廓,调兑颜色，进而全之，力求使补全的一笔一点、一墨一皴均与原画浑然一体。对于一些具有重要学术研究价值的经卷、书籍、契证等文物，经过洗污补托，如有残缺，不必求其复原，只把残缺处的色调全补得与通幅基本一致即可。</p>
          <p>俗话说：“三分画心，七分画裱”；人靠衣装，马靠鞍。书画作品也是这样，好的装裱，不仅能给作品带来保护作用，而且还能增加视觉上的美感效果</p>。
          <p>传统的手工装裱字画具有较长的保存时间，利于揭裱、修复作品，如若作品出现了败笔还可以进行补救，如：色垢、墨污、纸皱、残缺的处理等。同时要注意使用作品原有的绘画笔触、润色，这样能使得画面色彩更加润泽、亮丽、协调。可以增加作品的艺术神韵效果。</p>
          <p>全手工宣纸，绫绢的裱件做工精细、腹背进行压光处理，石蜡打磨保持色彩的亮丽感，手感触摸光滑柔软，相当有质感效果。</p>
          <p>字画在进行装裱之后，装饰在家庭、办公场所，可起到锦绣添花的装饰效果。使作品更显的大方美观，而且也使得作品永久的保存、珍藏。</p> 
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