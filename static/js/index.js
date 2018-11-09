$(function(){
    //视频播放时隐藏poster-img的div
    $("#swim-video").bind("play",function(){
       $(this).css('background','none');
    });
})
