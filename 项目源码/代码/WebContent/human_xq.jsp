<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>
<title></title>
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

<body>
<div class="header">
  <div class="main">
     <a href="index.jsp"><img src="images/logo.png" /></a>
  </div>
</div>
<div class="clear"></div>
<div class="nav">
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
      <h2>产品展示</h2>
      <div class="con">当前位置：首页》产品展示</div>
    </div>
    <div class="detailbox">
      <div class="xq">
        <div class="tit">人物画简介</div>
        <div class="date">发表时间：2020-9-21  点击量：9999</div>
        <img src="images/humanlogo.jpg" width="50%"/>
        <div class="con">
          <p>人物画是绘画的一种，以人物形象为主体的绘画之通称。</p>
          <p>中国的人物画，简称“人物”，是中国画中的一大画科，出现较山水画、花鸟画等为早；大体分为道释画、仕女画、肖像画、风俗画、历史故事画等。人物画力求人物个性刻画得逼真传神，气韵生动、形神兼备。其传神之法，常把对人物性格的表现，寓于环境、气氛、身段和动态的渲染之中，故中国画论上又称人物画为“传神”。历代著名人物画有东晋顾恺之的《洛神赋图》卷，五代南唐顾闳中的《韩熙载夜宴图》，北宋李公麟的《维摩诘像》，南宋李唐的《采薇图》等。现代数字人物画技术已广受大众喜爱，很多人把重画好的肖像照片送给老人，亲朋好友当礼物，成为一种时尚。</p>
          <p>随着计算机数字技术的发展，电脑软件功能的日益成熟，在一些数字化画图软件带动下，人物画技术已经进入无所不能，创造奇迹的时代。让人物画飞跃发展的代表软件Adobe Photoshop也已应用在很多领域，让大面积破损，模糊不清的黑白人物画，回复到高清晰彩色的人物画。现代数字人物画技术已广受大众喜爱，很多人把重画好的肖像照片送给老人，亲朋好友当礼物。数字人物画已经成为一种时尚。</p>
          <p>人物画(英文：Figure painting)的产生早于其他中国画科。在周代即有劝善戒恶的历史人物壁画。至战国秦汉，以历史现实或神话中人物故事和人物活动为题材的作品大量涌现。</p>
          <p>中国人物画家主张：以形写神、形神兼备。紧紧抓住有利于传神的眼神、手势、身姿与重要细节，强调分别主次，有详有略，详于传情的面部手势而略于衣冠，详于人物活动及其顾盼呼应而略于环境描写。在人物活动与环境景物的关系上，抒情性的作品往往借创造意境氛围烘托人物情态，叙事性的作品在采取横幅或长卷构图中，尤善于以环境景物或室内陈设划分空间，采用主体人物重复出现的方法，把发生在时间过程中的事件一一铺叙，突破了统一时空的局限。人物画中使用的笔墨技巧与技法，在工笔设色、白描和小写意作品中，更重视笔法的基干作用，为此创造了十八描。笔法或描法一方面服从于形象的结构质感、量感与神情，另方面也要传达作者的感情，同时还用以体现作者的个人风格。在写意人物画中，笔墨相互为用，笔中有墨，墨中有笔，一笔落纸，既要状物传神，又要抒情达意，还要显现个人风格，其难易程度远胜于山水花鸟画。被称为行乐图的人物肖像画，一律把人物置于最易展现其气质品格的特定景物中，具有不同于一般肖像画的特点。在色彩使用与诗书画印的结合上 ，人物画具有一般中国画的特色。</p>
          <p>在中国传统绘画中，肖像画与人物画的创作客体都是人，都以客观存在的人物作为观察对象和创作素材。但是，在转化为艺术形象时，肖像画有着比人物画更为现实而具体的要求。首选，肖像画讲求真实性。肖像画描绘的必须是客观存在的、具体的、特定的某个人，是在现实生活中或历史上实际存在的真人。而人物画则可通过概括、综合甚至想象，创作出非特定的、类型化的甚至虚构的人物形象。中国古代肖像画人十分重视“实有其人”，古时称肖像画为“写真”、“写照”、“写影”。许多论述肖像画的理论也把观察和刻画真实人物作为创作的出发点。如东晋·顾恺之“实对”理论，南齐·谢赫“应物象形”概念，宋·苏轼“灯下取影”，元·王铎“写像秘诀”，清·蒋骥“以远取神”方法。肖像画的社会功能、作用主要为真人写貌留影，再现客观现实，发挥认识功能，同时作为纪念、供奉、鉴戒的图像，达到教化目的。唐·张彦远在《历代名画记》中指出：“以忠以孝，尽在于云台。有烈有勋，皆登于麟阁。见善足以戒恶，见恶足以思贤。留乎形容，式昭盛德之事。具其成败，以传既往之踪。”肖像画要求“外形酷似”。</p>
          <p>人物画基本技法：无论中外，在早期绘画的发展史上，都以人物画为主，而且都为宗教或政治服务。从续发掘的古代帛画或壁画中，可以见到古代的帝王、功臣、圣贤或文人们的面貌，有浓 厚的政教功能，也有古人信奉的佛、菩萨、罗汉等释道人物，甚至更早的神话传说，充满的神秘的宗教色彩，尚可见到描写现实生活百态的风俗画、表现宫廷唯美趣味的仕女画及戏曲中的人物故事画等，各种不同形式与题材的人物画，都有细致的感情描写，和惟妙惟肖的形象刻画，给观赏者带来深刻的美感。</p>
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