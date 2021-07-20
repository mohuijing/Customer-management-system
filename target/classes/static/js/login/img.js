layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test1'
        ,width: '100%' //设置容器宽度
        ,height:'435px'//按比例和浏览器可视页面宽度来获取高度
        ,arrow: 'hover' //始终显示箭头
        ,anim: 'default' //切换动画方式
    });
});

var carousel = layui.carousel;
//触发轮播切换事件
carousel.on('change(test1)', function(obj){ //test1来源于对应HTML容器的 lay-filter="test1" 属性值
    console.log(obj.index); //当前条目的索引
    console.log(obj.prevIndex); //上一个条目的索引
    console.log(obj.item); //当前条目的元素对象
});