$(function(){
    $(".navbar-nav li a").each(function () {
        if ("/" +$(this).attr("href") ===  location.pathname) {
            $(this).addClass("myactive");
        } 
    });
})

