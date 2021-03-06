<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>

<title>关于我们</title>

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
      <h2>关于我们</h2>
      <div class="con">当前位置：首页》关于我们</div>
    </div>
    <div class="detailbox">
      <div class="xq">
        <div class="con">
          <p>书画是绘画和书法的统称。画，是人们生活中创造的结晶，画的起源久远，有着丰富的意思。"画中有诗，诗中有画"，中国古代，诗与画分不开。画的作品也体现了作者的情感和思想，画中常常包含着艺术家强烈的思想感情，因此艺术也深深地孕育在画中。书，一说是书法，也就是俗话说的所谓的字，另一种观点则认为书是指文化内涵。由此可知，书画是指绘画和书法，也可以理解为具有文化内涵的绘画。</p>
          <p>书画是书法和绘画的统称。也称字画。</p>
          <p>书，即是俗话说的所谓的字，但不是一般人写的字，一般写字，只求正确无讹，在应用上不发生错误即可。倘若图书馆和博物馆把一般人写的字收藏起来，没有这个必要。图书馆和博物馆要保存的是字中的珍品。历史上有名的书法家写的真迹，在写字技巧上有很多创造或独具一格的，我们称之为书法艺术。书法艺术价值很高的，才有资格进入图书馆和博物馆。中国的书法是一种富有民族特色的传统艺术，它伴随着汉字的产生和发展一直延续到今天，经过历代书法名家的熔炼和创新，形成了丰富多彩的宝贵遗产，今天图书馆和博物馆保存它，鉴别它，其目的是使来者更好地继承和发扬这份遗产，以期达到更高的艺术水平，创造出更新的艺术风格，尽快地在书法艺术园地里开放出更多更美好的花朵，焕发出它的绚丽的青春。</p>
          <p>书画六品</p>
          <p>1 "真品" 真画值钱，假画不值钱，这点道理人人皆知。即使假画比真画画得还要好，但因为它是假的，也一样不值钱。真品里面又存在原作或是新作的问题。在特定背景、特定情绪下创作出来的作品和后来创作的作品，其收藏价值也是不一样的。</p>
          <p>2 "精品" 一个画家一辈子可以创作很多作品，但不是每件作品都是代表作。因为它与画家当时的情感、精神等各种因素都有关系，这些因素在笔墨之间都会不自觉地流露出来。</p>
          <p>3 "名品" 大家当然都愿意收藏名家的作品，但名家又分大名家和小名家、"真"名家和"虚"名家，这些都要搞清楚。名家的东西，一般来讲应该都是好的，因为他们中大多数都很认真，不好的东西一般不愿意往外拿。当然，也有的名家为了应酬或挣些润笔费，随便画两笔送人，但明眼人一眼就能看出来。</p>
          <p>4 "稀品" 清末和辛亥革命前的油画作品很少，因此很珍贵，有的甚至是国宝，必须由国家收藏。这样的画不见得画得有多好，但因为它稀少，是绝品、是历史的积淀，物以稀为贵。</p>
          <p>5 "特品" 即特定时期的作品。一位新加坡的收藏家很想收藏一些"文革"时期的作品，但因为那时这类作品既不展览也不印刷，于是他就收藏跟它有关的东西，现在这些藏品也很值钱了。</p>
          <p>6 "完品" 和瓷器一样，一件美术作品只有完整无损才更有收藏价值。</p>
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