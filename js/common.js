$(function(){
    console.log($(".navbar-nav li a").length)
    $(".navbar-nav li a").each(function () {
        // var $li = $(this).parent();
        console.log("aaaaaaaa")
        // console.log($(this).attr("href"));
        if ("/" +$(this).attr("href") ===  location.pathname) {
            $(this).addClass("myactive");
        } 
    });
})

